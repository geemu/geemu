package com.chenfangming.manage.config.exception;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpServletResponseWrapper;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * HttpServletResponse装饰器
 * @author 陈方明  cfmmail@sina.com
 * @since 2019-07-07 20:28
 */
public class ErrorResponseWrapper extends HttpServletResponseWrapper {

    private int status;

    private String message;

    private boolean hasError = false;

    public ErrorResponseWrapper(HttpServletResponse response) {
        super(response);
    }

    @Override
    public void sendError(int status, String message) {
        this.status = status;
        this.message = message;
        this.hasError = true;
    }

    @Override
    public void sendError(int status) {
        sendError(status, null);
    }

    @Override
    public int getStatus() {
        if (this.hasError) {
            return this.status;
        }
        return super.getStatus();
    }

    private void sendErrorIfNecessary() throws IOException {
        if (this.hasError && !isCommitted()) {
            ((HttpServletResponse) getResponse()).sendError(this.status, this.message);
        }
    }

    public String getMessage() {
        return this.message;
    }

    public boolean hasError() {
        return this.hasError;
    }

    @Override
    public ServletOutputStream getOutputStream() throws IOException {
        sendErrorIfNecessary();
        return super.getOutputStream();
    }

    @Override
    public PrintWriter getWriter() throws IOException {
        sendErrorIfNecessary();
        return super.getWriter();

    }

    @Override
    public void flushBuffer() throws IOException {
        sendErrorIfNecessary();
        super.flushBuffer();
    }


}

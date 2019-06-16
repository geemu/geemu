//package com.chenfangming.common.config.exception;
//
//import com.chenfangming.common.domain.DefaultResponseStatus;
//import com.chenfangming.common.domain.ResponseEntity;
//import lombok.extern.slf4j.Slf4j;
//import org.springframework.beans.factory.annotation.Value;
//import org.springframework.boot.web.servlet.error.ErrorController;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RestController;
//import org.springframework.web.util.WebUtils;
//
//import javax.servlet.http.HttpServletRequest;
//
///**
// * 非控制器异常处理、控制器异常处理
// * 已经配置了RestControllerAdvice，
// * 所以控制器异常不会进入到当前控制器，
// * 这边处理非控制器异常，如过滤器异常等
// * @author 陈方明  cfmmail@sina.com
// * @since 2019-06-15 18:52
// */
//@Slf4j
//@RestController
//@RequestMapping("${server.error.path:${error.path:/error}}")
//public class CustomErrorController implements ErrorController {
//
//    /** 错误路径 **/
//    @Value("${server.error.path:${error.path:/error}}")
//    private String error;
//
//    /**
//     * 处理非控制器异常
//     * @param request request
//     * @return ResponseEntity<BizException>
//     */
//    @RequestMapping
//    public ResponseEntity<BizException> handleError(HttpServletRequest request) {
//        Throwable throwable = (Throwable) request.getAttribute(WebUtils.ERROR_EXCEPTION_ATTRIBUTE);
//        if (null == throwable || !(throwable.getCause() instanceof BizException)) {
//            return new ResponseEntity<>(DefaultResponseStatus.INTERNAL_SERVER_ERROR);
//        }
//        return new ResponseEntity<>((BizException) throwable.getCause());
//    }
//
//    @Override
//    public String getErrorPath() {
//        return error;
//    }
//
//}

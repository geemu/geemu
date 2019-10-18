package com.chenfangming.esb.request;

import com.chenfangming.esb.EsbStyle;
import lombok.extern.slf4j.Slf4j;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;

/**
 * com.chenfangming.esb.client
 * @author 陈方明  cfmmail@sina.com
 * @since 2019-10-16 21:54
 */
@Slf4j
public class Utils {

    /**
     * 创建Document
     * @param text text
     * @return Document
     */
    public static Document getDocument(String text) {
        Document document = null;
        try {
            document = DocumentHelper.parseText(text);
        } catch (DocumentException e) {
            log.error("转换:{}为XML文档对象异常:", text, e);
        }
        return document;
    }

    public static <T> T getFieldValue(Element element, EsbStyle style) {
        T t = null;

        return t;
    }

    public static <T> T getStructValue(Element element, EsbStyle style) {
        T t = null;

        return t;
    }

    public static <T> T getListValue(Element element, EsbStyle style) {
        T t = null;

        return t;
    }

}

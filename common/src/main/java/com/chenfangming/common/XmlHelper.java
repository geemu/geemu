package com.chenfangming.common;

import lombok.extern.slf4j.Slf4j;
import org.w3c.dom.Document;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.stream.Collectors;

/**
 * Xml工具类
 * @author 陈方明  cfmmail@sina.com
 * @since 2019-04-30 21:31
 */
@Slf4j
public final class XmlHelper {

    public static void main(String[] args) {
        InputStream inputStream = XmlHelper.class.getClassLoader().getResourceAsStream("test.xml");
        if (null == inputStream) {
            log.error("[InputStream]为空");
            return;
        }
        String xml = new BufferedReader(new InputStreamReader(inputStream)).lines().collect(Collectors.joining(System.lineSeparator()));
        log.info("xml文档为:{}", xml);
        StringReader reader = new StringReader(xml);
        InputSource inputSource = new InputSource(reader);

        DocumentBuilder documentBuilder = createDocumentBuilder();
        if (null == documentBuilder) {
            log.error("创建DocumentBuilder失败");
            return;
        }
        Document document;
        try {
            document = documentBuilder.parse(inputSource);
        } catch (SAXException | IOException e) {
            log.error("创建Document异常:{}{}", e, "");
            return;
        }
        log.info("document为：{}", document);
    }

    /**
     * 创建 DocumentBuilder
     * @return DocumentBuilder
     */
    public static DocumentBuilder createDocumentBuilder() {
        final DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder;
        try {
            builder = dbf.newDocumentBuilder();
        } catch (ParserConfigurationException e) {
            log.error("创建DocumentBuilder异常：{}{}", e, "");
            return null;
        }
        return builder;
    }

}

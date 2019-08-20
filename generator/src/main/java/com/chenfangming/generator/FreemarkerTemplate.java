package com.chenfangming.generator;

import freemarker.template.Configuration;
import freemarker.template.Template;
import lombok.extern.slf4j.Slf4j;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Freemarker模板引擎
 * @author 陈方明  cfmmail@sina.com
 * @since 2019-08-18 19:44
 */
@Slf4j
public final class FreemarkerTemplate {

    private Configuration configuration;

    public FreemarkerTemplate init() {
        configuration = new Configuration(Configuration.DEFAULT_INCOMPATIBLE_IMPROVEMENTS);
        configuration.setDefaultEncoding(StandardCharsets.UTF_8.name());
        configuration.setClassForTemplateLoading(FreemarkerTemplate.class, "/");
        return this;
    }

    public void writer(Map<String, Object> objectMap, String templatePath, String outputFile) throws Exception {
        Template template = configuration.getTemplate(templatePath);
        try (FileOutputStream fileOutputStream = new FileOutputStream(outputFile)) {
            template.process(objectMap, new OutputStreamWriter(fileOutputStream, StandardCharsets.UTF_8.name()));
        }
        log.info("模板:{},文件:{}", templatePath, outputFile);
    }


    public String templateFilePath(String filePath) {
        return filePath + ".ftl";
    }

    /**
     * 输出 java xml 文件
     */
    public FreemarkerTemplate batchOutput() {
        try {
            List<TableInfo> tableInfoList = new ArrayList<>();
            for (TableInfo tableInfo : tableInfoList) {

            }
        } catch (Exception e) {
            log.error("无法创建文件，请检查配置信息！", e);
        }
        return this;
    }

    private static final String TEMPLATE_PATH = "E:\\cloud\\generator\\src\\main\\resources\\templates";
    private static final String CLASS_PATH = "E:\\cloud\\generator\\src\\main\\java\\com\\chenfangming\\generator";

    public static void main(String[] args) throws Exception {
        Configuration configuration = new Configuration(Configuration.DEFAULT_INCOMPATIBLE_IMPROVEMENTS);
        Writer out = null;
        configuration.setDirectoryForTemplateLoading(new File(TEMPLATE_PATH));
        Map<String, Object> map = new HashMap<>(16);
        Pkg pkg = Pkg
            .builder()
            .mapper("com.chenfangming.test")
            .build();
        map.put("package", pkg);
        TableInfo table = TableInfo
            .builder()
            .comment("测试Mapper接口")
            .mapperName("TestMapper")
            .build();
        map.put("table", table);
        map.put("author", "陈方明");
        map.put("mail", "cfmmail@sina.com");
        map.put("date", new Date());
        Template template = configuration.getTemplate("mapper.java.ftl");
        File docFile = new File(CLASS_PATH + "\\" + "TestMapper.java");
        out = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(docFile)));
        template.process(map, out);
        System.out.println("^^^^^^^^^^^^^^^^^^^^^^^^TestMapper.java 文件创建成功 !");
    }

}

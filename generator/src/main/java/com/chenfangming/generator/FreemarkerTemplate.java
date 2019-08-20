package com.chenfangming.generator;

import freemarker.template.Configuration;
import freemarker.template.Template;
import lombok.extern.slf4j.Slf4j;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * Freemarker模板引擎
 * @author 陈方明  cfmmail@sina.com
 * @since 2019-08-18 19:44
 */
@Slf4j
public final class FreemarkerTemplate {

    private static final String TEMPLATE_PATH = "src/main/resources/templates";
    private static final String CLASS_PATH = "src/main/java/com/chenfangming/test";

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
        map.put("author", "陈方明");
        map.put("date", new Date());
        Template template = configuration.getTemplate("mapper.java.ftl");
        File docFile = new File(CLASS_PATH + "\\" + "TestMapper.java");
        out = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(docFile)));
        template.process(map, out);
        System.out.println("^^^^^^^^^^^^^^^^^^^^^^^^TestMapper.java 文件创建成功 !");
    }

}

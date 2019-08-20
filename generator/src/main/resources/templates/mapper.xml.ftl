<?xml version="1.0" encoding="UTF-8"?>
<!DOCTYPE mapper PUBLIC "-//mybatis.org//DTD Mapper 3.0//EN" "http://mybatis.org/dtd/mybatis-3-mapper.dtd">
<mapper namespace="${package.mapper}.${table.mapperName}">

    <resultMap id="BASE_RESULT_MAP" type="${package.entity}.${table.entityName}">
        <#list table.tableFieldList as field>
            <#if field.key>
                <id column="${field.jdbcName}" property="${field.javaName}"/>
            </#if>
        </#list>
        <#list table.fieldList as field>
            <#if !field.key>
                <result column="${field.jdbcName}" property="${field.javaName}"/>
            </#if>
        </#list>
    </resultMap>

    <sql id="Base_Column_List">
        <#list table.tableFieldList as field>
            ${field.jdbcName},
        </#list>
    </sql>

</mapper>

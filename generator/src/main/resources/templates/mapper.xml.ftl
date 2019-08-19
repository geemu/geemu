<?xml version="1.0" encoding="UTF-8"?>
<!DOCTYPE mapper PUBLIC "-//mybatis.org//DTD Mapper 3.0//EN" "http://mybatis.org/dtd/mybatis-3-mapper.dtd">
<mapper namespace="${mapper.package}.${mapper.name}">

    <resultMap id="BASE_RESULT_MAP" type="${entity.package}.${entity.name}">
        <#list xml.fieldList as field>
            <#if field.keyFlag>
                <id column="${field.column}" property="${field.property}"/>
            </#if>
        </#list>
        <#list xml.fieldList as field>
            <#if !field.keyFlag>
                <result column="${field.column}" property="${field.property}"/>
            </#if>
        </#list>
    </resultMap>

    <sql id="Base_Column_List">
        <#list xml.fieldList as field>
            ${field.column},
        </#list>
    </sql>

</mapper>

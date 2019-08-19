package com.chenfangming.generator;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.io.Serializable;

/**
* ${entity.comment}
* @author ${author} ${mail}
* @since ${date}
*/
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Accessors(chain = true)
@ApiModel(value = "${entity.comment}", description = "${entity.comment}")
public class ${entity.name} implements Serializable {

    /** 序列化id **/
    private static final long serialVersionUID = -1L;

    <#list entity.fieldList as field>
    /** ${field.comment} **/
    @ApiModelProperty(value = "${field.comment}")
    private ${field.type} ${field.name};
    </#list>

}

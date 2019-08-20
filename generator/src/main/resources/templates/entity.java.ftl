package ${entity.package};

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
<#list table.pkgSet as pkg>
    import ${pkg};
</#list>
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.io.Serializable;

/**
* ${table.comment}
* @author ${author} ${mail}
* @since ${date}
*/
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Accessors(chain = true)
@ApiModel(value = "${table.comment}", description = "${table.comment}")
public class ${table.entityName} implements Serializable {

    /** 序列化id **/
    private static final long serialVersionUID = -1L;

<#list table.tableFieldList as field>
    /** ${field.comment} **/
    @ApiModelProperty(value = "${field.comment}")
    private ${field.javaType.type} ${field.javaName};
    </#list>

}

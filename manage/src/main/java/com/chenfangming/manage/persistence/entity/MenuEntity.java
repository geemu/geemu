package com.chenfangming.manage.persistence.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;


/**
 * 权限菜单数据表
 * @author 陈方明  cfmmail@sina.com
 * @since 2018-10-25 20:36
 */
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString(callSuper = true)
@TableName(value = "backend_menu")
@EqualsAndHashCode(callSuper = true)
public class MenuEntity extends BaseEntity implements Serializable {

    /** 序列化id **/
    private static final long serialVersionUID = -1L;

    /** 权限id **/
    @TableId(type = IdType.AUTO)
    private Long id;
    /** 上级权限id 0是顶级id **/
    private Long pid;
    /** 菜单名称  不区分大小写 **/
    private String name;
    /** 菜单类型  0目录  1菜单  2按钮 **/
    private Integer type;
    /** 请求方法 POST DELETE PUT GET 目录没有方法 菜单有方法 按钮有方法 **/
    private String method;
    /** 请求路径 目录没有pattern 菜单是路径 按钮有pattern **/
    private String pattern;
    /** 用于按钮的隐藏 0新增 1删除 2修改 3查询 4导入 5导出 **/
    private Integer operate;
    /** 排序  数值越大越靠后 **/
    private Integer sort;
    /** 备注 **/
    private String remark;
    /** 是否可用  0不可用  1可用 **/
    private Boolean enabled;

}

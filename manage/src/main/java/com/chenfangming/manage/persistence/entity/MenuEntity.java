package com.chenfangming.manage.persistence.entity;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;


/**
 * 权限菜单数据表
 * @author 陈方明  cfmmail@sina.com
 * @since 2018-10-25 20:36
 */
@Data
public class MenuEntity implements Serializable {

    /** 序列化id **/
    private static final long serialVersionUID = -1L;

    /** 主键  权限菜单id **/
    private Long id;
    /** 上级权限菜单id 0是顶级id **/
    private Long pid;
    /** 权限名称 **/
    private String name;
    /** 资源类型  0目录  1菜单  2按钮 **/
    private Integer type;
    /** 请求方法 POST DELETE PUT DELETE **/
    private String method;
    /** 请求路径 **/
    private String path;
    /** 排序权重值  数值越大越靠后 **/
    private Integer sort;
    /** 创建人 **/
    private String createUser;
    /** 创建时间 **/
    private Date createTime;
    /** 更新人 **/
    private String updateUser;
    /** 更新时间 **/
    private Date updateTime;
}

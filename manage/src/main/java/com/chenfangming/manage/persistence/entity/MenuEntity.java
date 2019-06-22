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

    /** 权限id **/
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
    /** 创建人 **/
    private String createUser;
    /** 创建时间 **/
    private Date createTime;
    /** 更新人 **/
    private String updateUser;
    /** 更新时间 **/
    private Date updateTime;
}

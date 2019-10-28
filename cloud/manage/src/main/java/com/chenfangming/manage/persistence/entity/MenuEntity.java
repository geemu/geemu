package com.chenfangming.manage.persistence.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.util.Date;


/**
 * 权限菜单数据表
 * @author 陈方明  cfmmail@sina.com
 * @since 2018-10-25 20:36
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Accessors(chain = true)
@ToString(callSuper = true)
public class MenuEntity implements Serializable {

    /** 序列化id **/
    private static final long serialVersionUID = -1L;

    /** 权限id **/
    private Long menuId;
    /** 上级权限id 0是顶级id **/
    private Long parentId;
    /** icon **/
    private String icon;
    /** 菜单名称  不区分大小写 **/
    private String name;
    /** 菜单类型  0目录  1菜单  2按钮 **/
    private Byte type;
    /** 请求方法 目录没有方法 菜单有方法 按钮有方法 0:POST、1:DELETE、2:PUT、3:GET **/
    private Byte method;
    /** 请求路径 目录没有pattern 菜单是路径 按钮有pattern **/
    private String pattern;
    /** 用于按钮的隐藏 0:新增、1:删除、2:修改、3:查询、4:启用禁用、4:导入、5:导出 **/
    private Byte operate;
    /** 排序  数值越大越靠后 **/
    private Long sort;
    /** 备注 **/
    private String remark;
    /** 是否启用 true:启用、false:禁用 **/
    private Boolean enabled;
    /** 创建人 **/
    private String createUser;
    /** 创建时间 **/
    private Date createTime;
    /** 更新人 **/
    private String updateUser;
    /** 更新时间 **/
    private Date updateTime;
    /** 是否未删除 true:未删除、false:已删除 **/
    private Boolean nonDeleted;

}

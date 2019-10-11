package com.chenfangming.manage.persistence.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;
import java.util.Date;

/**
 * 角色权限关联数据表实体
 * @author 陈方明  cfmmail@sina.com
 * @since 2018-10-25 20:36
 */
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString(callSuper = true)
@TableName(value = "backend_role_menu")
@EqualsAndHashCode(callSuper = true)
public class RoleMenuEntity extends BaseEntity implements Serializable {

    /** 序列化id **/
    private static final long serialVersionUID = -1L;

    /** 主键  id **/
    @TableId(type = IdType.AUTO)
    private Long id;
    /** 角色id **/
    private Long roleId;
    /** 菜单id **/
    private Long menuId;
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

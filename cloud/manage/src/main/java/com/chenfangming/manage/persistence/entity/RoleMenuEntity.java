package com.chenfangming.manage.persistence.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import lombok.experimental.Accessors;

import java.io.Serializable;

/**
 * 角色权限关联数据表实体
 * @author 陈方明  cfmmail@sina.com
 * @since 2018-10-25 20:36
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Accessors(chain = true)
@ToString(callSuper = true)
public class RoleMenuEntity implements Serializable {

    /** 序列化id **/
    private static final long serialVersionUID = -1L;

    /** 主键  id **/
    private Long id;
    /** 角色id **/
    private Long roleId;
    /** 菜单id **/
    private Long menuId;

}

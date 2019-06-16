package com.chenfangming.manage.persistence.entity.view;

import com.chenfangming.manage.persistence.entity.MenuEntity;
import com.chenfangming.manage.persistence.entity.RoleEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;
import java.util.List;

/**
 * 一个角色对应多个资源
 * @author 陈方明  cfmmail@sina.com
 * @since 2019-06-16 21:44
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class RoleMenuView extends RoleEntity implements Serializable {

    /** 序列化id **/
    private static final long serialVersionUID = -1L;

    /** 角色对应的资源集合 **/
    private List<MenuEntity> menuEntityList;

}

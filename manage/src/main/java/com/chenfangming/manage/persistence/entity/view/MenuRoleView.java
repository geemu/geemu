package com.chenfangming.manage.persistence.entity.view;

import com.chenfangming.manage.persistence.entity.MenuEntity;
import com.chenfangming.manage.persistence.entity.RoleEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;
import java.util.List;

/**
 * 一个资源对应多个角色
 * @author 陈方明  cfmmail@sina.com
 * @since 2019-06-16 18:52
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class MenuRoleView extends MenuEntity implements Serializable {

    /** 序列化id **/
    private static final long serialVersionUID = 1L;

    /** 资源对应的角色集合 **/
    private List<RoleEntity> roleEntityList;

}

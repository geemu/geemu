package com.chenfangming.manage.persistence.entity.view;

import com.chenfangming.manage.persistence.entity.RoleEntity;
import com.chenfangming.manage.persistence.entity.UserEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;

/**
 * 一个用户对应多个角色
 * @author 陈方明  cfmmail@sina.com
 * @since 2019-06-16 21:43
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class UserRoleView extends UserEntity implements Serializable {

    /** 序列化id **/
    private static final long serialVersionUID = 1L;

    /** 用户对应的角色集合 **/
    private List<RoleEntity> roleEntityList;

}

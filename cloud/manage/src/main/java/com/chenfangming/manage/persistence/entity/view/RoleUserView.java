package com.chenfangming.manage.persistence.entity.view;

import com.chenfangming.manage.persistence.entity.RoleEntity;
import com.chenfangming.manage.persistence.entity.UserEntity;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;
import java.util.List;

/**
 * 一个角色对应多个用户
 * @author 陈方明  cfmmail@sina.com
 * @since 2019-06-16 21:45
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
public class RoleUserView extends RoleEntity implements Serializable {

    /** 序列化id **/
    private static final long serialVersionUID = -1L;

    /** 角色对应的用户集合 **/
    private List<UserEntity> userEntityList;

}

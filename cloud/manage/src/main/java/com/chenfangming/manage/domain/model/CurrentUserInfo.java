package com.chenfangming.manage.domain.model;

import com.chenfangming.manage.persistence.entity.RoleEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.util.List;

/**
 * 当前登录用户
 * @author 陈方明  cfmmail@sina.com
 * @since 2019-08-12 20:32
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Accessors(chain = true)
@ToString(callSuper = true)
public class CurrentUserInfo implements Serializable {

    /** 序列化id **/
    private static final long serialVersionUID = -1L;

    /** 登录用户 **/
    public static final String LOGIN_USER = "LOGIN_USER:";

    /** 用户id **/
    private Long userId;
    /** 用户姓名 **/
    private String username;
    /** 角色列表 **/
    private List<RoleEntity> roleEntityList;

}

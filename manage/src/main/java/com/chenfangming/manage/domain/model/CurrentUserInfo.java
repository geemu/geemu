package com.chenfangming.manage.domain.model;

import com.chenfangming.manage.persistence.entity.RoleEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

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
public class CurrentUserInfo implements Serializable {

    /** 序列化id **/
    private static final long serialVersionUID = 1L;

    /** 用户id **/
    private Long id;
    /** 用户姓名 **/
    private String name;
    /** 用户角色id集合 **/
    private List<RoleEntity> roleIdList;

}

package com.chenfangming.manage.persistence.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import lombok.experimental.Accessors;

import java.io.Serializable;

/**
 * 用户角色关联数据表
 * @author 陈方明  cfmmail@sina.com
 * @since 2018-10-25 20:35
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Accessors(chain = true)
@ToString(callSuper = true)
public class UserRoleEntity implements Serializable {

    /** 序列化id **/
    private static final long serialVersionUID = -1L;

    /** 主键  id **/
    private Long id;
    /** 用户id **/
    private Long userId;
    /** 角色id **/
    private Long roleId;

}

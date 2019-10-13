package com.chenfangming.manage.persistence.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;

/**
 * 用户角色关联数据表
 * @author 陈方明  cfmmail@sina.com
 * @since 2018-10-25 20:35
 */
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString(callSuper = true)
@TableName(value = "backend_user_role")
@EqualsAndHashCode(callSuper = true)
public class UserRoleEntity extends BaseEntity implements Serializable {

    /** 序列化id **/
    private static final long serialVersionUID = -1L;

    /** 主键  id **/
    @TableId(type = IdType.AUTO)
    private Long id;
    /** 用户id **/
    private Long userId;
    /** 角色id **/
    private Long roleId;
    /** 是否可用  0不可用  1可用 **/
    private Boolean enabled;

}

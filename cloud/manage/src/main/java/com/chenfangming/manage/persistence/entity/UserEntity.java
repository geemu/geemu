package com.chenfangming.manage.persistence.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.util.Date;


/**
 * 用户数据表
 * @author 陈方明  cfmmail@sina.com
 * @since 2018-10-25 20:34
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Accessors(chain = true)
@ToString(callSuper = true)
public class UserEntity implements Serializable {

    /** 序列化id **/
    private static final long serialVersionUID = -1L;

    /** 主键  用户id **/
    private Long userId;
    /** 用户名  忽略大小写 **/
    private String username;
    /** 密码  区分大小写 **/
    private String password;
    /** 备注 **/
    private String remark;
    /** 是否启用 true:启用、false:禁用 **/
    private Boolean enabled;
    /** 创建人 **/
    private String createUser;
    /** 创建时间 **/
    private Date createTime;
    /** 更新人 **/
    private String updateUser;
    /** 更新时间 **/
    private Date updateTime;
    /** 是否未删除 true:未删除、false:已删除 **/
    private Boolean nonDeleted;

}

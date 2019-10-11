package com.chenfangming.manage.persistence.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;

/**
 * 基础实体
 * @author 陈方明  cfmmail@sina.com
 * @since 2019-10-11 21:26
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public abstract class BaseEntity implements Serializable {

    /** 序列化id **/
    private static final long serialVersionUID = -1L;

    /** 创建人 **/
    @TableId(value = "create_user")
    private String createUser;
    /** 创建时间 **/
    @TableId(value = "create_time")
    private Date createTime;
    /** 更新人 **/
    @TableId(value = "update_user")
    private String updateUser;
    /** 更新时间 **/
    @TableId(value = "update_time")
    private Date updateTime;

}

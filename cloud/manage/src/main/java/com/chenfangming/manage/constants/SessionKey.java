package com.chenfangming.manage.constants;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * Session Key
 * @author 陈方明  cfmmail@sina.com
 * @since 2019-08-12 20:28
 */
@Getter
@AllArgsConstructor
public enum SessionKey {

    /** 当前登录用户 **/
    CURRENT_USER("当前登录用户");

    /** 描述 **/
    private String desc;

}

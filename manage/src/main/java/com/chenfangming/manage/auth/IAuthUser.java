package com.chenfangming.manage.auth;

import java.io.Serializable;

/**
 * 认证对象
 * @author 陈方明  cfmmail@sina.com
 * @since 2019-06-22 21:15
 */
public interface IAuthUser extends Serializable {

    /**
     * 账户名
     * @return 账户名
     */
    String getUserName();

    /**
     * 账户密码
     * @return 密码
     */
    String getPassword();

    /**
     * 账户可用
     * @return 账户是否可用
     */
    boolean enabled();

    /**
     * 账户未过期
     * @return 账户是否过期
     */
    boolean nonExpired();

    /**
     * 账户未锁定
     * @return 账户是否锁定
     */
    boolean nonLoked();

    /**
     * 认证未过期
     * @return 认证是否过期
     */
    boolean ticketNoExpired();

}

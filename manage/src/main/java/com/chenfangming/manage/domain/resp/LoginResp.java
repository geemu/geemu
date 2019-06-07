package com.chenfangming.manage.domain.resp;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 登录返回体
 * @author 陈方明  cfmmail@sina.com
 * @since 2019-06-07 13:10
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class LoginResp {

    /** 昵称 **/
    private String nickName;
    /** 真实姓名 **/
    private String actualName;
    /** 请求Token **/
    private String accessToken;
    /** 刷新Token **/
    private String refreshToken;

}

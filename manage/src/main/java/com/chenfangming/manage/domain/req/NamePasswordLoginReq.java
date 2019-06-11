package com.chenfangming.manage.domain.req;

import com.chenfangming.manage.util.Constants;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;

/**
 * 用户名密码登录请求体
 * @author 陈方明  cfmmail@sina.com
 * @since 2019-06-07 13:08
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class NamePasswordLoginReq {

    /** 用户名 **/
    @NotBlank(message = Constants.Tips.NAME_NOT_BLANK)
    private String name;
    /** 密码 **/
    @NotBlank(message = Constants.Tips.PASSWORD_NOT_BLANK)
    private String password;

}

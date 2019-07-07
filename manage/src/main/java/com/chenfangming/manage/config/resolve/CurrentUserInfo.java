package com.chenfangming.manage.config.resolve;

import lombok.Data;

import javax.validation.constraints.NotEmpty;
import java.io.Serializable;

/**
 * com.chenfangming.manage.config.resolve
 * @author 陈方明  cfmmail@sina.com
 * @since 2019-07-03 21:13
 */
@Data
public class CurrentUserInfo implements Serializable {

    private static final long serialVersionUID = -1L;

    @NotEmpty(message = "budasdad")
    private String id;

}

package com.chenfangming.common.test;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * com.chenfangming.common
 * @author 陈方明  cfmmail@sina.com
 * @since 2019-05-02 09:40
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class TestBean extends ParentBean {
    private String name;
    private String description;
    private Integer age;
}

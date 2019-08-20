package com.chenfangming.generator;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

/**
 * com.chenfangming.generator
 * @author 陈方明  cfmmail@sina.com
 * @since 2019-08-20 21:52
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Accessors(chain = true)
public class Pkg {

    private String mapper;
    private String entity;

}

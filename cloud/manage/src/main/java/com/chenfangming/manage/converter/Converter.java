package com.chenfangming.manage.converter;

import com.chenfangming.manage.domain.model.CurrentUserInfo;
import com.chenfangming.manage.persistence.entity.UserEntity;
import org.mapstruct.Mapper;
import org.springframework.stereotype.Component;

/**
 * Bean转换
 * @author 陈方明  cfmmail@sina.com
 * @since 2019-10-29 21:53
 */
@Component
@Mapper(componentModel = "spring")
public interface Converter {

    /**
     * UserEntity转CurrentUserInfo
     * @param source UserEntity
     * @return CurrentUserInfo
     */
    CurrentUserInfo converterUserEntity2CurrentUserInfo(UserEntity source);

}

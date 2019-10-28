//package com.chenfangming.manage.service.impl;
//
//import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
//import com.chenfangming.manage.config.exception.BaseResponse.BaseResponseState;
//import com.chenfangming.manage.config.exception.BizException;
//import com.chenfangming.manage.persistence.entity.UserEntity;
//import com.chenfangming.manage.persistence.mapper.UserMapper;
//import com.chenfangming.manage.service.UserService;
//import lombok.extern.slf4j.Slf4j;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
///**
// * 用户
// * @author 陈方明  cfmmail@sina.com
// * @since 2019-06-16 22:51
// */
//@Slf4j
//@Service
//public class UserServiceImpl implements UserService {
//
//    @Autowired
//    private UserMapper userMapper;
//
//    /**
//     * 新增用户
//     * @param userEntity 需要新增的用户列表
//     * @return 新增后的用户id
//     */
//    @Override
//    public Long add(UserEntity userEntity) {
//        UserEntity exist = findByName(userEntity.getName());
//        if (null != exist) {
//            log.error("用户已存在:{}", userEntity.getName());
//            throw new BizException(BaseResponseState.USER_EXISTED, "用户已存在");
//        }
//        userMapper.insert(userEntity);
//        return userEntity.getId();
//    }
//
//    /**
//     * 根据用户名查询用户
//     * @param name 用户名
//     * @return 用户
//     */
//    @Override
//    public UserEntity findByName(String name) {
//        QueryWrapper<UserEntity> userEntityQueryWrapper = new QueryWrapper<>();
//        userEntityQueryWrapper.setEntity(UserEntity.builder().name(name).build());
//        return userMapper.selectOne(userEntityQueryWrapper);
//    }
//
//}

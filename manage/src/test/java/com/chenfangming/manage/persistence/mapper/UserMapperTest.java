package com.chenfangming.manage.persistence.mapper;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.chenfangming.manage.persistence.entity.UserEntity;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * com.chenfangming.manage.persistence.mapper
 * @author 陈方明  cfmmail@sina.com
 * @since 2019-10-11 21:19
 */
@Slf4j
@SpringBootTest
@RunWith(SpringRunner.class)
public class UserMapperTest {

    @Autowired
    private UserMapper userMapper;

    @Test
    public void testSelect() {
        QueryWrapper<UserEntity> userEntityQueryWrapper = new QueryWrapper<>();
        userEntityQueryWrapper.setEntity(UserEntity.builder().name("admin").build());
        UserEntity exist = userMapper.selectOne(userEntityQueryWrapper);
        log.info("{}", exist);
    }

}

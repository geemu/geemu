package com.chenfangming.manage.persistence.mapper;

import com.chenfangming.manage.persistence.entity.UserEntity;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

/**
 * com.chenfangming.manage.persistence.mapper
 * @author 陈方明  cfmmail@sina.com
 * @since 2019-10-11 21:19
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class UserMapperTest {

    @Autowired
    private UserMapper userMapper;

    @Test
    public void testSelect() {
        List<UserEntity> list = userMapper.selectList(null);
        for (UserEntity u : list) {
            System.out.println(u.toString());
        }
    }

}

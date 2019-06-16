package com.chenfangming.manage.service.impl;

import com.chenfangming.manage.persistence.entity.MenuEntity;
import com.chenfangming.manage.persistence.mapper.MenuMapper;
import com.chenfangming.manage.service.MenuServicce;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * com.chenfangming.manage.service.impl
 * @author 陈方明  cfmmail@sina.com
 * @since 2019-06-16 19:34
 */
@Slf4j
@Service
@AllArgsConstructor
public class MenuServiceImpl implements MenuServicce {

    private MenuMapper menuMapper;

    /**
     * 查询所有资源
     * @return 所有正常的资源
     */
    @Override
    public List<MenuEntity> select() {
        menuMapper.selectAll();
        return null;
    }
}

package com.guochunhao.springframework.boot.service.impl;

import com.guochunhao.springframework.boot.mapper.UserMapper;
import com.guochunhao.springframework.boot.model.User;
import com.guochunhao.springframework.boot.service.UserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * Created by count on 17/3/23.
 */
@Service
public class UserServiceImpl implements UserService
{
    @Resource
    private UserMapper userMapper;

    @Override
    public User selectOne(Integer id)
    {
        return userMapper.selectByPrimaryKey(id);
    }
}

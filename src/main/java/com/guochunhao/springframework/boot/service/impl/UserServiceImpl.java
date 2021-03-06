package com.guochunhao.springframework.boot.service.impl;

import com.guochunhao.springframework.boot.mapper.UserExtMapper;
import com.guochunhao.springframework.boot.mapper.UserMapper;
import com.guochunhao.springframework.boot.model.User;
import com.guochunhao.springframework.boot.model.UserExt;
import com.guochunhao.springframework.boot.service.UserExtService;
import com.guochunhao.springframework.boot.service.UserService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

/**
 * Created by count on 17/3/23.
 */
@Service
public class UserServiceImpl implements UserService
{
    @Resource
    private UserMapper userMapper;

    @Resource
    private UserExtService userExtService;

    @Override
    public User selectOne(Integer id)
    {
        return userMapper.selectByPrimaryKey(id);
    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public int addUser(User record) throws Exception
    {
        try
        {
            int i = userMapper.insertSelective(record);
//            i = 1 / 0;

            UserExt userExt = new UserExt();
            i = userExtService.addUserExt(userExt);

            return i;
        } catch (Exception e)
        {
            throw new Exception("插入失败");
        }

    }
}

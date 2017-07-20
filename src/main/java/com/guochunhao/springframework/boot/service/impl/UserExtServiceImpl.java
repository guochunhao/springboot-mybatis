package com.guochunhao.springframework.boot.service.impl;

import com.guochunhao.springframework.boot.mapper.UserExtMapper;
import com.guochunhao.springframework.boot.mapper.UserMapper;
import com.guochunhao.springframework.boot.model.User;
import com.guochunhao.springframework.boot.model.UserExt;
import com.guochunhao.springframework.boot.service.UserExtService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

/**
 * Created by count on 17/3/23.
 */
@Service
public class UserExtServiceImpl implements UserExtService
{
    @Resource
    private UserExtMapper userExtMapper;

    @Transactional
    @Override
    public int addUserExt(UserExt record) throws Exception
    {
        try
        {
            record.setCompany("天源");
            record.setCoordinate("123");
            record.setUserId(12);

            int i = userExtMapper.insertSelective(record);

//            i = 1 / 0;
            return i;
        } catch (Exception e)
        {
            throw new Exception("插入失败");
        }
    }
}

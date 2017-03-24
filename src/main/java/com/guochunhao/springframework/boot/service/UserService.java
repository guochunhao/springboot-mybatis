package com.guochunhao.springframework.boot.service;

import com.guochunhao.springframework.boot.model.User;

/**
 * Created by count on 17/3/23.
 */
public interface UserService
{
    User selectOne(Integer id);

}

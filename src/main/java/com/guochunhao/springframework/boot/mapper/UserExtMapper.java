package com.guochunhao.springframework.boot.mapper;

import com.guochunhao.springframework.boot.model.UserExt;
import com.guochunhao.springframework.boot.model.UserExtExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface UserExtMapper
{
    int countByExample(UserExtExample example);

    int deleteByExample(UserExtExample example);

    int deleteByPrimaryKey(Integer extId);

    int insert(UserExt record);

    int insertSelective(UserExt record);

    List<UserExt> selectByExample(UserExtExample example);

    UserExt selectByPrimaryKey(Integer extId);

    int updateByExampleSelective(@Param("record") UserExt record, @Param("example") UserExtExample example);

    int updateByExample(@Param("record") UserExt record, @Param("example") UserExtExample example);

    int updateByPrimaryKeySelective(UserExt record);

    int updateByPrimaryKey(UserExt record);
}
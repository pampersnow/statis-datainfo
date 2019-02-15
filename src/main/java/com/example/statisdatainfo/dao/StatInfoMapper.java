package com.example.statisdatainfo.dao;

import com.example.statisdatainfo.entity.StatInfo;

public interface StatInfoMapper {
    int deleteByPrimaryKey(Integer statisticsid);

    int insert(StatInfo record);

    int insertSelective(StatInfo record);

    StatInfo selectByPrimaryKey(Integer statisticsid);

    int updateByPrimaryKeySelective(StatInfo record);

    int updateByPrimaryKey(StatInfo record);
}
package com.example.statisdatainfo.dao;

import com.example.statisdatainfo.entity.Docment;
import com.example.statisdatainfo.entity.DocmentWithBLOBs;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface DocmentMapper {
    int deleteByPrimaryKey(Integer docid);

    int insert(DocmentWithBLOBs record);

    int insertSelective(DocmentWithBLOBs record);

    DocmentWithBLOBs selectByPrimaryKey(Integer docid);

    int updateByPrimaryKeySelective(DocmentWithBLOBs record);

    int updateByPrimaryKeyWithBLOBs(DocmentWithBLOBs record);

    int updateByPrimaryKey(Docment record);

    @Select("select * from wcmdocument")
    List<Docment> selectDataInfo();
}
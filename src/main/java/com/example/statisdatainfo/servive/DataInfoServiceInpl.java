package com.example.statisdatainfo.servive;

import com.example.statisdatainfo.dao.DocmentMapper;
import com.example.statisdatainfo.entity.Docment;
import javafx.scene.control.Cell;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class DataInfoServiceInpl implements DataInfoService{

    @Resource
    DocmentMapper docmentMapper;
    @Autowired
    RedisTemplate<String, Object> template;

    @Override
    public List<Docment> selectDataInfo() {

        List<Docment> docmentList = docmentMapper.selectDataInfo();
        template.opsForList().rightPush("docmentList",docmentList);

        List<Object> list = template.opsForList().range("docmentList", 0, template.opsForList().size("docmentList")-1);

        System.out.println("数据量:"+template.opsForList().size("docmentList"));
        return docmentList;
    }
}

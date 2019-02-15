package com.example.statisdatainfo;

import com.example.statisdatainfo.StatisDatainfoApplication;
import com.example.statisdatainfo.dao.DocmentMapper;
import com.example.statisdatainfo.entity.Docment;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = StatisDatainfoApplication.class)
public class DataInfoTest {

    @Autowired
    DocmentMapper docmentMapper;

    @Test
    public void getDocmentMapper() {
        List<Docment> list = docmentMapper.selectDataInfo();
        for (Docment docment: list) {
            System.out.println(docment.getDocchannel());
        }
    }
}

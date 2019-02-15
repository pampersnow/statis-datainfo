package com.example.statisdatainfo.controller;

import com.example.statisdatainfo.dao.DocmentMapper;
import com.example.statisdatainfo.entity.Docment;
import com.example.statisdatainfo.servive.DataInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@Controller
public class DataInfoController {

    @Autowired
    private DataInfoService dataInfoService;

    @RequestMapping("/data")
    public String queDataInfo(Map<String,Object> map){
        List<Docment> list = dataInfoService.selectDataInfo();
        map.put("datalist",list);
        return "datainfo";
    }
}

package com.example.statisdatainfo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.statisdatainfo.dao.PruductDao;
import com.example.statisdatainfo.entity.Pruduct;

@Controller
public class HelloController {

	@Autowired
	PruductDao pruductDao;
	
	/**
	 * 查询出一条数据并且添加到缓存
	 * @param id
	 * @return
	 */
	@RequestMapping("/getPrud")
	@Cacheable("prudCache")
	public Pruduct getPrud(@RequestParam(required=true)String id){
		System.out.println("如果第二次没有走到这里说明缓存被添加了");
		return pruductDao.getPrud(Integer.parseInt(id));
	}
}

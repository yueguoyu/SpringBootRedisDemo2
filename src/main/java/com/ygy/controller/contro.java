package com.ygy.controller;

import com.ygy.model.Springbootdb;
import com.ygy.service.Dao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class contro {
  @Autowired
   private Dao dao;
    @RequestMapping("/")
    public String login(){
        return "main";
    }
    @RequestMapping("select")
    public String select(){
        System.out.println(this.dao.findById(1));
        return "main";
    }
    @RequestMapping("add")
    public String add(){
        Springbootdb springbootdb=new Springbootdb();
        springbootdb.setId(2);
        springbootdb.setName("ygy");
        this.dao.add(springbootdb);
        return "main";
    }
    @RequestMapping("delete")
    public String delete(){
        this.dao.delete(1);
        System.out.println("已删除");
        return "main";
    }
}

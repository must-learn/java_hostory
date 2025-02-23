package com.imooc.cp.controller;

import com.imooc.cp.biz.DepartmentBiz;
import com.imooc.cp.entity.Department;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Map;

@Controller("departmentController")

@RequestMapping("/department")
public class DepartmentController {

    @Autowired
    private DepartmentBiz departmentBiz;

    @RequestMapping("/list")
    public String list(Map<String,Object> map){
        map.put("list",departmentBiz.getAll());
        return "department_list";
    }
    @RequestMapping("/to_add")
    public String to_add(Map<String,Object> map){
        map.put("department",new Department());
        return "department_add";
    }
    @RequestMapping("/add")
    public String add(Department department){
        departmentBiz.add(department);
        return "redirect:list";
    }
    @RequestMapping(value = "/to_update",params = "sn")
    public String to_update(Map<String,Object> map,String sn){
        map.put("department",departmentBiz.get(sn));
        return "department_update";
    }
    @RequestMapping("/update")
    public String update(Department department){
        departmentBiz.edit(department);
        return "redirect:list";
    }
    @RequestMapping(value = "/remove",params = "sn")
    public String remove(String sn){
        departmentBiz.remove(sn);
        return "redirect:list";
    }

}

package com.imooc.cp.biz.impl;

import com.imooc.cp.biz.DepartmentBiz;
import com.imooc.cp.biz.EmployeeBiz;
import com.imooc.cp.dao.DepartmentDao;
import com.imooc.cp.dao.EmployeeDao;
import com.imooc.cp.entity.Department;
import com.imooc.cp.entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("employeeBiz")
public class EmployeeBizImpl implements EmployeeBiz {
    @Autowired
    private EmployeeDao employeeDao;

    public void add(Employee employee) {
        employee.setPassword("000000");
        employeeDao.insert(employee);
    }

    public void edit(Employee employee ) {
        employeeDao.update(employee);
    }

    public void remove(String sn) {
        employeeDao.delete(sn);
    }

    public Employee get(String sn) {
        return employeeDao.select(sn);
    }

    public List<Employee> getAll() { return employeeDao.selectAll(); }



}



package com.imooc.cp.dao;

import com.imooc.cp.entity.Employee;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("employeeDao")
public interface EmployeeDao {
    List<Employee> selectAll();
    void insert(Employee employee);
    void update(Employee employee);
    void delete(String sn);
    Employee select(String sn);
    List<Employee> selectByDepartmentAndPost(@Param("dsn") String dsn,@Param("post") String post);
}

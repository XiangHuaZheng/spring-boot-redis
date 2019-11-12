package com.hua.cache.service;

import com.hua.cache.bean.Employee;
import com.hua.cache.mapper.EmployeeMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

@Service
@CacheConfig(cacheNames = "emp")
public class EmployeeService {
    @Autowired
    EmployeeMapper employeeMapper;

    public void insertEmp(Employee employee){
        employeeMapper.insertEmp(employee);
    }

    //@CacheEvict(key = "#id")
    public void deleteEmp(Integer id){
        employeeMapper.deleteEmp(id);
    }

    @Cacheable(key = "#id")
    public Employee getEmp(Integer id) {
        System.out.println("查询"+id+"号员工");
        return employeeMapper.getEmpById(id);
    }

    @CachePut(key = "#result.id")
    public void updateEmp(Employee employee){
        employeeMapper.updateEmp(employee);
    }
}

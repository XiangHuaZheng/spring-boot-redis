package com.hua.cache.service;

import com.hua.cache.bean.Department;
import com.hua.cache.mapper.DepartmentMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

@Service
@CacheConfig(cacheNames = "dept")
public class DepartmentService {
    @Autowired
    DepartmentMapper departmentMapper;

    @Cacheable(key = "#id")
    public Department getDept(Integer id) {
        System.out.println("查询"+id+"号部门");
        return departmentMapper.getDeptById(id);
    }
}

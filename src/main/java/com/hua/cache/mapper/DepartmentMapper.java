package com.hua.cache.mapper;

import com.hua.cache.bean.Department;
import org.apache.ibatis.annotations.Select;

public interface DepartmentMapper {
    @Select("SELECT * FROM department WHERE id = #{id}")
    Department getDeptById(Integer id);
}

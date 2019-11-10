package com.hua.cache.mapper;

import com.hua.cache.bean.Employee;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

public interface EmployeeMapper {

    @Insert("INSERT INTO employee(lastName,email,gender,d_id) VALUE(#{lastName},#{email},#{gender},#{dId})")
    void insertEmp(Employee employee);

    @Delete("DELETE FROM employee WHERE id = #{id}")
    void deleteEmp(Integer id);

    @Select("SELECT * FROM employee WHERE id = #{id}")
    Employee getEmpById(Integer id);

    @Update("UPDATE employee SET lastName=#{lastName},email=#{email},gender=#{gender},d_id=#{dId} WHERE id=#{id}")
    void updateEmp(Employee employee);
}

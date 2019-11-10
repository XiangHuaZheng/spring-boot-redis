package com.hua.cache.controller;

import com.hua.cache.bean.Employee;
import com.hua.cache.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EmployeeController {
    @Autowired
    EmployeeService employeeService;

    @GetMapping("/emp/{id}")
    public Employee getEmployee(@PathVariable("id")Integer id){
        return employeeService.getEmp(id);
    }

    @GetMapping("/delEmp/{id}")
    public String deleteEmployee(@PathVariable("id")Integer id){
        employeeService.deleteEmp(id);
        return "delete Success";
    }

    @GetMapping("/emp")
    public void updateEmployee(Employee employee){
        employeeService.updateEmp(employee);
    }

    @GetMapping("/insertEmp")
    public void insertEmployee(Employee employee){
        employeeService.insertEmp(employee);
    }
}

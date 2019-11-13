package com.hua.cache.service;

import com.hua.cache.bean.Employee;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RabbitmqService {
    @Autowired
    EmployeeService employeeService;

    @RabbitListener(queues = "queue.emp")
    public void receive(Employee employee){
        System.out.println("处理消息队列");
        employeeService.updateEmp(employee);
    }
}

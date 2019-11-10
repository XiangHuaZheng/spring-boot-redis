package com.hua.cache;

import com.hua.cache.bean.Employee;
import com.hua.cache.mapper.EmployeeMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;

@SpringBootTest
class SpringBootCacheApplicationTests {
    @Autowired
    EmployeeMapper employeeMapper;

    @Autowired
    RedisTemplate redisTemplate;//操作K V都是对象

    @Autowired
    StringRedisTemplate stringRedisTemplate;//操作K V都是字符串

    @Test
    void testRedis(){
        stringRedisTemplate.opsForValue().append("msg","hello");
    }

    @Test
    void contextLoads() {
        Employee employee = employeeMapper.getEmpById(1);
        System.out.println(employee);
    }

}

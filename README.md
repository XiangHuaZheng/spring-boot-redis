# spring-boot-redis
10万次并发请求测试

Version 1

springboot+web应用+mybatis+druid+mysql
![image text](https://github.com/xiangHuaZZ/spring-boot-redis/blob/master/img/Stest.png)
平均8.17ms一次请求

Version 2

springboot+web应用+mybatis+druid+mysql+redis
![image text](https://github.com/xiangHuaZZ/spring-boot-redis/blob/master/img/redisTest.png)
平均1.32ms一次请求

Version 3
![image text](https://github.com/xiangHuaZZ/spring-boot-redis/blob/master/img/mqtest.png)
springboot+web应用+mybatis+druid+mysql+redis+rabbitmq
平均25.89ms一次请求

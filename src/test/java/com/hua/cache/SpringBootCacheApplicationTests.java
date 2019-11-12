package com.hua.cache;

import com.hua.cache.bean.Employee;
import com.hua.cache.service.EmployeeService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CountDownLatch;

@SpringBootTest
class SpringBootCacheApplicationTests {

    @Autowired
    EmployeeService employeeService;

    @Resource(name="asyncServiceExecutor")
    private ThreadPoolTaskExecutor taskExecutor;

    @Test
    public void test1() {
        //同步辅助类需要通过这个类来控制所有的线程都执行完成;
        List<String> list = new ArrayList<>();

        CountDownLatch countDownLatch = new CountDownLatch(1000);
        long l = System.currentTimeMillis();
        for (int i = 0; i < 1000; i++) {
            final int j = i;
            taskExecutor.execute(new Runnable() {
                @Override
                public void run() {
                    try {
                        System.out.println(Thread.currentThread().getName() + "---" + j);
                        Employee emp = employeeService.getEmp(1);
                        System.out.println(emp.toString());
                    } catch (Exception e) {
                        e.printStackTrace();
                    } finally {
                        countDownLatch.countDown();  //这个不管是否异常都需要数量减,否则会被堵塞无法结束
                    }
                }
            });
        }
        try {
            countDownLatch.await(); //保证之前的所有的线程都执行完成，才会走下面的；
            // 这样就可以在下面拿到所有线程执行完的集合结果
            long a = System.currentTimeMillis();
            System.out.println(a-l+"ms");
        } catch (Exception e) {
            System.out.println("阻塞异常");
        }
    }


/*    @Test
    public  void  test2()throws Exception{
        ExecutorService executorService = Executors.newCachedThreadPool();
        final Semaphore semaphore = new Semaphore(200);
        final CountDownLatch countDownLatch = new CountDownLatch(500);
        long l = System.currentTimeMillis();
        for (int i = 0; i < 200; i++) {
            final int count = i;
            executorService.execute(() -> {
                try {
                    semaphore.acquire();
                    Employee emp = employeeService.getEmp(2);
                    System.out.println(emp.toString());
                    semaphore.release();
                } catch (Exception e) {
                    // log.error("exception" , e);
                }
                countDownLatch.countDown();
            });
        }
        countDownLatch.await();
        long a = System.currentTimeMillis();
        System.out.println(a-l);

        executorService.shutdown();

        //log.info("size:{}" , map.size());
    }*/

    /*
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
    */
}

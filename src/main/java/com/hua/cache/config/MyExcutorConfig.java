package com.hua.cache.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import java.util.concurrent.ThreadPoolExecutor;

@EnableAsync
@Configuration
public class MyExcutorConfig {
    private static Logger logger = LoggerFactory.getLogger(MyExcutorConfig.class);

    @Bean
    public ThreadPoolTaskExecutor asyncServiceExecutor() {
        logger.info("start executor -->");
        ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();
        //设置核心线程数
        executor.setCorePoolSize(5);
        //设置最大线程数
        executor.setMaxPoolSize(20);
        //设置队列大小
        executor.setQueueCapacity(100);
        //配置线程池的前缀
        executor.setThreadNamePrefix("async-service-");
        executor.setRejectedExecutionHandler(new ThreadPoolExecutor.CallerRunsPolicy());
        //设置空闲时间
        executor.setKeepAliveSeconds(60);
        //进行加载
        executor.initialize();
        return executor;
    }
}

package com.xiaoluban.thirdparty.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import java.util.concurrent.*;

/**
 * @author tangxubin
 * @Date 2024/3/28 15:34
 */
@Configuration
public class DemoThreadPoolConfing {


//    @Bean(name = "myThreadPool")
//    public ExecutorService myThreadPool() {
//        // 阿里规约建议：根据CPU核心数来设置线程池大小
//        int corePoolSize = 10;
//        int maximumPoolSize = corePoolSize * 2;
//        long keepAliveTime = 60L;
//        TimeUnit unit = TimeUnit.SECONDS;
//        BlockingQueue<Runnable> workQueue = new ArrayBlockingQueue<>(1000);
//
//        RejectedExecutionHandler handler = new ThreadPoolExecutor.CallerRunsPolicy();
//
//        ThreadPoolExecutor executor = new ThreadPoolExecutor(
//                corePoolSize,
//                maximumPoolSize,
//                keepAliveTime,
//                unit,
//                workQueue,
//                handler);
//
//        // 允许核心线程超时
//        executor.allowCoreThreadTimeOut(true);
//
//        return executor;
//    }


    @Bean(name = "myThreadPool")
    public  ThreadPoolTaskExecutor myThreadPool() {
        ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();
        executor.setCorePoolSize(5);
        executor.setMaxPoolSize(10);
        executor.setQueueCapacity(20);
        executor.setThreadNamePrefix("executor-");
        executor.setRejectedExecutionHandler(new ThreadPoolExecutor.CallerRunsPolicy());
        executor.initialize();
        return executor;
    }

    @Bean(name = "myThreadPool2")
    public ExecutorService myThreadPool2() {
        // 阿里规约建议：根据CPU核心数来设置线程池大小
        int corePoolSize = Runtime.getRuntime().availableProcessors();
        int maximumPoolSize = corePoolSize * 2;
        long keepAliveTime = 60L;
        TimeUnit unit = TimeUnit.SECONDS;
        BlockingQueue<Runnable> workQueue = new ArrayBlockingQueue<>(20);
        RejectedExecutionHandler handler = new ThreadPoolExecutor.CallerRunsPolicy();

        ThreadPoolExecutor executor = new ThreadPoolExecutor(
                corePoolSize,
                maximumPoolSize,
                keepAliveTime,
                unit,
                workQueue,
                handler);

        // 允许核心线程超时
        executor.allowCoreThreadTimeOut(true);

        return executor;
    }

    @Bean(name = "executor2")
    public Executor executor2() {
        ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();
        executor.setCorePoolSize(5);
        executor.setMaxPoolSize(10);
        executor.setQueueCapacity(20);
        executor.setThreadNamePrefix("executor-");
        executor.setRejectedExecutionHandler(new ThreadPoolExecutor.CallerRunsPolicy());
        executor.initialize();
        return executor;
    }

}

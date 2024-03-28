package com.xiaoluban.thread;

import com.xiaoluban.thirdparty.ThirdPartyApplication;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.concurrent.*;

/**
 * @author tangxubin
 * @Date 2024/3/28 16:01
 */
@SpringBootTest(classes=ThirdPartyApplication.class)
@RunWith(SpringRunner.class)
@Slf4j
public class ThreadTest {

    @Autowired
    @Qualifier("myThreadPool")
    private ThreadPoolTaskExecutor myThreadPool1;

    @Autowired
    @Qualifier("executor2")
    private Executor executor2;

    @Autowired
    @Qualifier("myThreadPool2")
    private ExecutorService executorService;

    @Test
    public void run1() throws InterruptedException {
        int count = 100;
        CountDownLatch cdl = new CountDownLatch(count);
        log.info("-----myThreadPool开始---");
        for(int i=0;i<count;i++){
            int finalI = i;
            myThreadPool1.execute(() -> {
                try {
                    doRun(finalI + "");
                } catch (InterruptedException e) {
                    log.warn("id:{}请求账务异常", finalI, e);
                } finally {
                    cdl.countDown();
                }
            });
        }
        cdl.await(100, TimeUnit.SECONDS);
        log.info("-----myThreadPool结束---");
        //16:22:39.497  16:24:19.506
    }


    @Test
    public void run2() throws InterruptedException {
        int count = 100;
        CountDownLatch cdl = new CountDownLatch(count);
        log.info("-----myThreadPool开始---");
        for(int i=0;i<count;i++){
            int finalI = i;
            executorService.execute(() -> {
                try {
                    doRun(finalI + "");
                } catch (InterruptedException e) {
                    log.warn("id:{}请求账务异常", finalI, e);
                } finally {
                    cdl.countDown();
                }
            });
        }
        cdl.await(1000, TimeUnit.SECONDS);
        log.info("-----myThreadPool结束---");
    }

    @Test
    public void run3() throws InterruptedException {
        int count = 100;
        CountDownLatch cdl = new CountDownLatch(count);
        log.info("-----myThreadPool开始---");
        for(int i=0;i<count;i++){
            int finalI = i;
            executor2.execute(() -> {
                try {
                    doRun(finalI + "");
                } catch (InterruptedException e) {
                    log.warn("id:{}请求账务异常", finalI, e);
                } finally {
                    cdl.countDown();
                }
            });
        }
        cdl.await(1000, TimeUnit.SECONDS);
        log.info("-----myThreadPool结束---");
    }



    private Boolean doRun(String id) throws InterruptedException {
        log.info("id:{}请求账务开始",id);
        Thread.sleep(1000);
        log.info("id:{}请求账务结束",id);
        return true;
    }
}

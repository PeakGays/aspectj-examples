package cn.kapukapu.aspectj;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AdviceMode;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.EnableAsync;

/**
 * @author sivan
 */
@Slf4j
@EnableAsync(mode = AdviceMode.ASPECTJ)
@SpringBootApplication
public class App {

    @Async
    public void runA() {
        runB(Thread.currentThread().getId());
    }

    @Async
    public void runB(long threadId) {
        log.info("runA in thread[{}], runB in thread[{}]", threadId, Thread.currentThread().getId());
    }

    public static void main(String[] args) {
        ConfigurableApplicationContext applicationContext = SpringApplication.run(App.class, args);
        App app = applicationContext.getBean(App.class);

        int i = 5;
        while (i > 0) {
            app.runA();
            i--;
        }

        applicationContext.close();
    }
}

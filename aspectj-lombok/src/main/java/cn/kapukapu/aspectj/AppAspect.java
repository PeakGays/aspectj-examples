package cn.kapukapu.aspectj;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;

/**
 * @author sivan
 */
@Aspect
public class AppAspect {

    @Pointcut("execution (* cn.kapukapu.aspectj.App.run(..))")
    public void pointcut() {}

    @Before("pointcut()")
    public void before() {
        System.out.println("before App.run()");
    }

    @After("pointcut()")
    public void after() {
        System.out.println("after App.run()");
    }

    @Pointcut("execution (* cn.kapukapu.aspectj.App.setAppName(..))")
    public void pointcutSetAppName() {}

    @Before("pointcutSetAppName()")
    public void beforeSetAppName() {
        System.out.println("before setAppName");
    }

    @After("pointcutSetAppName()")
    public void afterSetAppName() {
        System.out.println("after setAppName");
    }
}

package com.bh.service;

import org.aspectj.lang.annotation.*;

/**
 * @Description:
 * @Author: WWT
 * @Date: 2021/3/7
 */
@Aspect
public class AOPService {
    @Pointcut("execution(* com.bh.*.*(..))")
    private void selectAll(){

    }

    @Before("selectAll()")
    public void beforeAdvice(){
        System.out.println("用户档案已经设置好。");
    }

    @After("selectAll()")
    public void afterAdvice(){
        System.out.println("用户档案已设置好");
    }

    @AfterReturning(pointcut = "selectAll()", returning="retVal")
    public void afterReturningAdvice(Object retVal){
        System.out.println("返回:" + retVal.toString() );
    }

    @AfterThrowing(pointcut = "selectAll()", throwing = "ex")
    public void AfterThrowingAdvice(IllegalArgumentException ex){
        System.out.println("有一个例外:" + ex.toString());
    }
}

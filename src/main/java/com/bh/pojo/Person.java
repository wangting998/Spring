package com.bh.pojo;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;

/**
 * @Description:创建person类,实现BeanPostProcessor
 * @Author: WWT
 * @Date: 2021/3/4
 * @Time: 16:14
 */
public class Person implements BeanPostProcessor{

    /*public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        System.out.println("BeforeInitialization : " + beanName);
        return bean;  // you can return any other object as well
    }
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        System.out.println("AfterInitialization : " + beanName);
        return bean;  // you can return any other object as well
    }*/

    private String name;
    private String name1;
    private String name2;

    public String getName() {
        System.out.println("Person name : " + name);
        return name;
    }

    public String getName1() {
        System.out.println("Person name1 : " + name1);
        return name1;
    }

    public String getName2() {
        System.out.println("Person name2 : " + name2);
        return name2;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setName1(String name1) {
        this.name1 = name1;
    }

    public void setName2(String name2) {
        this.name2 = name2;
    }
}

package com.bh.test;

import com.bh.pojo.AOP;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @Description:
 * @Author: WWT
 * @Date: 2021/3/7
 */
public class AOPTest {
    /**
     * Spring 中基于 AOP 的 XML架构
     */
    @Test
    public void testAOP() {
        //1.通过 ClassPathXmlApplication 找到配置文件获得 Spring 容器
        //  （解析applicationContext.xml文件 , 生成管理相应的Bean对象）
        ApplicationContext context  = new ClassPathXmlApplicationContext("bean.xml");
        //2.调用 getBean()方法获得配置文件中的同名实例
        //  getBean : 参数即为spring配置文件中bean的id/name
        AOP userLoggin = (AOP) context .getBean("AOP");
        //3.输出结果
        userLoggin.getName();
        userLoggin.getAge();
        //userLoggin.printThrowException();
    }
}

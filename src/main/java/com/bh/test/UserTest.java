package com.bh.test;

import com.bh.pojo.*;
import com.bh.service.UserJDBCTemplate;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;
import org.springframework.core.io.ClassPathResource;

import java.util.List;

/**
 * @Description:创建User测试类
 * @Author: WWT
 * @Date: 2021/3/4
 */
public class UserTest {
    @Test
    public void test(){
        ApplicationContext ac = new
                ClassPathXmlApplicationContext("applicationContext.xml");

        User user = (User) ac.getBean("User");
        System.out.println(user);
    }

    /**
     * BeanFactory 容器
     */
    @Test
    public void TestBeanFactory() {
        //1.利用框架提供的 XmlBeanFactory() API 去生成工厂 bean
        // 以及利用 ClassPathResource() API 去加载在路径 CLASSPATH 下可用的 bean 配置文件
        XmlBeanFactory factory = new XmlBeanFactory
                (new ClassPathResource("applicationContext.xml"));
        //2.调用 getBean()方法 : 参数即为spring配置文件中bean的id
        User user = (User) factory.getBean("User");
        user.getName();
        //3.输出结果
        System.out.println(user);
    }

    /**
     * ApplicationContext 容器
     */
    @Test
    public void TestApplicationContext() {
        //1.第一步生成工厂对象。
        //FileSystemXmlApplicationContext 负责生成和初始化所有的对象，比如，所有在 XML bean 配置文件中的 bean。
        ApplicationContext context = new FileSystemXmlApplicationContext
                ("E:/idea/SpringDemo/Spring/src/main/resources/applicationContext.xml");
        //2.第二步利用第一步生成的上下文中的 getBean() 方法得到所需要的 bean。
        // 这个方法通过配置文件中的 bean ID 来返回一个真正的对象
        //一旦得到这个对象，就可以利用这个对象来调用任何方法。
        User user = (User) context.getBean("User");
        user.getName();
        //3.输出
        System.out.println(user);
    }

    /**
     * singleton/prototype作用域
     */
    @Test
    public void testSingletonAndPrototype() {
        //1.通过 ClassPathXmlApplication 找到配置文件获得 Spring 容器
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        //2.调用 getBean()方法 : 参数即为spring配置文件中bean的id
        User user = (User) context.getBean("User");
        //3.输出
        user.setName("I'm object A");
        user.getName();
        User user1 = (User) context.getBean("User");
        user1.getName();
    }

    /**
     * 销毁回调
     */
    @Test
    public void testRegisterShutdownHook() {
        //1.通过 ClassPathXmlApplication 找到配置文件获得 Spring 容器
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        //2.调用 getBean()方法 : 参数即为spring配置文件中bean的id
        User user = (User) context.getBean("User");
        user.getName();
        //3.输出
        System.out.println(user);
    }

    /**
     * 后置处理器 BeanPostProcessor
     */
    @Test
    public void testBeanPostProcessor() {
        //1.通过 ClassPathXmlApplication 找到配置文件获得 Spring 容器
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        //2.调用 getBean()方法 : 参数即为spring配置文件中bean的id
        User user = (User) context.getBean("User");
        user.getName();
        System.out.println(user);
    }

    /**
     *Bean 定义继承
     */
    @Test
    public void testBean() {
        //1.通过 ClassPathXmlApplication 找到配置文件获得 Spring 容器
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        //2.调用 getBean()方法 : 参数即为spring配置文件中bean的id
        User user = (User) context.getBean("User");
        user.getName();
        //user.getName1();

        Person person = (Person) context.getBean("Person");
        person.getName();
        person.getName1();
        person.getName2();
    }


    /**
     * 基于构造函数的依赖注入
     */
    @Test
    public  void testStructure() {
        //1.通过 ClassPathXmlApplication 找到配置文件获得 Spring 容器
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        //2.调用 getBean()方法 : 参数即为spring配置文件中bean的id
        User user = (User) context.getBean("User");
        //3.调用
        //user.userService();
    }

    /**
     *Spring 自动装配 byName
     */
    @Test
    public  void testByName() {
        //1.通过 ClassPathXmlApplication 找到配置文件获得 Spring 容器
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        //2.调用 getBean()方法 : 参数即为spring配置文件中bean的id
        User user = (User) context.getBean("User");
        //3.调用
        //user.userService();
    }

    /**
     * Spring 自动装配 byType
     */
    @Test
    public  void testByType() {
        //1.通过 ClassPathXmlApplication 找到配置文件获得 Spring 容器
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        //2.调用 getBean()方法 : 参数即为spring配置文件中bean的id
        User user = (User) context.getBean("User");
        //3.调用
        //user.userService();
    }

    @Test
    public void testRequired() {
        //1.通过 ClassPathXmlApplication 找到配置文件获得 Spring 容器
        //  （解析applicationContext.xml文件 , 生成管理相应的Bean对象）
        ApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext.xml");
        //2.调用 getBean()方法获得配置文件中的同名实例
        //  getBean : 参数即为spring配置文件中bean的id/name
        User user = (User) ac.getBean("User");
        //3.输出结果
        System.out.println("Name : " + user.getName() );
        System.out.println("Age : " + user.getAge() );
    }

    /**
     * Spring @Autowired 注释
     */
    @Test
    public void testAutowired() {
        //1.通过 ClassPathXmlApplication 找到配置文件获得 Spring 容器
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        //2.调用 getBean()方法 : 参数即为spring配置文件中bean的id
        AutowiredDemo autowiredDemo = (AutowiredDemo) context.getBean("AutowiredDemo");
        //3.调用
        autowiredDemo.userService();
    }

    /**
     * Spring @Qualifier 注释
     */
    @Test
    public void testQualifier() {
        //1.通过 ClassPathXmlApplication 找到配置文件获得 Spring 容器
        //  （解析applicationContext.xml文件 , 生成管理相应的Bean对象）
        ApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext.xml");
        //2.调用 getBean()方法获得配置文件中的同名实例
        //  getBean : 参数即为spring配置文件中bean的id/name
        Student student = (Student) ac.getBean("Student");
        //3.输出结果
        student.userName();
        student.userAge();
    }
}

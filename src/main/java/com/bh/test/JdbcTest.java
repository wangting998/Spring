package com.bh.test;

import com.bh.pojo.User;
import com.bh.service.UserJDBCTemplate;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

/**
 * @Description:
 * @Author: WWT
 * @Date: 2021/3/8
 * @Time: 11:45
 */
public class JdbcTest {
    ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
    UserJDBCTemplate userJDBCTemplate = (UserJDBCTemplate) context.getBean("userJDBCTemplate");

    /**
     * JDBC示例 添加用户
     */
    @Test
    public void testCreate() {
        System.out.println("------添加记录--------");
        userJDBCTemplate.create("王文婷",21);
        userJDBCTemplate.create("杨新奇",21);
    }

    /**
     * 查询所有用户
     */
    @Test
    public void testSelectAll() {
        System.out.println("------查询所有用户--------" );
        List<User> users = userJDBCTemplate.listUsers();
        for(User record : users) {
            System.out.print("ID : " + record.getId() );
            System.out.print(", Name : " + record.getName() );
            System.out.println(", Age : " + record.getAge());
        }
    }

    /**
     * 根据id修改用户
     */
    @Test
    public void testUpdate() {
        System.out.println("----更新id=2的记录 -----" );
        userJDBCTemplate.update(2, 22);
    }

    /**
     * 根据id修改用户
     */
    @Test
    public void testById() {
        System.out.println("----列出id=2的记录 -----" );
        User user = userJDBCTemplate.getUser(2);
        System.out.print("id : " + user.getId() );
        System.out.print(", name : " + user.getName() );
        System.out.println(", age : " + user.getAge());
    }
}

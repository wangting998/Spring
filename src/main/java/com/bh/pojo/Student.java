package com.bh.pojo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

/**
 * @Description:
 * @Author: WWT
 * @Date: 2021/3/5
 * @Time: 11:33
 */
public class Student {
    @Autowired
    @Qualifier("user1")
    private User user;
    public Student(){
        System.out.println("Inside Profile constructor." );
    }
    public void userAge() {
        System.out.println("Age : " + user.getAge() );
    }
    public void userName() {
        System.out.println("Name : " + user.getName() );
    }
}

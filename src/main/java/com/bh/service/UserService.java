package com.bh.service;

/**
 * @Description: Spring 依赖注入
 * @Author: WWT
 * @Date: 2021/3/4
 * @Time: 17:46
 */
public class UserService {
    public UserService(){
        System.out.println("这是UserService" );
    }
    public void checkService() {
        System.out.println("这是checkService" );
    }
}

package com.bh.pojo;

import com.bh.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @Description:
 * @Author: WWT
 * @Date: 2021/3/5
 * @Time: 14:45
 */
public class AutowiredDemo {
    @Autowired
    private UserService userService;

    /*@Autowired
    public AutowiredDemo(UserService userService) {
        this.userService = userService;
    }*/

    public UserService getUserService() {
        return userService;
    }

    //@Autowired
    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    public void userService() {
        userService.checkService();
    }
}

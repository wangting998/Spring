package com.bh.pojo;

import com.bh.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Required;

/**
 * @Description:创建User实体类，有name,age两属性
 * @Author: WWT
 * @Date: 2021/3/4
 */
public class User {
    private String name;  //姓名
    private Integer age;     //年龄
    private Integer id;     //id
    //private String name1;  //姓名

    /*private UserService userService;

    public User(UserService userService) {
        System.out.println("这是user类" );
        this.userService = userService;
    }

    public User() {

    }

    public void userService() {
        userService.checkService();
    }

   public UserService getUserService() {
        return userService;
    }

    public void setUserService(UserService userService) {
        //System.out.println("这是user类" );
        this.userService = userService;
    }

    public void init(){
        System.out.println("Bean is going through init.");
    }
    public void destroy(){
        System.out.println("Bean will destroy now.");
    }*/

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", id=" + id +
                '}';
    }


    public String getName() {
        //System.out.println("name:" + name);
        return name;
    }

    //@Required
    public void setName(String name) {
        this.name = name;
    }

    //@Required
    public Integer getAge() {
        //System.out.println("age:" + age);
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    /*public String getName1() {
        return name1;
    }

    public void setName1(String name1) {
        this.name1 = name1;
    }*/
}

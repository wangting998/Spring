package com.bh.pojo;

import java.io.InputStream;

/**
 * @Description: 反射类
 * @Author: WWT
 * @Date: 2021/3/8
 * @Time: 15:23
 */
public class Reflect {
    private String name;
    int age;
    public String address;

    public Reflect() {
    }

    private Reflect(String name) {
        this.name = name;
    }

    Reflect(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public Reflect(String name, int age, String address) {
        this.name = name;
        this.age = age;
        this.address = address;
    }

    public void show() {
        System.out.println("show");
    }

    public void method() {
        System.out.println("这是method方法");
    }

    public String getString(String s, int i) {
        return s + "---" + i;
    }

    private void function() {
        System.out.println("function");
    }

    @Override
    public String toString() {
        return "Reflect{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", address='" + address + '\'' +
                '}';
    }
}

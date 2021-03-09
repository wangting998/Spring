package com.bh.dao;

import com.bh.pojo.User;

import javax.sql.DataSource;
import java.util.List;

/**
 * @Description:数据访问对象接口文件UserDao
 * @Author: WWT
 * @Date: 2021/3/8
 * @Time: 10:23
 */
public interface UserDao {
    /**
     * 这是用于初始化数据库资源 连接的方法。
     * @param dataSource
     */
    public void setDataSource(DataSource dataSource);

    /**
     * 这是用于在User表中创建一条记录的方法。
     * @param name
     * @param age
     */
    public void create(String name,Integer age);

    /**
     * 这个方法用于从User表中列出与传递的用户id相对应的记录。
     * @param id
     * @return
     */
    public User getUser(Integer id);

    /**
     * 这是用来列出User表中的所有记录的方法。
     * @return
     */
    public List<User> listUsers();

    /**
     * 这个方法用于从User表中删除与传递的用户id对应的记录。
     * @param id
     */
    public void delete(Integer id);

    /**
     * 这是用于将一条记录更新到User表中的方法。
     * @param id
     * @param age
     */
    public void update(Integer id,Integer age);
}

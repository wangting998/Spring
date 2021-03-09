package com.bh.service;

import com.bh.dao.UserDao;
import com.bh.pojo.User;
import com.bh.pojo.UserMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;
import java.util.List;

/**
 * @Description:
 * @Author: WWT
 * @Date: 2021/3/8
 * @Time: 10:54
 */
public class UserJDBCTemplate implements UserDao {
    private DataSource dataSource;
    private JdbcTemplate jdbcTemplate;

    @Override
    public void setDataSource(DataSource dataSource) {
        this.dataSource = dataSource;
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    /**
     * 创建用户
     * @param name
     * @param age
     */
    @Override
    public void create(String name, Integer age) {
        /**
         * 1.给出sql语句
         * 2.找参数
         */
        String sql = "insert into user (name, age) values (?, ?);";
        jdbcTemplate.update(sql,name,age);
        System.out.println("用户名 =" + name + "年龄" + age);
        return;
    }

    /**
     * 根据id查询
     * @param id
     * @return
     */
    @Override
    public User getUser(Integer id) {
        /**
         * 1.给出sql语句
         * 2.找参数
         */
        String sql = "select * from user where id = ?";
        User users = jdbcTemplate.queryForObject(
                sql,new Object[]{id},new UserMapper()
        );
        return users;
    }

    /**
     * 查询用户
     * @return
     */
    @Override
    public List<User> listUsers() {
        /**
         * 1.给出sql语句
         * 2.找参数
         */
        String sql = "select * from user";
        List<User> users = jdbcTemplate.query(
                sql,new UserMapper()
        );
        return users;
    }

    /**
     * 根据id删除用户
     * @param id
     */
    @Override
    public void delete(Integer id) {
        /**
         * 1.给出sql语句
         * 2.找参数
         */
        String sql = "delete from user where id = ?";
        jdbcTemplate.update(sql, id);
        System.out.println("已删除id记录 = " + id );
        return;
    }

    @Override
    public void update(Integer id, Integer age) {
        /**
         * 1.给出sql语句
         * 2.找参数
         */
        String sql = "update user set age = ? where id = ?";
        jdbcTemplate.update(sql,age,id);
        System.out.println("已修改的记录及id" + id );
        return;
    }
}

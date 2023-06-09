package day3.test;

import day3.entity.User;
import day3.util.DataSourceUtils;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import java.io.PrintStream;
import java.util.List;

/**
 * @author yi xian
 * @description
 * @date 2023/6/7 10:17
 */
public class JDBCPlus {
    public static void main(String[] args) {
        // 使用JdbcTemplate 来 操作数据库
        String sqlCondition = "select * from users where num = ? and PASSWORD = ?";
        String sqlAll = "select * from users";
        JdbcTemplate jdbcTemplate = new JdbcTemplate(DataSourceUtils.getDataSource());
        // 1. 查询的同时，直接把结果解封装为对象  BeanPropertyRowMapper -> 制定你要封装出来的对象类型
        //查询多个
        List<User> users = jdbcTemplate.query(sqlAll, new BeanPropertyRowMapper<>(User.class));
        // 查询一个
        User u = jdbcTemplate.queryForObject(sqlCondition, new BeanPropertyRowMapper<>(User.class),"11","1234");
        System.out.println(users);
        System.out.println("h");
        // 2. 增删改查的操作


    }
}

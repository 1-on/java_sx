package day3.dao;

import day3.entity.User;
import day3.util.DataSourceUtils;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import java.sql.*;
import java.util.List;

/**
 * @author yi xian
 * @description 业务：登录  数据库：查询
 * @date 2023/6/7 8:46
 */
public class UserDao {
    public User selectByNumAndPwd(String num, String password) {
        String sqlCondition = "select * from users where num = ? and PASSWORD = ?";
        JdbcTemplate jdbcTemplate = new JdbcTemplate(DataSourceUtils.getDataSource());
        try {
            // 只查询一个，会有两种结果：1.能查到，正常返回；2,。不能查到，会抛出异常
            User u = jdbcTemplate.queryForObject(sqlCondition, new BeanPropertyRowMapper<>(User.class), num, password);
            return u;
        } catch (Exception e) {
            return null;
        }


    }
}

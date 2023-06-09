package day3.dao;

import day3.entity.Course;
import day3.util.DataSourceUtils;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

/**
 * @author yi xian
 * @description
 * @date 2023/6/8 8:41
 */
public class CourseDao {
    public Course selectById(int id) {
        JdbcTemplate jdbcTemplate = new JdbcTemplate(DataSourceUtils.getDataSource());
        String sql = "select * from course where id = ?";
        return jdbcTemplate.queryForObject(sql, new BeanPropertyRowMapper<>(Course.class), id);
    }
}

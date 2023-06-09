package day3.dao;

import day3.entity.Question;
import day3.util.DataSourceUtils;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;

/**
 * @author yi xian
 * @description
 * @date 2023/6/8 8:43
 */
public class QuestionDao {
    public List<Question> selectAll(){
        JdbcTemplate jdbcTemplate = new JdbcTemplate(DataSourceUtils.getDataSource());
        String sql = "select * from questions";
        return jdbcTemplate.query(sql,new BeanPropertyRowMapper<>(Question.class));
    }
}

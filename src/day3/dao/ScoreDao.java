package day3.dao;

import day3.entity.Course;
import day3.entity.Score;
import day3.util.DataSourceUtils;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

/**
 * @author yi xian
 * @description
 * @date 2023/6/8 16:24
 */
public class ScoreDao {
    public void savaAnswers(int id,int userid,int courseid,String examDate,int score){
        JdbcTemplate jdbcTemplate = new JdbcTemplate(DataSourceUtils.getDataSource());
        String sql = "insert into scores values(?,?,?,?,?)";
        jdbcTemplate.update(sql,id,userid,courseid,examDate,score);
    }
    public Score selectByUserid(int id){
        JdbcTemplate jdbcTemplate = new JdbcTemplate(DataSourceUtils.getDataSource());
        String sql = "select * from scores where id = ?";
        return jdbcTemplate.queryForObject(sql, new BeanPropertyRowMapper<>(Score.class), id);
    }
}

	package kr.ac.hansung.cse.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import kr.ac.hansung.cse.model.Score;

@Repository("ScoreDao")
public class ScoreDao {
    private JdbcTemplate jdbcTemplate;

    @Autowired
    public void setDataSource(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }
    //cRud
    public int getRowCount() {
    	String SQL = "select count(*) from takes";
    	return jdbcTemplate.queryForObject(SQL, Integer.class);
    }
    
	@SuppressWarnings("deprecation")
	public List<Score> getScores(String name, int year, int semester) {
	    String sql = "select year, semester, title, credit, grade from offers, course, class, takes "+
	    		"where offers.id=takes.stu_id and takes.class_id=class.class_id and course.course_id = class.course_id "+
	    		"and offers.name=? and year=? and semester=?";
	    return jdbcTemplate.query(sql, new Object[] {name, year, semester}, new RowMapper<Score>() {
	        @Override
	        public Score mapRow(ResultSet rs, int rowNum) throws SQLException {
	        	Score score = new Score();
	        	score.setYear(rs.getInt("year"));
	        	score.setSemester(rs.getInt("semester"));
	        	score.setSubject(rs.getString("title"));
	        	score.setCredit(rs.getInt("credit"));
	        	score.setScore(rs.getString("grade"));
	            return score;
	        }
	    });
	}
    
}

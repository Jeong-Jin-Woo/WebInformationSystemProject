	package kr.ac.hansung.cse.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import kr.ac.hansung.cse.model.Semester;

@Repository("SemesterDao")
public class SemesterDao {
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
	public List<Semester> getSemesters(String name) {
	    String sql = "select name, year, semester, sum(credit) as credit from offers, course, class, takes "+
	            "where offers.id=takes.stu_id and takes.class_id=class.class_id and course.course_id = class.course_id and offers.name=?" +
	            " group by year, semester "+
	            "order by year desc, semester desc";
	    return jdbcTemplate.query(sql, new Object[] {name}, new RowMapper<Semester>() {
	        @Override
	        public Semester mapRow(ResultSet rs, int rowNum) throws SQLException {
	            Semester semester = new Semester();
	            semester.setName(name);
	            semester.setYear(rs.getInt("year"));
	            semester.setSemester(rs.getInt("semester"));
	            semester.setCredit(rs.getInt("credit"));
	            return semester;
	        }
	    });
	}
//	@SuppressWarnings("deprecation")
//	public List<Semester> getSemesters(String name) {
//	    String sql = "select name, year, semester, sum(credit) as credit from offers, course, class, takes "+
//	            "where offers.id=takes.stu_id and takes.class_id=class.class_id and course.course_id = class.course_id and offers.id=?" +
//	            " group by year, semester";
//	    return jdbcTemplate.query(sql, new Object[] {name}, new RowMapper<Semester>() {
//	        @Override
//	        public Semester mapRow(ResultSet rs, int rowNum) throws SQLException {
//	            System.out.println("name: " + name);
//	            System.out.println("year: " + rs.getInt("year"));
//	            System.out.println("semester: " + rs.getInt("semester"));
//	            System.out.println("credit: " + rs.getInt("credit"));
//	            Semester semester = new Semester();
//	            semester.setName(name);
//	            semester.setYear(rs.getInt("year"));
//	            semester.setSemester(rs.getInt("semester"));
//	            semester.setCredit(rs.getInt("credit"));
//	            return semester;
//	        }
//	    });
//	}


    @SuppressWarnings("deprecation")
	public Semester getSemester(String name) {    	
    	String sql = "select name, year, semester, sum(credit) as credit from offers, course, class, takes "+
			"where offers.id=takes.stu_id and takes.class_id=class.class_id and course.course_id = class.course_id and offers.id=?" +
			" group by year, semester";
    	return jdbcTemplate.queryForObject(sql, new Object[] {name}, new RowMapper<Semester>(){
    		public Semester mapRow(ResultSet rs, int rowNum) throws SQLException{
    			Semester semester = new Semester();
    			semester.setName(name);
    			semester.setYear(rs.getInt("year"));
    			semester.setSemester(rs.getInt("semester"));
    			semester.setCredit(rs.getInt("credit"));
    			return semester;
    		}
    	});
    }
    
}

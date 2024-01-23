	package kr.ac.hansung.cse.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import kr.ac.hansung.cse.model.Enroll;
import kr.ac.hansung.cse.model.Semester;

@Repository("enrollDao")
public class EnrollDao {
    private JdbcTemplate jdbcTemplate;

    @Autowired
    public void setDataSource(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }
    //cRud
    public int getRowCount() {
    	String SQL = "select count(*) from enrollment";
    	return jdbcTemplate.queryForObject(SQL, Integer.class);
    }
    
	@SuppressWarnings("deprecation")
	public List<Enroll> getEnrolls(String name) {
    	String sql = "select stu_name, class.class_id, title, name, division, classroom, course.credit from enrollment, class, course, offers "+
    				"where enrollment.class_id=class.class_id and course.course_id=class.course_id and offers.id=class.prof_id"+
    				" and stu_name=?";
	    return jdbcTemplate.query(sql, new Object[] {name}, new RowMapper<Enroll>() {
	        @Override
	        public Enroll mapRow(ResultSet rs, int rowNum) throws SQLException {
	        	Enroll enroll = new Enroll();
	        	enroll.setStu_name(name);
	            enroll.setClass_id(rs.getString("class_id"));
	            enroll.setTitle(rs.getString("title"));
	            enroll.setProfessor(rs.getString("name"));
	            enroll.setDivision(rs.getString("division"));
	            enroll.setRoom(rs.getString("classroom"));
	            enroll.setCredit(rs.getInt("credit"));
	            System.out.println(enroll);
	            return enroll;
	        }
	    });
    }


	//C
    public boolean insert(Enroll enroll) {
    	String stu_name = enroll.getStu_name();
    	String class_id = enroll.getClass_id();
    	String sql = "insert into enrollment (stu_name, class_id) value (?,?)";
    	return (jdbcTemplate.update(sql, new Object[] {stu_name, class_id})==1);
    }
    //D
//    public boolean delete(Enroll enroll) {
//    	int stu_id = enroll.getStu_id();
//    	String class_id = enroll.getClass_id();
//    	String sql = "delete from enrollment where stu_id=? and class_id=?";
//    	return (jdbcTemplate.update(sql, new Object[] {stu_id, class_id}) == 1);
//    }
}

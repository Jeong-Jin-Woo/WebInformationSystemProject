	package kr.ac.hansung.cse.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import kr.ac.hansung.cse.model.InformationList;

@Repository("informationListDao")
public class InformationListDao {
    private JdbcTemplate jdbcTemplate;

    @Autowired
    public void setDataSource(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }
    //cRud
    public int getRowCount() {
    	String SQL = "select count(*) from course";
    	return jdbcTemplate.queryForObject(SQL, Integer.class);
    }
    
	public List<InformationList> getInformationLists() {
    	String sql = "SELECT year, semester, class_id, title, name, division, classroom, credit FROM course, class, offers "
    			+ "where course.course_id=class.course_id and class.prof_id = offers.id "
    			+ "order by year DESC, semester DESC, title";
    	return jdbcTemplate.query(sql, new RowMapper<InformationList>() {
			@Override
			public InformationList mapRow(ResultSet rs, int rowNum) throws SQLException {
				InformationList informationList = new InformationList();
				informationList.setYear(rs.getInt("year"));
				informationList.setSemester(rs.getInt("semester"));
				informationList.setCourse_id(rs.getString("class_id"));
				informationList.setTitle(rs.getString("title"));
				informationList.setName(rs.getString("name"));
				informationList.setDivision(rs.getString("division"));
				informationList.setClassroom(rs.getString("classroom"));
				informationList.setCredit(rs.getInt("credit"));
				return informationList;
			}
    	});
    }

}

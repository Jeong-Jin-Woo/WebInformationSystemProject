	package kr.ac.hansung.cse.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.util.StopWatch;

import kr.ac.hansung.cse.model.Offer;

@Repository("offerDao")
public class OfferDao {
    private JdbcTemplate jdbcTemplate;

    @Autowired
    public void setDataSource(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }
    //cRud
    public int getRowCount() {
    	String SQL = "select count(*) from offers";
    	return jdbcTemplate.queryForObject(SQL, Integer.class);
    }
    
    @SuppressWarnings("deprecation")
	public Offer getOffer(String name) {
    	String sql = "select * from offers where name = ?";
    	return jdbcTemplate.queryForObject(sql, new Object[] {name}, new RowMapper<Offer>(){
    		public Offer mapRow(ResultSet rs, int rowNum) throws SQLException{
    			Offer offer = new Offer();
    			offer.setId(rs.getInt("id"));
    			offer.setName(name);
    			offer.setEmail(rs.getString("email"));
				offer.setPassword(rs.getString("password"));
    			return offer;
    		}
    	});
    }
    
	public List<Offer> getOffers() {
    	String sql = "select * from offers";
    	return jdbcTemplate.query(sql, new RowMapper<Offer>() {
			@Override
			public Offer mapRow(ResultSet rs, int rowNum) throws SQLException {
				Offer offer = new Offer();
				offer.setId(rs.getInt("id"));
				offer.setName(rs.getString("name"));
				offer.setEmail(rs.getString("email"));
				offer.setPassword(rs.getString("password"));
				return offer;
			}
    	});
    }

	
    
	public List<Offer> selectWithLimit(String str) {

    	String SQL = str;
    	return jdbcTemplate.query(SQL,  new RowMapper<Offer>() {
			@Override
			public Offer mapRow(ResultSet rs, int rowNum) throws SQLException {
				Offer offer = new Offer();
				offer.setId(rs.getInt("id"));
				offer.setName(rs.getString("name"));
				offer.setEmail(rs.getString("email"));
				offer.setPassword(rs.getString("password"));
				return offer;
			}
    	});
    }
	
	//CrUD
    public boolean insert(Offer offer) {
    	String name = offer.getName();
    	String email = offer.getEmail();
    	String password = offer.getPassword();
    	String sql = "insert into offers (name, email, password) value (?,?,?)";
    	return (jdbcTemplate.update(sql, new Object[] {name, email, password})==1);
    }
    
    public boolean insertRole(Offer offer) {
    	String name = offer.getName();
    	String role = "ROLE_USER";
    	String sql = "insert into authorities (username, authority) value (?,?)";
    	return (jdbcTemplate.update(sql, new Object[] {name, role})==1);
    }
    
    public boolean update(Offer offer) {
    	int id = offer.getId();
    	String name = offer.getName();
    	String email = offer.getEmail();
    	String password = offer.getPassword();
    	String sql = "update offers set name=?, email=?, password=? where id=?";
    	return (jdbcTemplate.update(sql, new Object[] {name, email, password, id}) == 1);
    }
    public boolean delete(Offer offer) {
    	int id = offer.getId();
    	String sql = "delete from offers where id=?";
    	return (jdbcTemplate.update(sql, new Object[] {id}) == 1);
    }
}

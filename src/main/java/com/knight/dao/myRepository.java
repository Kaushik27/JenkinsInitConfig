package com.knight.dao;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementSetter;
import org.springframework.stereotype.Repository;

import com.knight.dto.Student;
import com.knight.mapper.StudentRowMapper;

@Repository
public class myRepository {

	@Autowired
	JdbcTemplate jdbcTemplate;

	@Autowired
	@Qualifier("myOracleDs")
	DataSource myDs;

	public Student getValueFromDao(String id) {
		jdbcTemplate.setDataSource(myDs);
		return jdbcTemplate.queryForObject("SELECT * FROM jarvis.PERSON WHERE NAME = ?", new Object[] { id },
				new StudentRowMapper());
	}

	public List<Student> getAllValueFromDao() {
		jdbcTemplate.setDataSource(myDs);
		return jdbcTemplate.query("SELECT * FROM jarvis.PERSON VALUES(?,?,?)", new StudentRowMapper());
	}

	public int insertData(Student student) {
		System.out.println("Student in DAO :"+student);
		jdbcTemplate.setDataSource(myDs);
		return jdbcTemplate.update("INSERT INTO jarvis.PERSON(NAME,AGE,GENDER) VALUES(?,?,?)",
				new PreparedStatementSetter() {
					@Override
					public void setValues(PreparedStatement ps) throws SQLException {
						ps.setString(1, student.getName());
						ps.setInt(2, student.getAge());
						ps.setString(3, student.getGender());
					}
				});
	}

}

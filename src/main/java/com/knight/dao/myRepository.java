package com.knight.dao;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
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
		return jdbcTemplate.query("SELECT * FROM jarvis.PERSON",new StudentRowMapper());
	}

}

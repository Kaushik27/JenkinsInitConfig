package com.knight.dao;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.knight.dto.Student;

@Repository
public class myRepository {

	@Autowired
	JdbcTemplate jdbcTemplate;

	@Autowired
	@Qualifier("myOracleDs")
	DataSource myDs;

	public Object getValueFromDao(String id) {
		jdbcTemplate.setDataSource(myDs);
		return jdbcTemplate.queryForObject("SELECT * FROM jarvis.PERSON WHERE NAME = ?", new Object[] { id },
				new BeanPropertyRowMapper<>(Student.class));
	}

}

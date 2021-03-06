package com.knight.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.knight.dto.Student;

public class StudentRowMapper implements RowMapper<Student> {

	@Override
	public Student mapRow(ResultSet rs, int rowNum) throws SQLException {
		Student st = new Student();
		st.setName(rs.getString("NAME"));
		st.setAge(rs.getInt("AGE"));
		st.setGender(rs.getString("GENDER"));
		return st;
	}

}

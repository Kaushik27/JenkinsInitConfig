package com.knight.config;

import java.sql.SQLException;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

@Configuration
public class DatabaseConfig {
	
	@Bean("myOracleDs")
	public DataSource myOracleDs() throws SQLException{
		DriverManagerDataSource ds=new DriverManagerDataSource();
		ds.setUsername("jarvis");
		ds.setPassword("oracle");
		ds.setUrl("jdbc:oracle:thin:@localhost:1521/xe");
		return ds;
	}
}

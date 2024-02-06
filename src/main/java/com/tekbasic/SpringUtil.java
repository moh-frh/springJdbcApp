package com.tekbasic;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

public class SpringUtil {
	
	@Bean
	public DataSource getDataSource() {
		DriverManagerDataSource ds = new DriverManagerDataSource();
		ds.setDriverClassName("com.mysql.cj.jdbc.Driver");
		ds.setUrl("jdbc:mysql://localhost:3306/tekbasic");
		ds.setUsername("root");
		ds.setPassword("");
		
		return ds;
	}
	
	@Bean
	public JdbcTemplate getJdbcTemplate(DataSource ds) {
		JdbcTemplate jt = new JdbcTemplate(ds);
		return jt;
	}
	
	@Bean(value="dao")
	public SpringDAO getSpringDAO(JdbcTemplate jt) {
		SpringDAO sd = new SpringDAO();
		sd.setJt(jt);
		return sd;
	}

}

package com.ssm.service;

import java.sql.SQLException;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TestService {
	
	@Autowired
	private DataSource dataSource;
	
	
	public String testSpring() {
		return "spring";
	}
	
	public String testDB(){
		try {
			return dataSource.getConnection().getCatalog();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
}

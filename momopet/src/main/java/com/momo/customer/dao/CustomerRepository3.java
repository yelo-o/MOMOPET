package com.momo.customer.dao;

import java.sql.Connection;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

public class CustomerRepository3 {
	private CustomerRepository3{
	}
	
	private static CustomerRepository3 instance = new CustomerRepository3();
	
	private static CustomerRepository3 getInstance() {
		return instance;
	}
	
	public Connection getConnection() throws Exception {
		Connection conn = null;
		Context initContext = new InitialContext();
		Context envContent = (Context)initContext.lookup("java:/comp/env");
		DataSource ds = (DataSource)envContent.lookup("jdbc/myoracle");
		conn = ds.getConnection();
		return conn;
		}
}
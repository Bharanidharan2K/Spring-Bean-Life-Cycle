package com.example.beanlifecycle.annotaion;

import java.sql.*;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

public class StudentDAO {
	private String driver;
	private String url;
	private String userName;
	private String password;
	Connection con; // My DB Connection

	public void setDriver(String driver) {
		this.driver = driver;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@PostConstruct
	public void createDBConnection() throws Exception {
		// createDBConnection();
		Class.forName(driver);
		con = DriverManager.getConnection(url, userName, password);
	}

	public void selectAllRows() throws Exception {

		Statement stmt = con.createStatement();
		ResultSet rs = stmt.executeQuery("SELECT * FROM sql_store.products");

		while (rs.next()) {
			int productId = rs.getInt(1);
			String name = rs.getString(2);
			int quantityInStock = rs.getInt(3);
			float unitPrice = rs.getFloat(4);
			System.out.println(productId + " " + name + " " + quantityInStock + " " + unitPrice);

		}
	}

	public void deleteRecord(int productId) throws Exception {
		createDBConnection();
		Statement stmt = con.createStatement();
		stmt.executeUpdate("DELETE FROM sql_store.products WHERE product_id=" + productId);
		System.out.println("Record Deleted Successfully..!");
	}

	@PreDestroy
	public void closeDBConnection() throws Exception {
		//Closing the DB Connection
		System.out.println("Inside destroy..!");
		con.close();
	}
}

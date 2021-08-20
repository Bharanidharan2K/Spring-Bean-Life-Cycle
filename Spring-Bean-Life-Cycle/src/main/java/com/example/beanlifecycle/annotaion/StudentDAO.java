package com.example.beanlifecycle.annotaion;

import java.sql.*;

public class StudentDAO {
	private String driver = "com.mysql.jdbc.Driver";
	private String url ="jdbc:mysql://localhost:3306/sql_store";
	private String userName = "root";
	private String password = "root";
	
	public void selectAllRows() throws Exception{
		Class.forName(driver);
		Connection con = DriverManager.getConnection(url, userName, password);
		Statement stmt = con.createStatement();
		ResultSet rs = stmt.executeQuery("SELECT * FROM sql_store.products");
		
		while(rs.next()) {
			int productId = rs.getInt(1);
			String name = rs.getString(2);
			int quantityInStock = rs.getInt(3);
			float unitPrice = rs.getFloat(4);
			System.out.println(productId+" "+name+" "+quantityInStock+" "+unitPrice);
		}
	}
}

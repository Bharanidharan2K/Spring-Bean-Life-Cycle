package com.example.beanlifecycle.annotaion;

public class Main {

	public static void main(String[] args) throws Exception{
		StudentDAO studentDao = new StudentDAO();
		studentDao.selectAllRows();

	}

}

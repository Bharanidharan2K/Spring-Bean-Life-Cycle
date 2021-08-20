package com.example.beanlifecycle.annotaion;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {

	public static void main(String[] args) throws Exception{
		
		ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
		StudentDAO studentDAO = context.getBean("studentDAO", StudentDAO.class);
		studentDAO.selectAllRows();
		((ClassPathXmlApplicationContext) context).close();
	}

}

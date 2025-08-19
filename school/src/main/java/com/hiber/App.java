package com.hiber;

import java.util.Date;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.hiber.entity.School;
import com.hiber.enums.Gender;

public class App {

	public static void main(String[] args) {
		
		 SessionFactory factory = new Configuration().configure("hibernate.cfg.xml")
	                .addAnnotatedClass(School.class)
	                .buildSessionFactory();
		 	
		 //opening session
		 Session session = factory.openSession();
		 
		 // begining the Transacton
		 Transaction trans = session.beginTransaction();
		 
		 
		 // inserting a student into a database 
//		 School student = new School("yashwitha","chowdary","yash123",Gender.FEMALE,"chitoor",new Date());
//		 
//		 session.persist(student);
//		 
//		 trans.commit();
		 
		 // fetching a student
		 School stu = session.get(School.class, 3);
		 
		 System.out.println(stu);
		 
		 //updating a student data
		 
//		 stu.setUserName("venu123");
//		 session.merge(stu);
//		 trans.commit();
		 
		 
		//	Deleting a student 
		 
//		 session.remove(stu);		 
//		 trans.commit();
		 
		 session.close();
		 
		 
	}

}

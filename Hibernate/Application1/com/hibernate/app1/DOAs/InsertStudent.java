package com.hibernate.app1.DOAs;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.hibernate.app1.domain.Student;

//Insert Student object as student record into Database.
public class InsertStudent {
	public static void main(String args[]){
		
		Configuration cfg = new Configuration();
		cfg.configure("hibernate.cfg.xml");
		
		SessionFactory sf = cfg.buildSessionFactory();
		
		
		//open session
		Session s = sf.openSession();
		
		//Begin transaction
		Transaction tx = s.beginTransaction();
		
		//Create student object
		Student s1 = new Student();
		s1.setSno(11);
		s1.setSname("Sachin");
		s1.setEmail("abc@gmail.com");
		s1.setMobile(9975293733L);
		
		s.save(s1);
		s.flush();
		tx.commit(); // commit transaction
		s.close();   // close connection
		
	}
	

}

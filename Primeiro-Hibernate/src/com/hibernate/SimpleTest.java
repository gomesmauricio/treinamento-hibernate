package com.hibernate;

import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.classic.Session;

public class SimpleTest {

	public static void main(String[] args) {
		
		Configuration cfg = new Configuration();
		cfg.configure("hibernate.cfg.xml");
		
		SessionFactory factory = cfg.buildSessionFactory();
		Session session = factory.openSession();
		Student student = new Student();
		student.setId(1L);
		student.setName("Zé Mané");
		student.setRoll("101");
		student.setPhone("9999");
		student.setDegree("B.E");
		
		Transaction tx = session.beginTransaction();
		session.save(student);
		System.out.println("Objeto salvo com secesso......!!");
		tx.commit();
		session.close();
		factory.close();

	}

}

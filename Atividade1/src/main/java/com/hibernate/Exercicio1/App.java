package com.hibernate.Exercicio1;

import java.util.Vector;

import javax.persistence.Query;

import org.hibernate.Session;

import com.hibernate.util.HibernateUtil;
import com.hibernate.view.Principal;

public class App {

	public void create(Usuarios user) {

		Session session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();

		session.save(user);

		session.getTransaction().commit();
		session.close();
	}

	
	public void update(int id) {
		Usuarios usuario = new Usuarios();
		usuario.setId(1);
		usuario.setNome("Ligia");

		Session session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();

		session.update(usuario);

		session.getTransaction().commit();
		session.close();
	}

	public void delete() {
		Usuarios usuario = new Usuarios();
		usuario.setId(1);

		Session session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();

		session.delete(usuario);

		session.getTransaction().commit();
		session.close();
	}
/*
	
	
	public Vector<Vector<Object>> getUsuarios() {
		Session session = HibernateUtil.getSessionFactory().openSession();
		
		Query query = session.createQuery("select * from usuarios");
		
		Vector<Vector<Object>> usuarios =  (Vector<Vector<Object>>) query.getResultList();
		
		return usuarios;
		
	}
*/

	public Usuarios read(int id) {
		Session session = HibernateUtil.getSessionFactory().openSession();

		int usuarioId = id;
		Usuarios usuario = session.get(Usuarios.class, usuarioId);
		session.close();
		
		return usuario;
	}

	public static void main(String[] args) {
		Principal p = new Principal();
//		p.setModal(true);
		p.setVisible(true);
		
//		App manager = new App();
//        manager.create();
//        manager.update();
//        manager.delete();
//		manager.read();
//		HibernateUtil.shutdown();
	}

}

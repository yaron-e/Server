package main;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import database.HibernateUtil;
import database.User;

public class Start {

	private static SessionFactory factory;
	private static Session session;

	public static void Close()
	{
		if (session.isOpen())
			session.close();
	}

	public static Session getSession() {
		return session;
	}
	public static void main(String[] args) {

		factory = HibernateUtil.getSessionFactory();
		session = factory.openSession();

		InsertTestData();

		Close();									

		System.exit(0);
	}

	private static void InsertTestData() {

		Transaction tx = null;
		try {
			tx = session.beginTransaction();

			User u = new User();
			u.setUserName("admin");
			u.setFirstName("admin");
			u.setLastName("admin");
			u.setPassword("1234"); // Need to secure password by hashing
			u.setPhone("7031234567");
			u.setEmail("email@notreal.com");

			getSession().save(u);

			tx.commit();
		} catch(Exception e) {
			e.printStackTrace();
			if( tx != null){
				tx.rollback();
			}
		}
	}

}

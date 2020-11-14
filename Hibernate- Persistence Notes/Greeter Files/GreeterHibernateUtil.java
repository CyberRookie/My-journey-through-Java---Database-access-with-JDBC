package net.javaguides.usermanagement.utl;

import java.util.Properties;

import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.cfg.Environment;
import org.hibernate.service.ServiceRegistry;

import net.javaguides.usermanagement.model.User;

/**
 * 07/21/20 1:00PM
  This is a Helper class to help BootStrap Hibernate
  SessionFactory. Should only be instantiated once
 */

public class HibernateUtil {
	
 private static SessionFactory sessionFactory;

 	public static SessionFactory getSessionFactory() {
 		if (sessionFactory == null) {
 			try {
 				Configuration configuration = new Configuration();

 	// Hibernate settings equivalent to hibernate.cfg.xml's properties
 		Properties settings = new Properties();
 		   settings.put(Environment.DRIVER, "com.mysql.cj.jdbc.Driver");
 		   settings.put(Environment.URL, "jdbc:mysql://localhost:3306/users?useSSL=false");
 		   settings.put(Environment.USER, "root");
 		   settings.put(Environment.PASS, "Steelers01!");
 		   settings.put(Environment.DIALECT, "org.hibernate.dialect.MySQL5Dialect");

 		   settings.put(Environment.SHOW_SQL, "true");

 		   settings.put(Environment.CURRENT_SESSION_CONTEXT_CLASS, "thread");

 		   settings.put(Environment.HBM2DDL_AUTO, "create-drop");

 			configuration.setProperties(settings);
 				configuration.addAnnotatedClass(User.class);

 				ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder()
 					.applySettings(configuration.getProperties()).build();
 			System.out.println("Hibernate Java Config serviceRegistry created");
 			sessionFactory = configuration.buildSessionFactory(serviceRegistry);
 			return sessionFactory;

 		} catch (Exception e) {
 			e.printStackTrace();
 		}
 	}
 	return sessionFactory;
 	}
}



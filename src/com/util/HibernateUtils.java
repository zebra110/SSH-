package com.util;

import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;

public final class HibernateUtils {

	private static SessionFactory sessionFactory;

	private HibernateUtils() {
	}

	static {
		try {

			/** 此方法在Hibernate4中被标记为过�? */
			// sessionFactory = new
			// Configuration().configure().buildSessionFactory();

			/** Hibernate4取得SessionFactory的方�? */
			Configuration config = new Configuration().configure();
			
			// 在Hibernate4.3.6版本中，ServiceRegistryBuilder被标记为已过�?
			//ServiceRegistry serviceRegistry = new ServiceRegistryBuilder().applySettings(cfg.getProperties()).buildServiceRegistry();//不推�?
			ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder().applySettings(config.getProperties()).build();//推荐

			sessionFactory = config.buildSessionFactory(serviceRegistry);

		} catch (Throwable e) {
			throw new ExceptionInInitializerError(e);
		}
	}

	public static SessionFactory getSessionFactory() {
		return sessionFactory;
	}
}

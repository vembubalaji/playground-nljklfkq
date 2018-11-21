
package com.tu.hibernate;

import java.util.HashMap;
import java.util.Map;

import org.hibernate.SessionFactory;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Environment;

import com.tu.hibernate.entity.Domain;
import com.tu.hibernate.entity.Region;
import com.tu.hibernate.entity.Team;
import com.tu.hibernate.entity.User;

public class HibernateUtil {
	private static StandardServiceRegistry registry;
	private static SessionFactory sessionFactory;

	public static SessionFactory getSessionFactory() {
		if (sessionFactory == null) {
			try {
				StandardServiceRegistryBuilder registryBuilder = new StandardServiceRegistryBuilder();

				// Configuration properties
				Map<String, Object> settings = new HashMap<>();
				settings.put(Environment.DRIVER, "org.hsqldb.jdbcDriver");
				settings.put(Environment.URL, "jdbc:hsqldb:mem:test");
				settings.put(Environment.USER, "sa");
				settings.put(Environment.PASS, "");
				settings.put(Environment.HBM2DDL_AUTO, "none");
				settings.put(Environment.SHOW_SQL, true);
				settings.put(Environment.DIALECT, "org.hibernate.dialect.HSQLDialect");
				settings.put(Environment.HBM2DDL_IMPORT_FILES, "schema.sql");
				settings.put(Environment.HBM2DDL_AUTO, "create");

				registryBuilder.applySettings(settings);
				registry = registryBuilder.build();

				MetadataSources sources = new MetadataSources(registry);
				sources.addAnnotatedClass(Domain.class);
				sources.addAnnotatedClass(User.class);
				sources.addAnnotatedClass(Region.class);
				sources.addAnnotatedClass(Team.class);
				Metadata metadata = sources.getMetadataBuilder().build();

				sessionFactory = metadata.getSessionFactoryBuilder().build();
			} catch (Exception e) {
				if (registry != null) {
					StandardServiceRegistryBuilder.destroy(registry);
				}
				e.printStackTrace();
			}
		}
		return sessionFactory;
	}

	public static void shutdown() {
		if (registry != null) {
			StandardServiceRegistryBuilder.destroy(registry);
		}
	}
}

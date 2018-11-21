// { autofold

package com.tu.nativesqlsample;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.hibernate.Session;
import org.hibernate.type.IntegerType;
import org.hibernate.type.StringType;

import com.tu.hibernate.HibernateUtil;

public class NativeQueryScalars {

	static Logger logger = Logger.getLogger(NativeQueryScalars.class.getName());
	static String dash = "--------------------------------------------------------------";

	public static void main(String[] args) {
		Session session = null;
		try {
			session = HibernateUtil.getSessionFactory().openSession();

			addScalar(session);

		} catch (Exception e) {
			logger.warning(e.toString());
		} finally {
			if (session != null) {
				session.close();
			}
		}

		HibernateUtil.shutdown();
	}

	@SuppressWarnings("unchecked")
	public static void addScalar(Session session) {
		logger.info(dash);
		// } 
		List<Object[]> domain = session.createNativeQuery("SELECT * FROM domain")
				.addScalar("domain_id", IntegerType.INSTANCE).addScalar("domainName", StringType.INSTANCE).list();

		domain.stream().forEach(objects -> {
			Integer id = (Integer) objects[0];
			String name = (String) objects[1];
			System.out.println(String.format("Info: Domain[ %d, %s ]", id, name));

		});
	}

}

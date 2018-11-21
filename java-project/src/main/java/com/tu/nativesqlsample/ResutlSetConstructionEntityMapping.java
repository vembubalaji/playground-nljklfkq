// { autofold

package com.tu.nativesqlsample;

import java.util.logging.Logger;
import java.util.stream.Stream;

import org.hibernate.Session;

import com.tu.hibernate.HibernateUtil;
import com.tu.hibernate.entity.Domain;

public class ResutlSetConstructionEntityMapping {
	static Logger logger = Logger.getLogger(ResutlSetConstructionEntityMapping.class.getName());
	static String dash = "--------------------------------------------------------------";

	public static void main(String[] args) {
		Session session = null;

		try {
			session = HibernateUtil.getSessionFactory().openSession();
			entityMapping(session);			
		} catch (Exception e) {
			logger.warning(e.getMessage());
		} finally {
			if (session != null) {
				session.close();
			}
		}

		HibernateUtil.shutdown();
	}
	
	public static void entityMapping(Session session) {
		logger.info(dash);

		// 2.5.1 Mapping Native query to Entity - with JPA version 2.2
		// }
		Stream<Domain> domainStream = session.createNativeQuery("SELECT * FROM domain ", Domain.class)
				.getResultStream();
		domainStream.map(d -> d.getDomainName() + " is the domainName with Id " + d.getDomainId())
				.forEach(m -> System.out.println("Info : "+m));

	}
}

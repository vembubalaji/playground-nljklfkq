// { autofold

package com.tu.nativesqlsample;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.hibernate.Session;

import com.tu.hibernate.HibernateUtil;
import com.tu.hibernate.entity.Domain;

public class ResutlSetConstructionSqlResultSetMapping {
	static Logger logger = Logger.getLogger(ResutlSetConstructionSqlResultSetMapping.class.getName());
	static String dash = "--------------------------------------------------------------";

	public static void main(String[] args) {
		Session session = null;

		try {
			session = HibernateUtil.getSessionFactory().openSession();

			sqlResultSetMapping(session);

		} catch (Exception e) {
			logger.warning(e.getMessage());
		} finally {
			if (session != null) {
				session.close();
			}
		}

		HibernateUtil.shutdown();
	}

	@SuppressWarnings({ "unchecked" })
	public static void sqlResultSetMapping(Session session) {
		// 2.5.2 - basic Result set mapping using @SqlResultSetMapping

		// }
		List<Domain> results = session
				.createNativeQuery("SELECT domain_id as id, domainName as name FROM domain", "DomainResult")
				.getResultList();

		results.stream().forEach(result -> {
			System.out.println((String.format("Info : team[ %d, %s ]", result.getDomainId(), result.getDomainName())));			
		});
	}
}

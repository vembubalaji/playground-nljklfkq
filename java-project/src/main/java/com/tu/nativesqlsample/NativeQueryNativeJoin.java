
package com.tu.nativesqlsample;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.hibernate.Session;

import com.tu.hibernate.HibernateUtil;

public class NativeQueryNativeJoin {

	static Logger logger = Logger.getLogger(NativeQueryNativeJoin.class.getName());
	static String dash = "--------------------------------------------------------------";

	public static void main(String[] args) {
		Session session = null;
		try {
			session = HibernateUtil.getSessionFactory().openSession();
			nativeJoin(session);

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
	public static void nativeJoin(Session session) {
		// 2.4.1 Native query with JOIN
		logger.info(dash);
		List<Object[]> user = session.createNativeQuery(""
				+ "select u.name, t.team_id from user u left outer join team t on u.team_id=t.team_id  where u.user_id=?")
				.setParameter(1, 1).list();

		user.stream().forEach(objects -> {
			String name = (String) objects[0];
			int teamId = (int) objects[1];
			if (logger.isLoggable(Level.INFO)) {
				logger.info(String.format("User[ %s, %d ]", name, teamId));
			}
		});
	}
}

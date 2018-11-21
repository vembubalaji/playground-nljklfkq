// { autofold

package com.tu.nativesqlsample;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.hibernate.Session;

import com.tu.hibernate.HibernateUtil;

public class NativeQueryParameterBinding {

	static Logger logger = Logger.getLogger(NativeQueryNativeJoinWithEntity.class.getName());
	static String dash = "--------------------------------------------------------------";

	public static void main(String[] args) {
		Session session = null;
		try {
			session = HibernateUtil.getSessionFactory().openSession();

			logger.info(dash);
			// 2.2 Native query - parameter binding
			parameterBinding(session);
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
	public static void parameterBinding(Session session) {
		
		// }
		List<Object[]> users = session.createNativeQuery(
				"SELECT user_Id,name,username,isadmin,region_id,team_id,domain_id FROM user u where u.user_id=?")
				.setParameter(1, 1).list();

		users.stream().forEach(objects -> {
			Integer id = (Integer) objects[0];
			String name = (String) objects[1];
			if (logger.isLoggable(Level.INFO)) {
				logger.info(String.format("Info: User[ %d, %s ]", id, name));
			}
		});
	}
}
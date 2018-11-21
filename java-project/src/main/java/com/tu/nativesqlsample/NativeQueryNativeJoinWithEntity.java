// { autofold
package com.tu.nativesqlsample;

import java.util.List;
import java.util.logging.Logger;

import org.hibernate.Session;

import com.tu.hibernate.HibernateUtil;
import com.tu.hibernate.entity.Team;
import com.tu.hibernate.entity.User;

public class NativeQueryNativeJoinWithEntity {

	static Logger logger = Logger.getLogger(NativeQueryNativeJoinWithEntity.class.getName());
	static String dash = "--------------------------------------------------------------";

	public static void main(String[] args) {
		Session session = null;
		try {
			session = HibernateUtil.getSessionFactory().openSession();

			// Mapping Native JOIN query to Entities
			nativeJoinWithEntity(session);

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
	public static void nativeJoinWithEntity(Session session) {
		logger.info(dash);
	  // }
		List<Object[]> usersJoin = session
				.createNativeQuery(
						"select u.*, t.* from user u left outer join team t on u.team_id=t.team_id  where u.user_id=?")
				.addEntity("u", User.class).addJoin("t", "u.team").setParameter(1, 1).list();

		usersJoin.stream().forEach(object -> { // The user's object list would contain a User instance and a
												// "joined"
												// team instance.
			User userJoin = (User) object[0];
			logger.info("User - " + userJoin.getName());
			logger.info("User Domain - " + userJoin.getDomain().getDomainName());
			Team teamJoin = (Team) object[1];
			logger.info("Info: User Team Name " + teamJoin.getTeamName());
		});
	}
}

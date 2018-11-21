// { autofold

package com.tu.nativesqlsample;

import java.util.List;
import java.util.logging.Logger;

import org.hibernate.Session;
import org.hibernate.transform.Transformers;

import com.tu.dto.CustomDTO;
import com.tu.dto.MoreCustomDTO;
import com.tu.hibernate.CustomResultTransformer;
import com.tu.hibernate.HibernateUtil;

public class ResutlSetConstructionTransformer {
	static Logger logger = Logger.getLogger(ResutlSetConstructionTransformer.class.getName());
	static String dash = "--------------------------------------------------------------";

	public static void main(String[] args) {
		Session session = null;

		try {
			session = HibernateUtil.getSessionFactory().openSession();
			transformer(session);

		} catch (Exception e) {
			logger.warning(e.getMessage());
		} finally {
			if (session != null) {
				session.close();
			}
		}

		HibernateUtil.shutdown();
	}

	@SuppressWarnings({ "unchecked", "deprecation" })
	public static void transformer(Session session) {

		// }
		List<CustomDTO> custom = session.createNamedQuery("3tableJoin")
				.setResultTransformer(Transformers.aliasToBean(CustomDTO.class)).setParameter(1, 1).list();

		CustomDTO dto = custom.get(0);
		System.out.println("Info: Domain Name from default Result Transformer " + dto.getDomainName());
		System.out.println("Info: User Name from default Result Transformer " + dto.getUserName());

		System.out.println(dash);

		List<MoreCustomDTO> moreCustom = session.createNamedQuery("3tableJoin")
				.setResultTransformer(new CustomResultTransformer()).setParameter(1, 2).list();

		MoreCustomDTO dto1 = moreCustom.get(0);
		System.out.println("Info:  Domain Name from custom Result Transformer " + dto1.getdName());
		System.out.println("Info: User Name from custom Result Transformer " + dto1.getName());

		System.out.println(dash);
	}

}

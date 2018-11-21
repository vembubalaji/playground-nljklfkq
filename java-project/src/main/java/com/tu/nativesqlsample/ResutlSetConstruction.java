
package com.tu.nativesqlsample;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Stream;

import org.hibernate.Session;
import org.hibernate.transform.Transformers;

import com.tu.dto.CustomDTO;
import com.tu.dto.MoreCustomDTO;
import com.tu.hibernate.CustomResultTransformer;
import com.tu.hibernate.HibernateUtil;
import com.tu.hibernate.entity.Domain;

public class ResutlSetConstruction {
	static Logger logger = Logger.getLogger(ResutlSetConstruction.class.getName());
	static String dash = "--------------------------------------------------------------";

	@SuppressWarnings({ "unchecked", "deprecation" })
	public static void main(String[] args) {
		Session session = null;

		try {
			session = HibernateUtil.getSessionFactory().openSession();
			logger.info(dash);

			// 2.5.1 Mapping Native query to Entity - with JPA version 2.2
			Stream<Domain> domainStream = session.createNativeQuery("SELECT * FROM domain ", Domain.class)
					.getResultStream();
			domainStream.map(d -> d.getDomainName() + " is the domainName with Id " + d.getDomainId())
					.forEach(m -> logger.info(m));

			logger.info(dash);
			// 2.5.2 - basic Result set mapping using @SqlResultSetMapping
			List<Domain> results = session
					.createNativeQuery("SELECT domain_id as id, domainName as name FROM domain", "DomainResult")
					.getResultList();

			results.stream().forEach(result -> {
				if (logger.isLoggable(Level.INFO)) {
					logger.info(String.format("team[ %d, %s ]", result.getDomainId(), result.getDomainName()));
				}
			});
			logger.info(dash);
			// 2.6 - namedNativeQuery
			// 2.5.2 - Result Transformer
			List<CustomDTO> custom = session.createNamedQuery("3tableJoin")
					.setResultTransformer(Transformers.aliasToBean(CustomDTO.class)).setParameter(1, 1).list();

			CustomDTO dto = custom.get(0);
			logger.info("Domain Name from default Result Transformer " + dto.getDomainName());
			logger.info("User Name from default Result Transformer " + dto.getUserName());

			logger.info(dash);

			List<MoreCustomDTO> moreCustom = session.createNamedQuery("3tableJoin")
					.setResultTransformer(new CustomResultTransformer()).setParameter(1, 2).list();

			MoreCustomDTO dto1 = moreCustom.get(0);
			logger.info("Domain Name from custom Result Transformer " + dto1.getdName());
			logger.info("User Name from custom Result Transformer " + dto1.getName());

			logger.info(dash);

		} catch (Exception e) {
			logger.warning(e.getMessage());
		} finally {
			if (session != null) {
				session.close();
			}
		}

		HibernateUtil.shutdown();
	}
}

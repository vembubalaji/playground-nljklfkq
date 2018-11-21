package com.tu.nativesqlsample;

import org.hibernate.Session;
import org.junit.Before;
import org.junit.Test;

import com.tu.hibernate.HibernateUtil;

public class ResultSetConstructionTest {
	static Session session = null;

	@Before
	public void beforeTest() {
		session = HibernateUtil.getSessionFactory().openSession();
	}

	@Test
	public void testCustomTransformer() {
		ResutlSetConstructionCustomTransformer.transformer(session);
	}

	@Test
	public void testSqlResultSetMapping() {
		ResutlSetConstructionSqlResultSetMapping.sqlResultSetMapping(session);
	}

	@Test
	public void testtransformer() {
		ResutlSetConstructionTransformer.transformer(session);
	}
}

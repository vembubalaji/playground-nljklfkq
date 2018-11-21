package com.tu.nativesqlsample;

import org.hibernate.Session;
import org.junit.Before;
import org.junit.Test;

import com.tu.hibernate.HibernateUtil;

public class NativeQueryNativeScalarsTest {

	static Session session = null;

	@Before
	public void setSession() {
		session = HibernateUtil.getSessionFactory().openSession();
	}

	@Test
	public void testAddScalar() {
		NativeQueryScalars.addScalar(session);
	}

}

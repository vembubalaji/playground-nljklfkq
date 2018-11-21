package com.tu.nativesqlsample;

import org.hibernate.Session;
import org.junit.Before;
import org.junit.Test;

import com.tu.hibernate.HibernateUtil;

public class NativeQueryNativeJoinTest {

	static Session session = null;

	@Before
	public void setSession() {
		session = HibernateUtil.getSessionFactory().openSession();
	}

	@Test
	public void testNativeJoin() {
		NativeQueryNativeJoin.nativeJoin(session);
	}

}

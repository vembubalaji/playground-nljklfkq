
package com.tu.hibernate;

import java.util.List;

import org.hibernate.transform.ResultTransformer;

import com.tu.dto.MoreCustomDTO;

public class CustomResultTransformer implements ResultTransformer {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	public Object transformTuple(Object[] tuple, String[] aliases) {
		return new MoreCustomDTO((String) tuple[0], (String) tuple[1], (String) tuple[2]);
	}

	@Override
	public List transformList(List collection) {
		return collection;
	}
}


package com.tu.dto;


public class MoreCustomDTO {

	private String name;
	private String tName;
	private String dName;

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the tName
	 */
	public String gettName() {
		return tName;
	}

	/**
	 * @param tName the tName to set
	 */
	public void settName(String tName) {
		this.tName = tName;
	}

	/**
	 * @return the dName
	 */
	public String getdName() {
		return dName;
	}

	/**
	 * @param dName the dName to set
	 */
	public void setdName(String dName) {
		this.dName = dName;
	}

	/**
	 * @param name
	 * @param tName
	 * @param dName
	 */
	public MoreCustomDTO(String name, String tName, String dName) {
		super();
		this.name = name;
		this.tName = tName;
		this.dName = dName;
	}
}

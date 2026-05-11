package bean;

import java.io.Serializable;

public class Subject implements Serializable {
	private String cd;
	private String name;
	private School school;
	/**
	 * @return sd
	 */
	public String getCd() {
		return cd;
	}
	/**
	 * @param sd セットする cd
	 */
	public void setCd(String cd) {
		this.cd = cd;
	}
	/**
	 * @return name
	 */
	public String getName() {
		return name;
	}
	/**
	 * @param name セットする name
	 */
	public void setName(String name) {
		this.name = name;
	}
	
	public School getSchool() {
		return school;
	}
	
	public void setSchool(School school) {
		this.school = school;
	}

}

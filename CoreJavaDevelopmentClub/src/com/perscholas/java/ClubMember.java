package com.perscholas.java;

public class ClubMember {

	
	String memberName;
	String city;
	String state;
	String lang;
	
	public ClubMember(String memberName, String city, String state, String lang) {
		this.memberName = memberName;
		this.city = city;
		this.state = state;
		this.lang = lang;
	}

	@Override
	public String toString() {
		return "ClubMember [memberName=" + memberName + ", city=" + city + ", state=" + state + ", lang=" + lang + "]";
	}

	public String getMemberName() {
		return memberName;
	}

	public void setMemberName(String memberName) {
		this.memberName = memberName;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getLang() {
		return lang;
	}

	public void setLang(String lang) {
		this.lang = lang;
	}
	
}

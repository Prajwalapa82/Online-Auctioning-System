/*
 * RegistrationBean.java
 *
 * 
 */

package com.dts.dae.model;

import java.sql.Date;

import org.apache.struts.action.ActionForm;

/**
 *
 * @author
 */
public class Profile extends ActionForm {

	private int secretqid;
	// private String bdate;
	private String loginid;
	private String password;
	private String newpassword;

	private String firstname;
	private String middlename;
	private String lastname;
	private String gender;
	private String regtype;

	private String logintype;

	private int status;

	private String date;

	private int roleid;

	private int flogin;

	private String timezone;

	private String city;

	private String address;

	private String phoneNo;

	private String email;

	private String bdate;

	private Date birthDate1;

	private String state;

	private String country;
	private String pincode;
	private String passwordmoddate;

	private String profilemoddate;

	public int getSecretqid() {
		return secretqid;
	}

	public void setSecretqid(int secretqid) {
		this.secretqid = secretqid;
	}

	public String getLoginid() {
		return loginid;
	}

	public void setLoginid(String loginid) {
		this.loginid = loginid;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getNewpassword() {
		return newpassword;
	}

	public void setNewpassword(String newpassword) {
		this.newpassword = newpassword;
	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getMiddlename() {
		return middlename;
	}

	public void setMiddlename(String middlename) {
		this.middlename = middlename;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getRegtype() {
		return regtype;
	}

	public void setRegtype(String regtype) {
		this.regtype = regtype;
	}

	public String getLogintype() {
		return logintype;
	}

	public void setLogintype(String logintype) {
		this.logintype = logintype;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public int getRoleid() {
		return roleid;
	}

	public void setRoleid(int roleid) {
		this.roleid = roleid;
	}

	public int getFlogin() {
		return flogin;
	}

	public void setFlogin(int flogin) {
		this.flogin = flogin;
	}

	public String getTimezone() {
		return timezone;
	}

	public void setTimezone(String timezone) {
		this.timezone = timezone;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getPhoneNo() {
		return phoneNo;
	}

	public void setPhoneNo(String phoneNo) {
		this.phoneNo = phoneNo;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getBdate() {
		return bdate;
	}

	public void setBdate(String bdate) {
		this.bdate = bdate;
	}



	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getPincode() {
		return pincode;
	}

	public void setPincode(String pincode) {
		this.pincode = pincode;
	}

	public String getPasswordmoddate() {
		return passwordmoddate;
	}

	public void setPasswordmoddate(String passwordmoddate) {
		this.passwordmoddate = passwordmoddate;
	}

	public String getProfilemoddate() {
		return profilemoddate;
	}

	public void setProfilemoddate(String profilemoddate) {
		this.profilemoddate = profilemoddate;
	}

}

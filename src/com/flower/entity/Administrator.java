package com.flower.entity;

import java.sql.Date;

public class Administrator {
	private int adminId;
	private String loginName;
	private String loginPwd;
	private String gender;
	private Date birthday;
	private String address;
	private String phone;
	private String email;
	private String miBao;
	private String answer;
	public int getAdminId() {
		return adminId;
	}
	public void setAdminId(int adminId) {
		this.adminId = adminId;
	}
	public String getLoginName() {
		return loginName;
	}
	public void setLoginName(String loginName) {
		this.loginName = loginName;
	}
	public String getLoginPwd() {
		return loginPwd;
	}
	public void setLoginPwd(String loginPwd) {
		this.loginPwd = loginPwd;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public Date getBirthday() {
		return birthday;
	}
	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getMiBao() {
		return miBao;
	}
	public void setMiBao(String miBao) {
		this.miBao = miBao;
	}
	public String getAnswer() {
		return answer;
	}
	public void setAnswer(String answer) {
		this.answer = answer;
	}
	@Override
	public String toString() {
		return "Administrator [adminId=" + adminId + ", loginName=" + loginName
				+ ", loginPwd=" + loginPwd + ", gender=" + gender
				+ ", birthday=" + birthday + ", address=" + address
				+ ", phone=" + phone + ", email=" + email + ", miBao=" + miBao
				+ ", answer=" + answer + "]";
	}
	public Administrator() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Administrator(int adminId, String loginName, String loginPwd,
			String gender, Date birthday, String address, String phone,
			String email, String miBao, String answer) {
		super();
		this.adminId = adminId;
		this.loginName = loginName;
		this.loginPwd = loginPwd;
		this.gender = gender;
		this.birthday = birthday;
		this.address = address;
		this.phone = phone;
		this.email = email;
		this.miBao = miBao;
		this.answer = answer;
	}
	
	
	
	

}

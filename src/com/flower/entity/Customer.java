package com.flower.entity;

import java.sql.Date;

public class Customer {
	private int customerId;//�˿ͱ��
	private String nickName;//�ǳ�
	private String cPwd;//����
	private String gender;//�Ա�
	private String cName;// ��ʵ����
	
	private String phone;// �ֻ�����
	private String address;//��ַ
	private String headimg;//ͷ��
	private String miBao;//�ܱ�����
	private String answer;// �ܱ���
	
	
	
	public Customer() {
	}
	public int getCustomerId() {
		return customerId;
	}


	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}





	public String getNickName() {
		return nickName;
	}





	public void setNickName(String nickName) {
		this.nickName = nickName;
	}





	public String getcPwd() {
		return cPwd;
	}





	public void setcPwd(String cPwd) {
		this.cPwd = cPwd;
	}





	public String getGender() {
		return gender;
	}





	public void setGender(String gender) {
		this.gender = gender;
	}





	public String getcName() {
		return cName;
	}





	public void setcName(String cName) {
		this.cName = cName;
	}

	public String getPhone() {
		return phone;
	}





	public void setPhone(String phone) {
		this.phone = phone;
	}





	public String getAddress() {
		return address;
	}





	public void setAddress(String address) {
		this.address = address;
	}





	public String getHeadimg() {
		return headimg;
	}





	public void setHeadimg(String headimg) {
		this.headimg = headimg;
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





	public Customer(int customerId, String nickName, String cPwd,
			String gender, String cName,  String phone,
			String address, String headimg, String miBao, String answer) {
		super();
		this.customerId = customerId;
		this.nickName = nickName;
		this.cPwd = cPwd;
		this.gender = gender;
		this.cName = cName;
		
		this.phone = phone;
		this.address = address;
		this.headimg = headimg;
		this.miBao = miBao;
		this.answer = answer;
	}
	@Override
	public String toString() {
		return "Customer [customerId=" + customerId + ", nickName=" + nickName
				+ ", cPwd=" + cPwd + ", gender=" + gender + ", cName=" + cName
				+ ", phone=" + phone + ", address="
				+ address + ", headimg=" + headimg + ", miBao=" + miBao
				+ ", answer=" + answer + "]";
	}
	
	
	
}

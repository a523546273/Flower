package com.flower.entity;

import java.sql.Date;


public class Order {
	private int orderNo;//订单编号
	private int customerId;//顾客编号
	private int flowerId;//花的编号
	private int buyNumber;//购买的数量
	private Date creationTime;//创建时间
	private String orderAddress;//收货地址
	private int stateId;//订单状态编号
	private double total;//总价
	private String phone;
	
	//添加辅助列
		private String nickName; //顾客的昵称
		private String flowerName;//花的种类
		private String description;
		private double price;//花的单价
		private String state;//订单状态
		private String flowerimg1;
		
		
		public String getDescription() {
			return description;
		}
		public void setDescription(String description) {
			this.description = description;
		}
		public int getOrderNo() {
			return orderNo;
		}
		public void setOrderNo(int orderNo) {
			this.orderNo = orderNo;
		}
		public int getCustomerId() {
			return customerId;
		}
		public void setCustomerId(int customerId) {
			this.customerId = customerId;
		}
		public int getFlowerId() {
			return flowerId;
		}
		public void setFlowerId(int flowerId) {
			this.flowerId = flowerId;
		}
		public int getBuyNumber() {
			return buyNumber;
		}
		public void setBuyNumber(int buyNumber) {
			this.buyNumber = buyNumber;
		}
		public Date getCreationTime() {
			return creationTime;
		}
		public void setCreationTime(Date creationTime) {
			this.creationTime = creationTime;
		}
		public String getOrderAddress() {
			return orderAddress;
		}
		public void setOrderAddress(String orderAddress) {
			this.orderAddress = orderAddress;
		}
		public int getStateId() {
			return stateId;
		}
		public void setStateId(int stateId) {
			this.stateId = stateId;
		}
		public double getTotal() {
			return total;
		}
		public void setTotal(double total) {
			this.total = total;
		}
		public String getPhone() {
			return phone;
		}
		public void setPhone(String phone) {
			this.phone = phone;
		}
		public String getNickName() {
			return nickName;
		}
		public void setNickName(String nickName) {
			this.nickName = nickName;
		}
		public String getFlowerName() {
			return flowerName;
		}
		public void setFlowerName(String flowerName) {
			this.flowerName = flowerName;
		}
		public double getPrice() {
			return price;
		}
		public void setPrice(double price) {
			this.price = price;
		}
		public String getState() {
			return state;
		}
		public void setState(String state) {
			this.state = state;
		}
		public String getFlowerimg1() {
			return flowerimg1;
		}
		public void setFlowerimg1(String flowerimg1) {
			this.flowerimg1 = flowerimg1;
		}
		@Override
		public String toString() {
			return "Order [orderNo=" + orderNo + ", customerId=" + customerId
					+ ", flowerId=" + flowerId + ", buyNumber=" + buyNumber
					+ ", creationTime=" + creationTime + ", orderAddress="
					+ orderAddress + ", stateId=" + stateId + ", total="
					+ total + ", phone=" + phone + ", nickName=" + nickName
					+ ", flowerName=" + flowerName + ", price=" + price
					+ ", state=" + state + ", flowerimg1=" + flowerimg1 + "]";
		}
		
		public Order(int orderNo, int customerId, int flowerId, int buyNumber,
				Date creationTime, String orderAddress, int stateId,
				double total, String phone, String nickName, String flowerName,
				String description, double price, String state,
				String flowerimg1) {
			super();
			this.orderNo = orderNo;
			this.customerId = customerId;
			this.flowerId = flowerId;
			this.buyNumber = buyNumber;
			this.creationTime = creationTime;
			this.orderAddress = orderAddress;
			this.stateId = stateId;
			this.total = total;
			this.phone = phone;
			this.nickName = nickName;
			this.flowerName = flowerName;
			this.description = description;
			this.price = price;
			this.state = state;
			this.flowerimg1 = flowerimg1;
		}
		public Order() {
			super();
			// TODO Auto-generated constructor stub
		}
		
}

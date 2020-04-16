package com.flower.entity;

public class Flower {
	
	private int flowerId;      //���
	private String flowerName; //����	
	private double price;      //����
	private int stock;         //���  
	private int sold;          //��������
	private String flowerimg1;  //ͼƬ1Сͼ
	private String flowerimg2; //ͼƬ2��ͼ
	private String description;//����
	
	
	public Flower() {
		
	}
	public int getFlowerId() {
		return flowerId;
	}
	public void setFlowerId(int flowerId) {
		this.flowerId = flowerId;
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
	public int getStock() {
		return stock;
	}
	public void setStock(int stock) {
		this.stock = stock;
	}
	public int getSold() {
		return sold;
	}
	public void setSold(int sold) {
		this.sold = sold;
	}
	
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getFlowerimg1() {
		return flowerimg1;
	}
	public void setFlowerimg1(String flowerimg1) {
		this.flowerimg1 = flowerimg1;
	}
	public String getFlowerimg2() {
		return flowerimg2;
	}
	public void setFlowerimg2(String flowerimg2) {
		this.flowerimg2 = flowerimg2;
	}

	/**
	 * ȫ�ι���
	 * @param flowerId
	 * @param flowerName
	 * @param price
	 * @param stock
	 * @param sold
	 * @param flowerimg
	 * @param description
	 */
	public Flower(int flowerId, String flowerName, double price, int stock,
			int sold, String flowerimg1, String flowerimg2, String description) {
		super();
		this.flowerId = flowerId;
		this.flowerName = flowerName;
		this.price = price;
		this.stock = stock;
		this.sold = sold;
		this.flowerimg1 = flowerimg1;
		this.flowerimg2 = flowerimg2;
		this.description = description;
	}
	
	
	
	
	
	
	
	
	

}

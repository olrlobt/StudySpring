package com.ssafy.test.dto;

public class Electronics {
	private String electronicsCode;
	private String model;
	private String type;
	private int price;
	private String company;
	
	public Electronics() {
		// TODO Auto-generated constructor stub
	}
	
	public Electronics(String electronicsCode, String model, String type, int price, String company) {
		super();
		this.electronicsCode = electronicsCode;
		this.model = model;
		this.type = type;
		this.price = price;
		this.company = company;
	}
	public String getElectronicsCode() {
		return electronicsCode;
	}
	public void setElectronicsCode(String electronicsCode) {
		this.electronicsCode = electronicsCode;
	}
	public String getModel() {
		return model;
	}
	public void setModel(String model) {
		this.model = model;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public String getCompany() {
		return company;
	}
	public void setCompany(String company) {
		this.company = company;
	}


	@Override
	public String toString() {
		return "ElecDto [electronicsCode=" + electronicsCode + ", model=" + model + ", type=" + type + ", price="
				+ price + ", company=" + company + "]";
	}

}

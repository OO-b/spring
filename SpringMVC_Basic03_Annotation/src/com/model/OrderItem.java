package com.model;

//상품 한개를 다룰 수 있는 DTO 클래스
public class OrderItem {
	private int itemid;
	private int number;  //상품갯수
	private String remark; //주의사항
	
	public int getItemid() {
		return itemid;
	}
	public void setItemid(int itemid) {
		this.itemid = itemid;
	}
	public int getNumber() {
		return number;
	}
	public void setNumber(int number) {
		this.number = number;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	
	@Override
	public String toString() {
		return "OrderItem [itemid=" + itemid + ", number=" + number + ", remark=" + remark + "]";
	}
	
}

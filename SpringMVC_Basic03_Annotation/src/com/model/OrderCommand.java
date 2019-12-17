package com.model;

import java.util.List;

//주문서클래스
//하나의 주문은 여러개의 상품을 가질 수 있다.
public class OrderCommand { 
	private List<OrderItem> orderItem; //Key Point

	public List<OrderItem> getOrderItem() {
		return orderItem;
	}

	public void setOrderItem(List<OrderItem> orderItem) {
		this.orderItem = orderItem;
	}
	
	/*
	 주문 발생
	 OrderCommand command = new OrderCommand();
	 
	  List<OrderItem> list = new ArrayList<>();
	  list.add(new OrderItem(1,10,"파손주의");
	  list.add(new OrderItem(2,1,"리모콘별도");
	  list.add(new OrderItem(3,5,"사이즈교환불가");
	  
	  command.setOrderItem(list);
	  
	 */
	

}

package com.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.model.OrderCommand;
/*  -- TEST2와 비슷 
 * 
  	요청 주소는 하나 : method가 하나는 get방식, 하나는 post방식 
  	화면단 : order.do(GET)  >> 화면return 
  	처리단 : order.do(POST) >> 처리return 
 */
import com.model.OrderItem;

@Controller
@RequestMapping("order/order.do")
public class OrderController {
	
	
	@RequestMapping(method=RequestMethod.GET)
	public String form() {
		return "order/OrderForm";
	}
	
	// OrderCommand orderCommand
	// 1. OrderCommand orderCommand = new OrderCommand();
	// 2. setter 주입 
	// 3.OrderCommand가 가지고있는  List<OrderItem> list 멤버필드가 자동처리 됨 
	// List<OrderItem> list = new ... 알아서 함 
	// list.add(new OrderItem()) ...  orderItem[0].itemid,orderItem[0].number,orderItem[0].remark
	// orderCommand.setOrderItem()
	
	@RequestMapping(method=RequestMethod.POST)
	public String submit(OrderCommand orderCommand) {
		//System.out.println("orderCommand 주소 : " + orderCommand);
		//System.out.println("orderCommand Item 크기 : " + orderCommand.getOrderItem().size());
		
		List<OrderItem> items = orderCommand.getOrderItem();
		for(OrderItem item : items) {
			System.out.println(item.toString());
		}
		return "order/OrderCommited";
	}

}

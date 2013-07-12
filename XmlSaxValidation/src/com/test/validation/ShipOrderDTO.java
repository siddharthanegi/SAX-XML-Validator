package com.test.validation;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class ShipOrderDTO {
	
	private String orderPerson;
	private ShipTo shipto;
	private List<Item> items;
	
	public ShipOrderDTO() {
	
		items=new ArrayList<Item>();
		shipto=new ShipTo();
		// TODO Auto-generated constructor stub
	}
	
	public String getOrderPerson() {
		return orderPerson;
	}
	public void setOrderPerson(String orderPerson) {
		this.orderPerson = orderPerson;
	}
	public ShipTo getShipto() {
		return shipto;
	}
	public void setShipto(ShipTo shipto) {
		this.shipto = shipto;
	}
	public List<Item> getItems() {
		return items;
	}
	public void setItems(List<Item> items) {
		this.items = items;
	}
	

}

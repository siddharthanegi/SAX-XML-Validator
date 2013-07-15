package com.test.validation;

import java.util.Hashtable;
import java.util.Stack;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class ValidationHandler extends DefaultHandler {

	private ShipOrderDTO shipOrder;
	
	private ShipTo shipTo;
	private int qty;
	private String elementValue;
	private Stack<String> nodes;
	private boolean valid;
	private Hashtable<String,String> mandatoryElements; 
	
	public ShipOrderDTO getShipOrder() {
		return shipOrder;
	}
	public Hashtable<String, String> getMandatoryElements() {
		return mandatoryElements;
	}

	ValidationHandler(){
		valid=true;
		mandatoryElements=new Hashtable<String,String>();
		nodes=new Stack<String>();
		shipTo=new ShipTo();
		shipOrder=new ShipOrderDTO();
		
	}
	
	public void startElement(String uri, String localName, String qName,
			Attributes attributes) throws SAXException {

		elementValue="";
		nodes.push(qName);
//		if(qName.equals("shiporder")){
//			shipOrder=new ShipOrderDTO();
//		}
//		if(localName.equals("orderperson")){
//			
//		}
	}
	public void endElement (String uri, String localName, String qName)
			throws SAXException
		    {
		
				if(qName.equals("orderperson")){
					shipOrder.setOrderPerson(elementValue);
					String temp=elementValue.replace(" ", "");
					if(!temp.matches("[a-zA-Z]+")){
						setValid(false);
						System.out.println("Invalid");
					}
						
					
					
				}
				if(qName.equals("address")){
					shipTo.setAddress(elementValue);
					String temp=elementValue.replace(" ", "");
					if(!temp.matches("[0-9a-zA-Z]+")){
						setValid(false);
						System.out.println("invalid");
					}
					
				}
						
				
				if(qName.equals("quantity")){
					
					String temp=elementValue;
					if(!temp.matches("[0-9]+")){
						setValid(false);
						System.out.println("Invalid");
					}
					else{
						qty=(Integer.parseInt(elementValue));
					}
					//System.out.println(item.getQuantity());
				
				}
				if(qName.equals("item"))
				{
				//	System.out.println(item.getQuantity());
					shipOrder.getItems().add(new Item(qty));
					
				}
				
				//System.out.println("Popping: "+nodes.pop());
				
		
		
		    }
	public void endDocument()
	{
		shipOrder.setShipto(shipTo);
		
	}
	public void characters (char ch[], int start, int length)
			throws SAXException
		    {
			 elementValue=new String(ch,start,length);
		    }
	public boolean isValid() {
		return valid;
	}
	public void setValid(boolean validity) {
		this.valid = validity;
	}

}

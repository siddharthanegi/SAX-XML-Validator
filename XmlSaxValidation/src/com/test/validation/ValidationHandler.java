package com.test.validation;

import java.util.Hashtable;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class ValidationHandler extends DefaultHandler {

	private String elementValue;
	private boolean valid;
	private Hashtable<String,String> mandatoryElements; 
	
	public Hashtable<String, String> getMandatoryElements() {
		return mandatoryElements;
	}

	ValidationHandler(){
		valid=true;
		mandatoryElements=new Hashtable<String,String>();
	}
	
	public void startElement(String uri, String localName, String qName,
			Attributes attributes) throws SAXException {

		elementValue="";
//		if(localName.equals("orderperson")){
//			
//		}
	}
	public void endElement (String uri, String localName, String qName)
			throws SAXException
		    {
				if(qName.equals("title")){
					
					mandatoryElements.put(qName,elementValue);
					if( elementValue.isEmpty()){
					
					System.out.println("Invalid");
					elementValue="";
					setValid(false);
				}}
				if (qName.equals("quantity")){
					mandatoryElements.put(qName,elementValue);
					if(!elementValue.matches("[0-9]+")){
						System.out.println("Invalid");
						elementValue="";
						setValid(false);
					}
					
				//	System.out.println(elementValue);
				}
		
		
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

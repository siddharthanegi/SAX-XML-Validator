package com.test.validation;

import java.io.IOException;
import java.util.Hashtable;

import org.xml.sax.InputSource;
import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.XMLReaderFactory;


public class ValidatorMain {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			XMLReader xmlReader=XMLReaderFactory.createXMLReader( "org.apache.crimson.parser.XMLReaderImpl");
			xmlReader.setContentHandler(new ValidationHandler());
			xmlReader.parse(new InputSource("testxml.xml"));
			ValidationHandler check=(ValidationHandler) xmlReader.getContentHandler();
			Hashtable<String, String> mandatoryElements=check.getMandatoryElements();
			System.out.println(mandatoryElements.toString());
		} catch (SAXException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

}

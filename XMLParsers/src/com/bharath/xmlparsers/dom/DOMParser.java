package com.bharath.xmlparsers.dom;

import com.bharath.xmlparsers.dto.DriversLicense;
import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;

public class DOMParser {
    public static void main(String[] args) throws ParserConfigurationException, IOException, SAXException {

        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder documentBuilder = factory.newDocumentBuilder();
        Document document = documentBuilder.parse(ClassLoader.getSystemResourceAsStream("xml/DriversLicense.xml"));
        DriversLicense license = new DriversLicense();

        NodeList numberList = document.getElementsByTagName("Number");
        Node numberItem = numberList.item(0);
        license.setNumber(Long.parseLong(numberItem.getTextContent()));

        NodeList firstNameList = document.getElementsByTagName("FirstName");
        Node firstNameItem = firstNameList.item(0);
        license.setFirstName(firstNameItem.getTextContent());

        NodeList lastNameList = document.getElementsByTagName("LastName");
        Node lastNameItem = lastNameList.item(0);
        license.setLastName(lastNameItem.getTextContent());

        System.out.println(license.getNumber());
        System.out.println(license.getFirstName());
        System.out.println(license.getLastName());
    }
}

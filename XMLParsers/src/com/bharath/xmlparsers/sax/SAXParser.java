package com.bharath.xmlparsers.sax;

import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParserFactory;
import java.io.IOException;

public class SAXParser {
    public static void main(String[] args) throws ParserConfigurationException, SAXException, IOException {
        SAXParserFactory parserFactory = SAXParserFactory.newInstance();
        javax.xml.parsers.SAXParser parser = parserFactory.newSAXParser();

        SAXHandler handler = new SAXHandler();
        parser.parse(ClassLoader.getSystemResourceAsStream("xml/DriversLicense.xml"), handler);
        System.out.println(handler.getDriversLicense().getNumber());
        System.out.println(handler.getDriversLicense().getFirstName());
        System.out.println(handler.getDriversLicense().getLastName());
    }
}

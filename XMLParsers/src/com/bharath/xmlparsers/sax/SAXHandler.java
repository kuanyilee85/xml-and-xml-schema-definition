package com.bharath.xmlparsers.sax;

import com.bharath.xmlparsers.dto.DriversLicense;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class SAXHandler extends DefaultHandler {

    public DriversLicense getDriversLicense() {
        return driversLicense;
    }

    public void setDriversLicense(DriversLicense driversLicense) {
        this.driversLicense = driversLicense;
    }

    private DriversLicense driversLicense;
    private String content;

    @Override
    public void startElement (String uri, String localName,
                              String qName, Attributes attributes)
            throws SAXException
    {
        if(qName.equals("DriversLicense")){
            driversLicense = new DriversLicense();
        }
    }

    @Override
    public void endElement (String uri, String localName, String qName)
            throws SAXException
    {
        switch (qName){
            case "Number":
                driversLicense.setNumber(Long.parseLong(content));
                break;
            case "FirstName":
                driversLicense.setFirstName(content);
                break;
            case "LastName":
                driversLicense.setLastName(content);
                break;
        }
    }

    @Override
    public void characters (char ch[], int start, int length)
            throws SAXException
    {
        content = String.copyValueOf(ch, start, length).trim();
    }
}

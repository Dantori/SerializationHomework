package org.example.xml_dto;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;

public class Dul {

    @JacksonXmlProperty(localName = "documentType")
    private int documentType;
    @JacksonXmlProperty(localName = "firstName")
    private String firstName;
    @JacksonXmlProperty(localName = "lastName")
    private String lastName;
    @JacksonXmlProperty(localName = "secondName")
    private String secondName;
    @JacksonXmlProperty(localName = "number")
    private int number;
    @JacksonXmlProperty(localName = "series")
    private int series;

    public int getDocumentType() {
        return documentType;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getSecondName() {
        return secondName;
    }

    public int getNumber() {
        return number;
    }

    public int getSeries() {
        return series;
    }
}

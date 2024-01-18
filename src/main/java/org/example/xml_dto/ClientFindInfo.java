package org.example.xml_dto;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;

public class ClientFindInfo {

    @JacksonXmlProperty(localName = "dul")
    private Dul dul;

    @JacksonXmlProperty(localName = "partyId")
    private int partyId;

    public Dul getDul() {
        return dul;
    }

    public int getPartyId() {
        return partyId;
    }
}

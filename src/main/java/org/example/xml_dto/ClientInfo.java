package org.example.xml_dto;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;

@JacksonXmlRootElement(localName = "clientInfo")
public class ClientInfo {

    @JacksonXmlProperty(localName = "clientFindInfo")
    private ClientFindInfo clientFindInfo;

    public ClientFindInfo getClientFindInfo() {
        return clientFindInfo;
    }

    public void setClientFindInfo(ClientFindInfo clientFindInfo) {
        this.clientFindInfo = clientFindInfo;
    }
}

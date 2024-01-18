package org.example;

import org.example.business_logic.FormatTranslator;
import org.example.xml_dto.ClientInfo;

public class App {
    public static void main(String[] args) {
        ClientInfo clientInfo = FormatTranslator.xmlToDto("/ClientInfo.xml", ClientInfo.class);

        assert clientInfo != null;
        FormatTranslator.writeDtoToJsonFile(clientInfo, "src/main/resources/PersonInfo.json");
    }
}

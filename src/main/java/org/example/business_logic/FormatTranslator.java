package org.example.business_logic;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import org.example.xml_dto.ClientFindInfo;
import org.example.xml_dto.ClientInfo;
import org.example.xml_dto.Dul;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;

public final class FormatTranslator {

    public static <T> T xmlToDto(String xmlFile, Class<T> dto){
        XmlMapper xmlMapper = new XmlMapper();
        try(InputStream inputStream = FormatTranslator.class.getResourceAsStream(xmlFile)) {
            return xmlMapper.readValue(inputStream, dto);
        } catch (IOException e) {
            System.err.println("Произошла ошибка во время чтения XML: " + e.getMessage());
        }
        return null;
    }

    public static void writeDtoToJsonFile(ClientInfo clientInfo, String filePath) {
        ObjectMapper mapper = new ObjectMapper();
        mapper.enable(SerializationFeature.INDENT_OUTPUT);
        try {
            ClientFindInfo clientFindInfo = clientInfo.getClientFindInfo();
            Dul dul = clientFindInfo.getDul();

            // Create JSON structure
            ObjectNode rootNode = mapper.createObjectNode();
            ObjectNode personInfoNode = rootNode.putObject("PersonInfo");
            ObjectNode findPersonInfoNode = personInfoNode.putObject("FindPersonInfo");
            ObjectNode personNameNode = findPersonInfoNode.putObject("PersonName");
            personNameNode.put("LastName", dul.getLastName());
            personNameNode.put("FirstName", dul.getFirstName());
            personNameNode.put("MiddleName", dul.getSecondName());
            ObjectNode identityCardNode = findPersonInfoNode.putObject("IdentityCard");
            identityCardNode.put("IdType", dul.getDocumentType());
            identityCardNode.put("IdSeries", dul.getSeries());
            identityCardNode.put("IdNum", dul.getNumber());
            findPersonInfoNode.put("PartyID", clientFindInfo.getPartyId());

            ObjectWriter writer = mapper.writerWithDefaultPrettyPrinter();
            writer.writeValue(new File(filePath), rootNode);
        } catch (JsonProcessingException e) {
            System.err.println("Произошла ошибка во время создания JSON файла: " + e.getMessage());
        } catch (IOException e) {
            System.err.println("Произошла ошибка во время записи JSON файла: " + e.getMessage());
        }
    }
}

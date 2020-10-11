package core.parser;

import entity.dto.Serial;
import org.jsoup.nodes.Document;

public class KinoNewsParser implements ParseSerial {

    String name;
    @Override
    public Serial parseName(Document doc) {
        String name = doc.getElementsByClass("entitle").text();
        Serial serial = new Serial();
        serial.setName(name);
        return serial;
    }
}

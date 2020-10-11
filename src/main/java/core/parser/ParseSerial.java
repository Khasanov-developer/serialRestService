package core.parser;

import entity.dto.Serial;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

public interface ParseSerial {
    Serial parseName(Document doc);
}

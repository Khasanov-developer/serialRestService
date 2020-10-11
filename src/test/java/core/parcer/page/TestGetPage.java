package core.parcer.page;

import core.parser.KinoNewsParser;
import core.parser.ParseSerial;
import core.parser.page.GetPage;
import core.parser.page.GetPageImpl;
import org.jsoup.nodes.Document;

public class TestGetPage {
    public static void main(String[] args) {
        String url;
        url = "https://www.kinonews.ru/serial_43078/game-of-thrones";
        GetPage page = new GetPageImpl();
        Document doc = page.getPage(url);
        ParseSerial myTitle = new KinoNewsParser();
        System.out.println(myTitle.getName(doc));
    }
}

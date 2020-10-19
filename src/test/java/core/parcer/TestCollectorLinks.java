package core.parcer;

import core.collector.CollectKinoNewsSerialLinks;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import java.io.IOException;

public class TestCollectorLinks {
    public static void main(String[] args) throws IOException {
        Document linksDoc = Jsoup.connect("https://www.kinonews.ru/serials-year1950/").userAgent("Mozilla").get();
        CollectKinoNewsSerialLinks parce = new CollectKinoNewsSerialLinks();
        System.out.println(parce.getCurrentYear(linksDoc));
    }
}

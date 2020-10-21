package core.parcer;

import core.collector.CollectKinoNewsSerialLinks;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;

public class TestCollectorLinks {
    String link;
    String src;


    public static void main(String[] args) throws IOException {
        Document linksDoc = Jsoup.connect("https://www.kinonews.ru/serials-year1995").userAgent("Mozilla").get();
        CollectKinoNewsSerialLinks parce = new CollectKinoNewsSerialLinks();
        System.out.println(parce.getCurrentYearSerialLinks(linksDoc));
    }
}

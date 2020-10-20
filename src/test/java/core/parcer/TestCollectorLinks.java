package core.parcer;

import core.collector.CollectKinoNewsSerialLinks;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;

public class TestCollectorLinks {
    public static void main(String[] args) throws IOException {
        Document linksDoc = Jsoup.connect("https://www.kinonews.ru/serials-year1995_page6/").userAgent("Mozilla").get();
        CollectKinoNewsSerialLinks parce = new CollectKinoNewsSerialLinks();
        System.out.println(parce.getCurrentYearSerialLinks(linksDoc));
//        Elements elements = linksDoc.select("li.img-page > a");
//        if (elements.size() > 0) {
//            String el = elements.attr("abs:href");
//            System.out.println(el);
//        }
    }
}

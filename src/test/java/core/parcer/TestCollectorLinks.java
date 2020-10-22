package core.parcer;

import core.collector.CollectKinoNewsSerialLinks;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class TestCollectorLinks {
    String link;
    String src;


    public static void main(String[] args) throws IOException {
        Document linksDoc = Jsoup.connect("https://www.kinonews.ru/serials-year2018/").userAgent("Mozilla").get();
        CollectKinoNewsSerialLinks parce = new CollectKinoNewsSerialLinks();
        System.out.println(parce.collectLinks(linksDoc));
//        List<String> links = new ArrayList<>();
//
//        //Ссылки для текущей страницы списка сериалов
//        Elements elements = linksDoc.select("div.zhanr_left > a");
//        for (Element e : elements) {
//            links.add(e.attr("abs:href"));
//        }
//        System.out.println(links);
//        System.out.println(links.size());
    }
}

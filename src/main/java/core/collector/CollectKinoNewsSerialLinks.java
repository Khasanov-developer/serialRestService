package core.collector;

import entity.dto.Seria;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class CollectKinoNewsSerialLinks {

    public void collectString() throws IOException {
        //Подключение к ссылке
        Document linksDoc = Jsoup.connect("https://www.kinonews.ru/serials-year1950/").userAgent("Mozilla").get();
        //Выборка элементов a из div (порядкового номера 1)
        Elements links = linksDoc.select("div.zhanr_left div:eq(1) a");
        //Заносим линки в массив
        if (links.size() > 0) {
            List<String> serialsLinks = new ArrayList<>();
            for (Element e : links) {
                //Используем аттрибут для получения полной ссылки
                serialsLinks.add(e.attr("abs:href"));
            } ;
            System.out.println(serialsLinks);
        }
        //Ищем и достаем ссылку на следующий год
        Elements nextYearLinks = linksDoc.select("div.block-page-new a:eq(1)");
        String nextYearLink = nextYearLinks.attr("abs:href");
        System.out.println(nextYearLink);
        }

}

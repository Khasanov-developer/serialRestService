package core.collector;


import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;


import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CollectKinoNewsSerialLinks implements ParseSerialLinks<Document> {


    @Override
    public List<String> collectLinks(Document html) {
        //Выборка элементов a из div (порядкового номера 1)
        Elements links = html.select("div.zhanr_left div:eq(1) a");
        List<String> serialsLinks = new ArrayList<>();
        ;
        //Заносим линки в массив
        if (links.size() > 0) {
            for (Element e : links) {
                //Используем аттрибут для получения полной ссылки
                serialsLinks.add(e.attr("abs:href"));
            }
        }
        return serialsLinks;
    }


    public String getNextYearLink(Document html) {
        Elements nextYearLinks = html.select("div.block-page-new a:eq(1)");
        String nextYearLink = nextYearLinks.attr("abs:href");
        return nextYearLink;
    }

    public String getCurrentYear(Document html) {
        Elements years = html.select("div.block-page-new h1");
        String currentYear = years.first().text();
        Pattern yearPattern = Pattern.compile("\\d+");
        Matcher yearMatcher = yearPattern.matcher(currentYear);
        while (yearMatcher.find()) {
            currentYear = yearMatcher.group(0);
        }
        return currentYear;
    }

}


package core.parcer.page;

import core.parser.page.GetPage;
import core.parser.page.GetPageImpl;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TestGetPage {
    public static void main(String[] args) {
        String url, urlAllPers, urlSeasons;
        urlSeasons = "https://www.kinonews.ru/serial_43078_seasons/";

        GetPage<Document> page = new GetPageImpl();
        Document html = page.getPage(urlSeasons);

        Elements elementsByTag = html.getElementsByClass("text").get(0).getElementsByTag("tr");

        for (Element tr : elementsByTag) {
            Elements tdElems = tr.getElementsByTag("td");

            String numberData = tdElems.get(0).text();
            Integer number = Integer.parseInt(numberData.split(" ")[1]);
            System.out.println("num:"+number);

            String seriaData = tdElems.get(1).text();

            Pattern pattern = Pattern.compile("(?<name>.+),\\s*(?<date>\\S+)");
            Matcher matcher = pattern.matcher(seriaData);

            while (matcher.find()) {
                System.out.println("name:"+matcher.group("name"));
                System.out.println("date:"+matcher.group("date"));
            }

        }
    }
}

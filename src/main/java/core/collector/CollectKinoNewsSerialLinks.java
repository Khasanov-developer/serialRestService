package core.collector;


import core.parser.page.GetPage;
import core.parser.page.GetPageImpl;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static java.lang.Integer.parseInt;

public class CollectKinoNewsSerialLinks implements ParseSerialLinks<Document> {

    private static final GetPage<Document> getPage = new GetPageImpl();

    public String getCurrentYear(Document html) {
        Elements years = html.select("div.block-page-new h1");
        String currentYear = years.first().text();
        Pattern yearPattern = Pattern.compile("\\d+\\S");
        Matcher yearMatcher = yearPattern.matcher(currentYear);
        while (yearMatcher.find()) {
            currentYear = yearMatcher.group(0);
        }
        return currentYear;
    }

    public List<String> collectLinks(Document html) {

        List<String> allLinks = new ArrayList<>();
        int year = parseInt(getCurrentYear(html));

        Document currentHtml = html;
        while (year < 2020) {
            allLinks.addAll(getCurrentYearSerialLinks(currentHtml));
            String nextYearLink = getNextYearLink(html);
            year++;
            currentHtml = getPage.getPage(nextYearLink);
        }
        return allLinks;
    }

    @Override
    public List<String> getCurrentYearSerialLinks(Document html) {
        List<String> links = new ArrayList<>();

        //Ссылки для текущей страницы списка сериалов
        Elements elements = html.select("div.zhanr_left div:eq(1) a");
        for (Element e : elements) {
            links.add(e.attr("abs:href"));
        }

        //Получение ссылки на следующую страницу !!! Не работает пока что
        Elements nextPageLinkElements = html.select("li.img-page > a");
        if (nextPageLinkElements.size() > 0) {
            Document nextHtml = getPage.getPage(nextPageLinkElements.get(0).text());
            links.addAll(getCurrentYearSerialLinks(nextHtml));
        }
        return links;
    }


    public String getNextYearLink(Document html) {
        Elements nextYearLinks = html.select("div.block-page-new a:eq(1)");
        String nextYearLink = nextYearLinks.attr("abs:href");
        return nextYearLink;
    }


}


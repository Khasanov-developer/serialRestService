package core.parser.page;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

public interface GetPage {
    Document getPage(String url);
}

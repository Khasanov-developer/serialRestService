package core.parser.page;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

public interface пGetPage {
    Document getPage(String url);
}

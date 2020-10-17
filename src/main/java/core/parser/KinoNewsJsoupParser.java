package core.parser;

import core.parser.page.GetPage;
import core.parser.page.GetPageImpl;
import entity.dto.Season;
import entity.dto.Seria;
import entity.dto.Serial;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class KinoNewsJsoupParser extends KinoNewsParser<Document> {

    KinoNewsJsoupParser(Document mainHtml, Document seasonsHtml, Document allPersonsHtml) {
        super(mainHtml, seasonsHtml, allPersonsHtml);
    }

    @Override
    void parseName(Document html, Serial serial) {
        String name = html.getElementsByClass("entitle").text();
        serial.setName(name);
    }

    @Override
    void parseDescription(Document html, Serial serial) {
        String description = html.getElementsByAttributeValue("itemprop", "description").get(0).text();
        serial.setDescription(description);
    }

    @Override
    void parseGenres(Document html, Serial serial) {
        List<String> genres = html.getElementsByAttributeValue("itemprop", "genre").stream()
                .map(Element::text)
                .collect(Collectors.toList());
        serial.setGenreList(genres);
    }

    @Override
    void parseStartYear(Document html, Serial serial) {
        String startYear = html.getElementsByAttributeValueContaining("href", "serials-year").get(0).text();
        serial.setStartYear(startYear);
    }

    @Override
    void parseFinishYear(Document html, Serial serial) {
        String finishYear = html.getElementsByAttributeValueContaining("href", "serials-year").get(1).text();
        serial.setFinishYear(finishYear);
    }

    @Override
    void parseSeasons(Document html, Serial serial) {
        Elements seasonElements = html.getElementsByClass("text");
        List<Season> seasons = new ArrayList<>();

        for (Element seasonElement : seasonElements) {
            seasons.add(parseSeason(seasonElement));
        }

        serial.setSeasonList(seasons);
    }

    @Override
    void parseCreators(Document html, Serial serial) {

    }

    @Override
    void parseScreenWriter(Document html, Serial serial) {

    }

    @Override
    void parseComposers(Document html, Serial serial) {

    }

    @Override
    void parseOperators(Document html, Serial serial) {

    }

    @Override
    void parseProducers(Document html, Serial serial) {

    }

    @Override
    void parseActors(Document html, Serial serial) {

    }

    @Override
    void parseCountries(Document html, Serial serial) {

    }

    @Override
    void parsePremiereDate(Document html, Serial serial) {

    }

    @Override
    void parseFilmCompany(Document html, Serial serial) {

    }

    private Season parseSeason(Element seasonElement) {
        Season season = new Season();

        String seasonData = seasonElement.getElementsByClass("btext14").get(0).text();
        Pattern seasonPattern = Pattern.compile("(?:СЕЗОН)\\s*(?<number>\\d+)\\s*(?<start>\\S*)\\s*-\\s*(?<finish>\\S*)");
        Matcher seasonMatcher = seasonPattern.matcher(seasonData);

        while (seasonMatcher.find()) {
            season.setNumber(Integer.parseInt(seasonMatcher.group("number")));
            try {
                season.setStartDate(new java.sql.Date(dateFormat.parse(seasonMatcher.group("start")).getTime()));
                season.setFinishDate(new java.sql.Date(dateFormat.parse(seasonMatcher.group("finish")).getTime()));
            } catch (ParseException e) {
                e.printStackTrace();
            }
        }

        //parseSeria
        List<Seria> seriaList = new ArrayList<>();
        Elements elementsByTag = seasonElement.getElementsByTag("tr");

        for (Element seriaElem : elementsByTag) {
            seriaList.add(parseSeria(seriaElem));
        }
        season.setSeriesCount(seriaList.size());
        season.setSeriaList(seriaList);

        return season;
    }

    private Seria parseSeria(Element seriaElement) {
        Seria seria = new Seria();

        Elements tdElems = seriaElement.getElementsByTag("td");

        String numberData = tdElems.get(0).text();
        Integer number = Integer.parseInt(numberData.split(" ")[1]);
        seria.setNumber(number);

        String seriaData = tdElems.get(1).text();
        Pattern pattern = Pattern.compile("(?<name>.+),\\s*(?<date>\\S+)");
        Matcher matcher = pattern.matcher(seriaData);

        while (matcher.find()) {
            seria.setName(matcher.group("name"));
            try {
                seria.setDate(new java.sql.Date(dateFormat.parse(matcher.group("date")).getTime()));
            } catch (ParseException e) {
                e.printStackTrace();
            }
        }

        return seria;
    }

    public static void main(String[] args) {
        String url, urlAllPers, urlSeasons;
        url = "https://www.kinonews.ru/serial_43078/game-of-thrones";
        urlAllPers = "https://www.kinonews.ru/serial_43078_allperson/";
        urlSeasons = "https://www.kinonews.ru/serial_43078_seasons/";

        GetPage<Document> page = new GetPageImpl();
        Document html = page.getPage(url);
        Document htmlPers = page.getPage(urlAllPers);
        Document htmlSeasons = page.getPage(urlSeasons);

        KinoNewsParser<Document> parser = new KinoNewsJsoupParser(html, htmlSeasons, htmlPers);
        Serial serial = parser.parse();

//        System.out.println(serial.getStartYear());
//        System.out.println(serial.getFinishYear());
//
//        for (Season season : serial.getSeasonList()) {
//            System.out.print(season.getNumber());
//            System.out.print(" ");
//            System.out.print(season.getSeriesCount());
//            System.out.print(" ");
//            System.out.print(season.getStartDate());
//            System.out.print(" ");
//            System.out.println(season.getFinishDate());
//
//            for (Seria seria : season.getSeriaList()) {
//                System.out.print(seria.getNumber());
//                System.out.print(" ");
//                System.out.print(seria.getName());
//                System.out.print(" ");
//                System.out.println(seria.getDate());
//            }
//            System.out.println();
//        }
    }
}

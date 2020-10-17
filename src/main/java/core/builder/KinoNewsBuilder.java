//package core.builder;
//
//import core.parser.KinoNewsParser;
//import core.parser.ParseSerial;
//import core.parser.page.GetPage;
//import core.parser.page.GetPageImpl;
//import entity.dto.Serial;
//import org.jsoup.nodes.Document;
//
//public class KinoNewsBuilder implements BuildSerial{
//    private static final ParseSerial<Document> parseSerial = new KinoNewsParser();
//    private static final GetPage<Document> getPage = new GetPageImpl();
//    private static final String url = "https://www.kinonews.ru/";
//
//    public KinoNewsBuilder(){
//    }
//
//    @Override
//    public Serial build() {
//        Serial serial = new Serial();
//
//
//    }
//}

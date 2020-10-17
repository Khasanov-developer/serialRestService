package core.utils;

public class KinoNewsLinkFormer {

    public static final String URL = "https://www.kinonews.ru/";

    public static String getSeasonsLink(String serialId) {
        return URL.concat("serial_").concat(serialId).concat("_allperson");
    }

    public static String getAllPersonsLink(String serialId) {
        return URL.concat("serial_").concat(serialId).concat("_seasons");
    }
}

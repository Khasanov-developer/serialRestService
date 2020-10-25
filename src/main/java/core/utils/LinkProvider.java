package core.utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class LinkProvider {

    private static Properties prop = null;

    private LinkProvider() {
    }

    public static String getLink() {
        return getProps().getProperty("KinonewsLink");
    }

    public static Properties getProps() {
        if (prop == null) {
            try (InputStream input = new FileInputStream("src/main/resources/config.properties")) {
                prop = new Properties();
                prop.load(input);
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
        return prop;
    }
}

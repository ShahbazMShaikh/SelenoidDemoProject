package util;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigReader {
    private static Properties properties;

    /**
     * This method is used to load the properties from config.properties file
     *
     */
    public Properties init_prop() {
        properties = new Properties();
        try {
            FileInputStream ip = new FileInputStream("src/test/resources/config/config.properties");
            properties.load(ip);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return properties;
    }

    public static String getProperty(String variable) {
        return properties.getProperty(variable);
    }
}

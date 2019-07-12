package utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class Util {
    public static Properties loadProperties(String fileName) throws IOException {
        Properties properties = new Properties();
        FileInputStream in = new FileInputStream("src/" + fileName);
        properties.load(in);
        return properties;
    }
}

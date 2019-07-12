package utils;

import java.io.File;
import java.io.FileInputStream;

public class HTMLUtil {
    public static String readHTMLFile(File file) {
        try {
            if (file.exists()) {
                FileInputStream fin = new FileInputStream(file);
                byte[] buf = new byte[fin.available()];
                fin.read(buf);
                fin.close();
                return new String(buf, 0, buf.length);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }
}

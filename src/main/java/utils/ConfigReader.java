package utils;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public class ConfigReader {
    Properties pro;

    public ConfigReader() {

        File src = new File("./config.properties");
        try {
            FileInputStream fis = new FileInputStream(src);
            pro = new Properties();
            pro.load(fis);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public String get_link() {
        String signIn_Path = pro.getProperty("signin_link");
        return signIn_Path;
    }

}

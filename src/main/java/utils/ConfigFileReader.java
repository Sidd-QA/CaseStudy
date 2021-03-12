package utils;


import java.io.*;
import java.util.Properties;

public class ConfigFileReader {
   public Properties properties = null;

public ConfigFileReader(String path){
    loadPropertiesFile(path);
}

    public void loadPropertiesFile(String path) {
        BufferedReader reader;
        try {
            reader = new BufferedReader(new FileReader(path));
            properties = new Properties();
            try {
                properties.load(reader);
                reader.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public Properties getProperties() {
        return properties;
    }
}

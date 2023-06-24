package utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Properties;

/**
 * Utility class containing static method for getting properties from the property file
 *
 * @author a.balyabin
 */
public class PropertiesUtil {
    public static final Properties properties = new Properties();
    private static final String ENV_PROPERTIES_PATH = "src/main/resources/environment.properties";

    public static PropertiesUtil environment = new PropertiesUtil();

    public void load(InputStream io) {
        try {
            properties.load(io);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Method for getting value from the property file
     *
     * @param key - property key
     * @return String This returns value of the property
     */
    public static String getProperty(String key) {

        File file = new File(ENV_PROPERTIES_PATH);
        try (FileInputStream io = new FileInputStream(file)) {
            environment.load(io);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return properties.getProperty(key);
    }
}

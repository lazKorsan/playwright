package Utilities.utilities;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class ConfigLoader {
    private static ConfigLoader configLoader;
    private final Properties properties;

    private ConfigLoader() {
        properties = new Properties();
        // Dosya adı güncellendi: loyalFriendCare.properties
        try (InputStream inputStream = getClass().getClassLoader().getResourceAsStream("loyalFriendCare.properties")) {
            if (inputStream != null) {
                properties.load(inputStream);
            } else {
                throw new RuntimeException("Property file 'loyalFriendCare.properties' not found in the classpath");
            }
        } catch (IOException e) {
            throw new RuntimeException("Failed to load configuration properties", e);
        }
    }

    public static ConfigLoader getInstance() {
        if (configLoader == null) {
            configLoader = new ConfigLoader();
        }
        return configLoader;
    }

    public String getLoyalUrl() {
        String prop = properties.getProperty("loyal");
        if (prop != null) {
            return prop;
        } else {
            throw new RuntimeException("Property 'loyal' is not specified in the loyalFriendCare.properties file");
        }
    }

    public String getBrowser() {
        String prop = properties.getProperty("browser");
        if (prop != null) {
            return prop;
        } else {
            // Varsayılan olarak chrome dönebilir veya hata fırlatabiliriz.
            // Şimdilik null dönmemesi için varsayılan değer atıyoruz.
            return "chrome";
        }
    }

    public String getProperty(String key) {
        return properties.getProperty(key);
    }
}

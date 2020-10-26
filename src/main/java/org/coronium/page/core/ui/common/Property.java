package org.coronium.page.core.ui.common;

import org.apache.commons.lang3.StringUtils;

import java.io.IOException;
import java.io.InputStream;
import java.util.Objects;
import java.util.Properties;

public enum Property {
    APP_PATH("appPath"),
    APPLICATION_NAME("applicationName"),
    BROWSER("browser"),
    BROWSER_STACK("browserStack"),
    BROWSER_VERSION("browserVersion"),
    CAPTURE_URL("captureURL"),
    GRID_URL("gridURL"),
    HEADLESS("headless"),
    MAXIMISE("maximise"),
    PROXY("proxy"),
    PLATFORM("platform"),
    PLATFORM_VERSION("platformVersion"),
    RESOLUTION("resolution"),
    SAUCE("sauce");

    private static Properties properties;
    private  String systemPropertyKey;
    private  Object value;

    Property(String proxy) {
        this.systemPropertyKey = proxy;
        this.value = retrieveValue(proxy);
    }

    private String retrieveValue(String key) {
        if (System.getProperty(key) != null) {
            return System.getProperty(key);
        } else {
            return getValueFromConfigFile(key);
        }
    }

    private static String getValueFromConfigFile(String key) {
        if (properties == null) {
            properties = loadConfigFile();
        }

        Object objFromFile = properties.get(key);
        if (objFromFile != null) {
            return Objects.toString(objFromFile);
        } else {
            return null;
        }
    }

    private static java.util.Properties loadConfigFile() {
        String configFileName = System.getProperty("config");

        if (StringUtils.isBlank(configFileName)) {
            return new java.util.Properties();
        }

        try (InputStream configFileStream =
                     ClassLoader.getSystemClassLoader()
                             .getResourceAsStream(configFileName)) {
            java.util.Properties properties = new java.util.Properties();
            properties.load(configFileStream);
            return properties;
        } catch (IOException e) {
            throw new IllegalArgumentException(
                    "Properties file '" + configFileName + "' not found.", e);
        }
    }

    /**
     * @return true iff the maximise property is equal, ignoring case, to "true"
     */
    public static boolean wantToMaximise() {
        return MAXIMISE.isSpecified()
                && Boolean.parseBoolean(MAXIMISE.getValue());
    }

    public String getValue() {
        return retrieveValue(this.systemPropertyKey);
    }

    public boolean isSpecified() {
        return StringUtils.isNotEmpty((CharSequence) value);
    }

    public boolean getBoolean() {
        return isSpecified() && Boolean.parseBoolean(String.valueOf(value));
    }
}

package ru.asgubin.rsr.utils;

import org.apache.commons.lang3.SystemUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.Paths;
import java.util.Objects;
import java.util.Properties;

public final class AppProperties {

    private static final Logger LOG = LoggerFactory.getLogger(AppProperties.class);

    private final Properties properties;

    private AppProperties() {

        Properties properties = new Properties();
        LOG.debug("Create empty properties");

        String charsetName = SystemUtils.IS_OS_LINUX ? "UTF-8" : "windows-1251";
        LOG.debug("Get charsetName: " + charsetName);

        LOG.debug("Going load properties file");
        try (InputStreamReader input =
                    new InputStreamReader(
                            Objects.requireNonNull(getClass()
                                    .getClassLoader()
                                    .getResourceAsStream("application.properties")), charsetName)) {
            properties.load(input);

            LOG.debug("Application properties file successful load");

            // Read external application properties
            if(System.getProperty("application.properties") != null) {

                try (InputStreamReader externalInput =
                             new InputStreamReader(new FileInputStream(
                                     System.getProperty("application.properties")), charsetName)) {

                    properties.load(externalInput);

                    LOG.debug("External application properties file successful load");
                }
            }
        } catch (IOException e) {
            LOG.error("Can't load application.properties " + e);
        }

        this.properties = properties;
    }

    private static class ReadPropertiesHolder {
        private static final AppProperties INSTANCE = new AppProperties();
    }

    public static Properties getProperties() {
        //LOG.debug("ReadProperties.access() called");
        return ReadPropertiesHolder.INSTANCE.properties;
    }
}

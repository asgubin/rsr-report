package ru.asgubin.rsr.clients.rest.rsrdb;

import jakarta.ws.rs.client.Client;
import jakarta.ws.rs.client.ClientBuilder;
import jakarta.ws.rs.client.WebTarget;
import ru.asgubin.rsr.utils.AppProperties;

import java.util.Properties;

public class RsrDbWebTargetFactory {

    private final Client client;

    private RsrDbWebTargetFactory() {
        this.client = ClientBuilder.newClient();
    }

    private static class SingletonHelper {
        private static final RsrDbWebTargetFactory INSTANCE = new RsrDbWebTargetFactory();
    }

    public static RsrDbWebTargetFactory getInstance() {
        return SingletonHelper.INSTANCE;
    }

    public WebTarget getWebTarget(String rsrDbName) {

        Properties properties = AppProperties.getProperties();

        if (!properties.getProperty("rsrDbName").equals(rsrDbName)) {
            properties.setProperty("rsrDbName", rsrDbName);
        }

        return this.client
                .target(properties.getProperty("restURI"))
                .path(properties.getProperty("rsrDbName"));
    }
}
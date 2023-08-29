package ru.asgubin.rsr.clients.rest.rsrfmea;

import jakarta.ws.rs.client.Client;
import jakarta.ws.rs.client.ClientBuilder;
import jakarta.ws.rs.client.WebTarget;
import ru.asgubin.rsr.utils.AppProperties;

import java.util.Properties;

public class RsrFmeaTargetFactory {

    private final Client client;

    private RsrFmeaTargetFactory() {
        this.client = ClientBuilder.newClient();
    }

    private static class SingletonHelper {
        private static final RsrFmeaTargetFactory INSTANCE = new RsrFmeaTargetFactory();
    }

    public static RsrFmeaTargetFactory getInstance() {
        return RsrFmeaTargetFactory.SingletonHelper.INSTANCE;
    }

    public WebTarget getWebTarget() {

        Properties properties = AppProperties.getProperties();

        return this.client
                .target(properties.getProperty("restFmeaURI"));
    }
}

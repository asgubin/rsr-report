package ru.asgubin.rsr.clients.soap.rsrresultdb;

import ru.asgubin.rsr.rsrresultdb.RsrResultDbServiceImp;
import ru.asgubin.rsr.rsrresultdb.RsrResultDbServiceImpService;
import ru.asgubin.rsr.utils.AppProperties;

import java.io.IOException;
import java.net.URL;
import java.util.Properties;

public class DataSourceFactory {
    private final RsrResultDbServiceImpService service;

    private DataSourceFactory() {
        RsrResultDbServiceImpService service = new RsrResultDbServiceImpService();

        try{
            Properties properties = AppProperties.getProperties();

            URL url = new URL(properties.getProperty("rsrResultDbService"));
            service = new RsrResultDbServiceImpService(url);

        } catch (IOException e) {
            e.printStackTrace();
        }

        this.service = service;
    }

    private static class SingletonHelper {
        private static final DataSourceFactory INSTANCE = new DataSourceFactory();
    }

    public static RsrResultDbServiceImp getRsrResults() {
        return SingletonHelper.INSTANCE.service.getRsrResultDbServiceImpPort();
    }
}

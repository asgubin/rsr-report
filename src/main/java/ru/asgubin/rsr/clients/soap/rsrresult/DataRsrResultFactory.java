package ru.asgubin.rsr.clients.soap.rsrresult;

import ru.asgubin.rsr.rsrresult.RsrService;
import ru.asgubin.rsr.rsrresult.RsrServiceImplService;
import ru.asgubin.rsr.utils.AppProperties;

import java.io.IOException;
import java.net.URL;
import java.util.Properties;

public class DataRsrResultFactory {
    private final RsrServiceImplService service;

    private DataRsrResultFactory() {
        RsrServiceImplService service = new RsrServiceImplService();

        try{
            Properties properties = AppProperties.getProperties();

            URL url = new URL(properties.getProperty("rsrResultService"));
            service = new RsrServiceImplService(url);

        } catch (IOException e) {
            e.printStackTrace();
        }

        this.service = service;
    }

    private static class SingletonHelper {
        private static final DataRsrResultFactory INSTANCE = new DataRsrResultFactory();
    }

    public static RsrService getRsrResults() {
        return DataRsrResultFactory.SingletonHelper.INSTANCE.service.getRsrServiceImplPort();
    }
}

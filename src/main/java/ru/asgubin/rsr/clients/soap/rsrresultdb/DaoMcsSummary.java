package ru.asgubin.rsr.clients.soap.rsrresultdb;

import ru.asgubin.rsr.rsrresultdb.McsSummary;
import ru.asgubin.rsr.rsrresultdb.RsrResultFileException_Exception;

public class DaoMcsSummary {
    private DaoMcsSummary() {
    }

    private static class SingletonHelper {
        private static final DaoMcsSummary INSTANCE = new DaoMcsSummary();
    }

    public static DaoMcsSummary getInstance() {
        return DaoMcsSummary.SingletonHelper.INSTANCE;
    }

    public McsSummary getMcsSummary(String rsrResultFile)
            throws RsrResultFileException_Exception {

        return DataSourceFactory.getRsrResults()
                .getMcsSummary(rsrResultFile);
    }
}

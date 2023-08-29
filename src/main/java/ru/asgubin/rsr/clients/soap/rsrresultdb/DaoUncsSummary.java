package ru.asgubin.rsr.clients.soap.rsrresultdb;

import ru.asgubin.rsr.rsrresultdb.RsrResultFileException_Exception;
import ru.asgubin.rsr.rsrresultdb.UncsSummary;

public class DaoUncsSummary {
    private DaoUncsSummary() {
    }

    private static class SingletonHelper {
        private static final DaoUncsSummary INSTANCE = new DaoUncsSummary();
    }

    public static DaoUncsSummary getInstance() {
        return DaoUncsSummary.SingletonHelper.INSTANCE;
    }

    public UncsSummary getUncsSummary(String rsrResultFile)
            throws RsrResultFileException_Exception {

        return DataSourceFactory.getRsrResults()
                .getUncsSummary(rsrResultFile);
    }
}

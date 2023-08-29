package ru.asgubin.rsr.clients.soap.rsrresultdb;

import ru.asgubin.rsr.rsrresultdb.Mcs;
import ru.asgubin.rsr.rsrresultdb.RsrDbException_Exception;
import ru.asgubin.rsr.rsrresultdb.RsrResultFileException_Exception;

import java.util.List;

public class DaoMcs {

    private DaoMcs() {
    }

    private static class SingletonHelper {
        private static final DaoMcs INSTANCE = new DaoMcs();
    }

    public static DaoMcs getInstance() {
        return SingletonHelper.INSTANCE;
    }

    public List<Mcs> getMcsList(String rsrResultFile, String rsrDbName)
            throws RsrResultFileException_Exception, RsrDbException_Exception {

        return DataSourceFactory.getRsrResults()
                .getMcsList(rsrResultFile, rsrDbName);
    }
}

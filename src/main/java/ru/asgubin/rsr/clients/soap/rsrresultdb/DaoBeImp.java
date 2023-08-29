package ru.asgubin.rsr.clients.soap.rsrresultdb;

import ru.asgubin.rsr.rsrresultdb.BeImp;
import ru.asgubin.rsr.rsrresultdb.RsrDbException_Exception;
import ru.asgubin.rsr.rsrresultdb.RsrResultFileException_Exception;

import java.util.List;

public class DaoBeImp {
    private DaoBeImp() {
    }

    private static class SingletonHelper {
        private static final DaoBeImp INSTANCE = new DaoBeImp();
    }

    public static DaoBeImp getInstance() {
        return SingletonHelper.INSTANCE;
    }

    public List<BeImp> getBeImpList(String rsrResultFile, String rsrDbName)
            throws RsrResultFileException_Exception, RsrDbException_Exception {

        return DataSourceFactory.getRsrResults()
                .getBeImpList(rsrResultFile, rsrDbName);
    }
}

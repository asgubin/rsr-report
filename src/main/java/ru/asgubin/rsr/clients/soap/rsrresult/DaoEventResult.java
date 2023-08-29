package ru.asgubin.rsr.clients.soap.rsrresult;

import ru.asgubin.rsr.rsrresult.IOException_Exception;

import java.util.List;

public class DaoEventResult {
    private DaoEventResult() {
    }

    private static class SingletonHelper {
        private static final DaoEventResult INSTANCE = new DaoEventResult();
    }

    public static DaoEventResult getInstance() {
        return DaoEventResult.SingletonHelper.INSTANCE;
    }

    public List<Long> getEventResult(String rsrResultFile)
            throws IOException_Exception {

        return DataRsrResultFactory.getRsrResults().getEventResult(rsrResultFile);
    }
}

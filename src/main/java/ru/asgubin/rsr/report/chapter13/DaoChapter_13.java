package ru.asgubin.rsr.report.chapter13;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ru.asgubin.rsr.clients.rest.rsrdb.DaoAcaseDb;
import ru.asgubin.rsr.clients.soap.rsrresultdb.DaoBeImp;
import ru.asgubin.rsr.clients.rest.rsrdb.model.Acase;
import ru.asgubin.rsr.rsrresultdb.BeImp;
import ru.asgubin.rsr.rsrresultdb.RsrDbException_Exception;
import ru.asgubin.rsr.rsrresultdb.RsrResultFileException_Exception;
import ru.asgubin.rsr.utils.BasicFolder;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class DaoChapter_13 {
    private static final Logger LOG = LoggerFactory.getLogger(DaoChapter_13.class);

    private DaoChapter_13() {
    }

    private static class SingletonHelper {
        private static final DaoChapter_13 INSTANCE = new DaoChapter_13();
    }

    public static DaoChapter_13 getInstance() {
        return DaoChapter_13.SingletonHelper.INSTANCE;
    }

    public Chapter_13 getChapter_13(List<String> rsrResultFiles, String rsrDbName)
            throws RsrResultFileException_Exception, IOException, RsrDbException_Exception {

        List<Conclusion> conclusions = new ArrayList<>();
        for (String file : rsrResultFiles) {
            conclusions.add(getConclusion(file, rsrDbName));
        }

        return new Chapter_13(conclusions);
    }

    private Conclusion getConclusion(String rsrResultFile, String rsrDbName)
            throws IOException, RsrResultFileException_Exception, RsrDbException_Exception {

        int num = Integer.parseInt(BasicFolder.getInstance().getFileName(rsrResultFile));
        Acase acase = DaoAcaseDb.getInstance().getEvent(rsrDbName, num);

        BeImp beImp = DaoBeImp.getInstance().getBeImpList(rsrResultFile, rsrDbName).get(0);

        return new Conclusion(acase, beImp);
    }
}

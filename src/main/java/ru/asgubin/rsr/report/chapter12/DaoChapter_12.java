package ru.asgubin.rsr.report.chapter12;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ru.asgubin.rsr.clients.rest.rsrdb.DaoAcaseDb;
import ru.asgubin.rsr.clients.rest.rsrdb.DaoEventDb;
import ru.asgubin.rsr.clients.rest.rsrdb.model.Acase;
import ru.asgubin.rsr.clients.rest.rsrdb.model.Event;
import ru.asgubin.rsr.clients.soap.rsrresultdb.DaoBeImp;
import ru.asgubin.rsr.clients.soap.rsrresultdb.DaoMcs;
import ru.asgubin.rsr.clients.soap.rsrresultdb.DaoMcsSummary;
import ru.asgubin.rsr.clients.soap.rsrresultdb.DaoUncsSummary;
import ru.asgubin.rsr.report.chapter12.*;
import ru.asgubin.rsr.report.chapter12.pojo.EventMcsResultDb;
import ru.asgubin.rsr.rsrresultdb.Mcs;
import ru.asgubin.rsr.rsrresultdb.RsrDbException_Exception;
import ru.asgubin.rsr.rsrresultdb.RsrResultFileException_Exception;
import ru.asgubin.rsr.utils.BasicFolder;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class DaoChapter_12 {
    private static final Logger LOG = LoggerFactory.getLogger(DaoChapter_12.class);

    private DaoChapter_12() {
    }

    private static class SingletonHelper {
        private static final DaoChapter_12 INSTANCE = new DaoChapter_12();
    }

    public static DaoChapter_12 getInstance() {
        return DaoChapter_12.SingletonHelper.INSTANCE;
    }

    public Chapter_12 getChapter_12(List<String> rsrResultFiles, String rsrDbName)
            throws RsrResultFileException_Exception, RsrDbException_Exception, IOException {

        List<Chapter_12_1> chapter_12_1s = new ArrayList<>();
        for (String file : rsrResultFiles) {
            chapter_12_1s.add(getChapter_12_1(file, rsrDbName));
        }

        return new Chapter_12(chapter_12_1s);
    }

    private Chapter_12_1 getChapter_12_1(String rsrResultFile, String rsrDbName)
            throws RsrResultFileException_Exception, RsrDbException_Exception, IOException {

        int num = Integer.parseInt(BasicFolder.getInstance().getFileName(rsrResultFile));
        Acase acase = DaoAcaseDb.getInstance().getEvent(rsrDbName, num);

        return new Chapter_12_1(acase.getId(), acase.getText(),
                getChapter_12_1_1(rsrResultFile, rsrDbName),
                getChapter_12_1_2(rsrResultFile),
                getChapter_12_1_3(rsrResultFile, rsrDbName),
                rsrResultFile,
                rsrDbName);
    }

    private Chapter_12_1_1 getChapter_12_1_1(String rsrResultFile, String rsrDbName)
            throws RsrResultFileException_Exception, RsrDbException_Exception, IOException {

         return new Chapter_12_1_1(
                DaoMcsSummary.getInstance().getMcsSummary(rsrResultFile).getQBestApprox(),
                getTable_12_1_1_1(rsrResultFile, rsrDbName,
                        DaoMcs.getInstance().getMcsList(rsrResultFile, rsrDbName).size())
        );
    }

    public static List<TableRow_12_1_1_1> getTable_12_1_1_1(String rsrResultFile, String rsrDbName, int size)
            throws RsrResultFileException_Exception, RsrDbException_Exception, IOException {

        List<TableRow_12_1_1_1> table_12_1_1_1 = new ArrayList<>();

        int count = 0;
        for (Mcs mcs : DaoMcs.getInstance().getMcsList(rsrResultFile, rsrDbName)) {
            if (count < size) {
                boolean isFistEvent = true;
                for (Long eventNum : mcs.getEventIndexList()) {
                    Event event = DaoEventDb.getInstance().getEvent(rsrDbName, eventNum.intValue());

                    if (isFistEvent) {
                        table_12_1_1_1.add(new TableRow_12_1_1_1(
                                mcs.getNum(),
                                mcs.getProbability(),
                                mcs.getContribution(),
                                event.getId(),
                                event.getText()
                        ));
                        isFistEvent = false;
                        count++;
                    } else {
                        table_12_1_1_1.add(new TableRow_12_1_1_1(
                                "-",
                                "-",
                                "-",
                                event.getId(),
                                event.getText()
                        ));
                    }
                }
            }
            else return table_12_1_1_1;
        }

        return table_12_1_1_1;
    }

    private Chapter_12_1_2 getChapter_12_1_2(String rsrResultFile)
            throws RsrResultFileException_Exception {

        return new Chapter_12_1_2(
                DaoUncsSummary.getInstance().getUncsSummary(rsrResultFile));
    }

    private Chapter_12_1_3 getChapter_12_1_3(String rsrResultFile, String rsrDbName)
            throws RsrResultFileException_Exception, RsrDbException_Exception {

        return new Chapter_12_1_3(
                DaoBeImp.getInstance().getBeImpList(rsrResultFile, rsrDbName));
    }

//    private TableRow_12_1_1_1 getTableRow_12_1_1_1(Mcs mcs, String rsrDbName)
//            throws IOException {
//
//        List<EventMcsResultDb> eventMcsList = new ArrayList<>();
//
//        for (Long eventNum : mcs.getEventIndexList()) {
//            Event event = DaoEventDb.getInstance().getEvent(rsrDbName, eventNum.intValue());
//
//            eventMcsList.add(new EventMcsResultDb(event.getId().trim(), event.getText()));
//        }
//
//        return new TableRow_12_1_1_1(mcs, eventMcsList);
//    }
}

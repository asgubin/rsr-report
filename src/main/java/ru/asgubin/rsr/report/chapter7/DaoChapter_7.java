package ru.asgubin.rsr.report.chapter7;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ru.asgubin.rsr.clients.rest.rsrdb.DaoEventDb;
import ru.asgubin.rsr.clients.rest.rsrdb.model.Event;
import ru.asgubin.rsr.report.factory.BasicEvent;
import ru.asgubin.rsr.report.factory.TableRowFactory;
import ru.asgubin.rsr.report.types.EventType;
import ru.asgubin.rsr.rsrresult.IOException_Exception;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class DaoChapter_7 {
    private static final Logger LOG = LoggerFactory.getLogger(DaoChapter_7.class);

    private DaoChapter_7() {
    }

    private static class SingletonHelper {
        private static final DaoChapter_7 INSTANCE = new DaoChapter_7();
    }

    public static DaoChapter_7 getInstance() {
        return DaoChapter_7.SingletonHelper.INSTANCE;
    }

    public Chapter_7 getChapter_7(List<Event> eventList, String rsrDbName)
            throws IOException {

        return new Chapter_7(
                getChapter_7_1(eventList, rsrDbName),
                getChapter_7_2(eventList, rsrDbName)
        );
    }

    private Chapter_7_1 getChapter_7_1(List<Event> eventList, String rsrDbName)
            throws IOException {

        List<TableRow_7_1_1> table_7_1_1 = new ArrayList<>();
        for (Event event : eventList) {

            BasicEvent basicEvent = TableRowFactory.getInstance().getTableRow(rsrDbName, event);

            if (basicEvent instanceof TableRow_7_1_1) {
                table_7_1_1.add((TableRow_7_1_1)basicEvent);
            }
        }

        return new Chapter_7_1(table_7_1_1);
    }

    private Chapter_7_2 getChapter_7_2(List<Event> eventList, String rsrDbName)
            throws IOException {

        List<TableRow_7_2_1> table_7_2_1 = new ArrayList<>();
        for (Event event : eventList) {

            BasicEvent basicEvent = TableRowFactory.getInstance().getTableRow(rsrDbName, event);

            if (basicEvent instanceof TableRow_7_2_1) {
                table_7_2_1.add((TableRow_7_2_1)basicEvent);
            }
        }

        return new Chapter_7_2(table_7_2_1);
    }
}

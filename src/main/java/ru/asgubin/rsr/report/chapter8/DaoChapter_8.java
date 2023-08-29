package ru.asgubin.rsr.report.chapter8;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ru.asgubin.rsr.clients.rest.rsrdb.DaoCcfGroup;
import ru.asgubin.rsr.clients.rest.rsrdb.DaoEventDb;
import ru.asgubin.rsr.clients.rest.rsrdb.DaoParamDb;
import ru.asgubin.rsr.clients.rest.rsrdb.model.CcfGroup;
import ru.asgubin.rsr.clients.rest.rsrdb.model.Event;
import ru.asgubin.rsr.clients.rest.rsrdb.model.Param;
import ru.asgubin.rsr.report.factory.BasicEvent;
import ru.asgubin.rsr.report.factory.TableRowFactory;
import ru.asgubin.rsr.report.types.CcfModelType;
import ru.asgubin.rsr.report.types.EventType;
import ru.asgubin.rsr.rsrresult.IOException_Exception;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class DaoChapter_8 {
    private static final Logger LOG = LoggerFactory.getLogger(DaoChapter_8.class);

    private DaoChapter_8() {
    }

    private static class SingletonHelper {
        private static final DaoChapter_8 INSTANCE = new DaoChapter_8();
    }

    public static DaoChapter_8 getInstance() {
        return DaoChapter_8.SingletonHelper.INSTANCE;
    }

    public Chapter_8 getChapter_8(List<Event> eventList, String rsrDbName)
            throws IOException {

        return new Chapter_8(getChapter_8_1(eventList, rsrDbName), getChapter_8_2(rsrDbName));
    }

    private Chapter_8_1 getChapter_8_1(List<Event> eventList, String rsrDbName)
            throws IOException {

        List<TableRow_8_1_1> table_8_1_1 = new ArrayList<>();
        for (Event event : eventList) {

            BasicEvent basicEvent = TableRowFactory.getInstance().getTableRow(rsrDbName, event);

            if (basicEvent instanceof TableRow_8_1_1) {
                table_8_1_1.add((TableRow_8_1_1)basicEvent);
            }
        }

        return new Chapter_8_1(table_8_1_1);
    }

    private Chapter_8_2 getChapter_8_2(String rsrDbName) throws IOException {

        List<CcfGroup> ccfGroupList = DaoCcfGroup.getInstance().getAll(rsrDbName);

        List<TableRow_8_2_1> table_8_2_1 = new ArrayList<>();
        for (CcfGroup ccfGroup : ccfGroupList) {

            table_8_2_1.add(getTableRow_8_2_1(
                    ccfGroup.getId(),
                    DaoEventDb.getInstance().getCcfEventsByCcfGroupId(rsrDbName, ccfGroup.getNum()),
                    ccfGroup.getText(),
                    ccfGroup.getCcfModel(),
                    DaoParamDb.getInstance().getCcfParamsByCcfGroupId(rsrDbName, ccfGroup.getNum())));
        }

        return new Chapter_8_2(table_8_2_1);
    }

    private TableRow_8_2_1 getTableRow_8_2_1(String id, List<Event> events, String text,
                                             int ccfModel, List<Param> params) {
        String ccfModelType;
        if (ccfModel == CcfModelType.BETA.getValue()) {
            ccfModelType = "Бетта-фактор";
        }
        else if (ccfModel == CcfModelType.MGL.getValue()) {
            ccfModelType = "МГЛ";
        }
        else if (ccfModel == CcfModelType.ALPHA_4.getValue()) {
            ccfModelType = "Альфа-фактор";
        }
        else if (ccfModel == CcfModelType.ALPHA_4_STAGGERED.getValue()) {
            ccfModelType = "Альфа-фактор";
        }
        else if (ccfModel == CcfModelType.ALPHA_8.getValue()) {
            ccfModelType = "Альфа-фактор 8";
        }
        else if (ccfModel == CcfModelType.ALPHA_8_STAGGERED.getValue()) {
            ccfModelType = "Альфа-фактор 8";
        }
        else {
            ccfModelType = "-";
        }

        return new TableRow_8_2_1(id, events, text, ccfModelType, params);
    }
}

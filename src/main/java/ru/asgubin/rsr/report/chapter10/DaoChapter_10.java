package ru.asgubin.rsr.report.chapter10;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ru.asgubin.rsr.clients.rest.rsrdb.DaoCcfGroup;
import ru.asgubin.rsr.clients.rest.rsrdb.DaoEventDb;
import ru.asgubin.rsr.clients.rest.rsrdb.DaoParamDb;
import ru.asgubin.rsr.clients.rest.rsrdb.model.CcfGroup;
import ru.asgubin.rsr.clients.rest.rsrdb.model.Event;
import ru.asgubin.rsr.clients.rest.rsrdb.model.Param;
import ru.asgubin.rsr.clients.soap.rsrresult.DaoEventResult;
import ru.asgubin.rsr.report.types.ParamType;
import ru.asgubin.rsr.rsrresult.IOException_Exception;

import java.io.IOException;
import java.util.*;

public class DaoChapter_10 {
    private static final Logger LOG = LoggerFactory.getLogger(DaoChapter_10.class);

    private static final String TARGET = "/";
    private static final String REPLACEMENT = "%@*";

    private DaoChapter_10() {
    }

    private static class SingletonHelper {
        private static final DaoChapter_10 INSTANCE = new DaoChapter_10();
    }

    public static DaoChapter_10 getInstance() {
        return DaoChapter_10.SingletonHelper.INSTANCE;
    }

    public Chapter_10 getChapter_10(List<String> rsrResultFiles, String rsrDbName)
            throws IOException, IOException_Exception {

        // 1. Add Params from CCF
        List<CcfGroup> ccfGroupList = DaoCcfGroup.getInstance().getAll(rsrDbName);

        Set<Param> paramSet = new HashSet<>();
        for (CcfGroup ccfGroup : ccfGroupList) {
            paramSet.addAll(DaoParamDb
                    .getInstance()
                    .getCcfParamsByCcfGroupId(rsrDbName, ccfGroup.getNum()));
        }

        // 2. Add params from Events
        // 2.1 Get all unique Events.Num from RSR files
        Set<Long> eventNumListFromRsrFile = new HashSet<>();
        for (String file : rsrResultFiles) {
            eventNumListFromRsrFile.addAll(DaoEventResult.getInstance().getEventResult(file));
        }

        // 2.2 Get all Events.Num from RS model by Events.Num from RSR file
        List<Integer> eventNumListFromRsModel = new ArrayList<>();
        for (Long eventNum : eventNumListFromRsrFile) {

            // 2.2.1 Get Event.ID by Event.Num;
            //       And replace in Event.ID symbol '/' for correct URL request
            String eventId = DaoEventDb.getInstance()
                    .getEvent(rsrDbName, eventNum.intValue())
                    .getId()
                    .replace(TARGET, REPLACEMENT);

            // 2.2.2 Get List Event.Num from RS model WHERE Event.type == 5
            for (Event event : DaoEventDb.getInstance().getEventsByEventId(rsrDbName, eventId)) {
                if (event.getType() == 5) {
                    eventNumListFromRsModel.add(event.getNum());
                }
            }
        }
        
        // 2.2 Add params from List Event to paramSet WHERE Param.type != 18 and 20
        for (Integer eventNum : eventNumListFromRsModel) {
            for (Param param : DaoParamDb.getInstance().getParamsByEventNum(rsrDbName, eventNum)) {
                if (param.getType() != ParamType.TEST_INTERVAL.getValue() &&
                    param.getType() != ParamType.MISSION_TIME.getValue()) {
                    paramSet.add(param);
                }
            }
        }

        List<TableRow_10_1> table_10_1 = new ArrayList<>();
        for (Param param : paramSet) {
            table_10_1.add(getTableRaw_10_1(param));
        }

        return new Chapter_10(table_10_1);
    }

    private TableRow_10_1 getTableRaw_10_1(Param param) {
        return new TableRow_10_1(param);
    }
}

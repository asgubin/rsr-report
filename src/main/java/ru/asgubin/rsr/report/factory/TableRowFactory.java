package ru.asgubin.rsr.report.factory;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ru.asgubin.rsr.clients.rest.rsrdb.DaoEventDb;
import ru.asgubin.rsr.clients.rest.rsrdb.DaoParamDb;
import ru.asgubin.rsr.clients.rest.rsrdb.model.Event;
import ru.asgubin.rsr.clients.rest.rsrfmea.DaoEquipment;
import ru.asgubin.rsr.clients.rest.rsrfmea.DaoEquipmentGroup;
import ru.asgubin.rsr.clients.soap.rsrresult.DaoEventResult;
import ru.asgubin.rsr.report.chapter6.BasicEvent_6_1_1;
import ru.asgubin.rsr.report.chapter6.TableRow_6_2_1;
import ru.asgubin.rsr.report.chapter7.TableRow_7_1_1;
import ru.asgubin.rsr.report.chapter7.TableRow_7_2_1;
import ru.asgubin.rsr.report.chapter8.TableRow_8_1_1;
import ru.asgubin.rsr.report.types.EventSuffixType;
import ru.asgubin.rsr.report.types.EventType;
import ru.asgubin.rsr.rsrresult.IOException_Exception;

import java.io.IOException;
import java.util.*;

public class TableRowFactory {

    private static final Logger LOG = LoggerFactory.getLogger(TableRowFactory.class);

    private static final String TARGET = "/";
    private static final String REPLACEMENT = "%@*";

    private TableRowFactory() {
    }

    private static class SingletonHelper {
        private static final TableRowFactory INSTANCE = new TableRowFactory();
    }

    public static TableRowFactory getInstance() {
        return TableRowFactory.SingletonHelper.INSTANCE;
    }

    public BasicEvent getTableRow(String rsrDbName, Event event) throws IOException {

        if (event.getId().endsWith(EventSuffixType.ATC.getPostfix()) ||
                event.getId().endsWith(EventSuffixType.U.getPostfix())  ||
                event.getId().endsWith(EventSuffixType.C.getPostfix())  ||
                event.getId().endsWith(EventSuffixType.Q.getPostfix())  ||
                event.getId().endsWith(EventSuffixType.S.getPostfix())  ||
                event.getId().endsWith(EventSuffixType.O.getPostfix())  ||
                event.getId().endsWith(EventSuffixType.V.getPostfix())  ||
                event.getId().endsWith(EventSuffixType.K.getPostfix())  ||
                event.getId().endsWith(EventSuffixType.A.getPostfix())  ||
                event.getId().endsWith(EventSuffixType.H.getPostfix())  ||
                event.getId().endsWith(EventSuffixType.R.getPostfix())  ||
                event.getId().endsWith(EventSuffixType.E.getPostfix())  ||
                event.getId().endsWith(EventSuffixType.L.getPostfix())  ||

                event.getId().endsWith(EventSuffixType.F1.getPostfix()) ||
                event.getId().endsWith(EventSuffixType.F2.getPostfix()) ||
                event.getId().endsWith(EventSuffixType.F3.getPostfix())
        ) {

            try {
                int eqGroup = DaoEquipmentGroup.getInstance()
                        .getByEventId(event.getId().replace(TARGET, REPLACEMENT))
                        .getId();
                String eqKks = DaoEquipment.getInstance()
                        .getByEventId(event.getId().replace(TARGET, REPLACEMENT))
                        .getKks();

                return new BasicEvent_6_1_1(
                        event,
                        DaoParamDb.getInstance().getParamsByEventNum(rsrDbName, event.getNum()),
                        eqGroup,
                        eqKks,
                        EventSuffixType.ATC.getPostfix());
            } catch (IOException e) {
                LOG.warn("WAR!! " + e.getMessage());
                return new BeException();
            }
        }
        else if (event.getId().endsWith(EventSuffixType.M.getPostfix())) {

            return new TableRow_6_2_1(event,
                    DaoParamDb.getInstance().getParamsByEventNum(rsrDbName, event.getNum()));
        }
        else if (event.getId().endsWith(EventSuffixType.HE.getPostfix())) {

            return new TableRow_7_1_1(event,
                    DaoParamDb.getInstance().getParamsByEventNum(rsrDbName, event.getNum()));
        }
        else if (event.getId().endsWith(EventSuffixType.HUM.getPostfix())) {

            return new TableRow_7_2_1(event,
                    DaoParamDb.getInstance().getParamsByEventNum(rsrDbName, event.getNum()));
        }

        else {
            return new TableRow_8_1_1(event,
                    DaoParamDb.getInstance().getParamsByEventNum(rsrDbName, event.getNum()));
        }
    }

    public List<Event> getEventList(List<String> rsrResultFiles, String dbName)
            throws IOException_Exception, IOException {

        Set<Long> eventIdList = new HashSet<>();
        for (String file : rsrResultFiles) {
            eventIdList.addAll(DaoEventResult.getInstance().getEventResult(file));
        }

        System.out.println(Arrays.toString(eventIdList.toArray()));

        List<Event> eventList = new ArrayList<>();
        for (Long eventNum : eventIdList) {
            Event event = DaoEventDb.getInstance().getEvent(dbName, eventNum.intValue());

            if (event.getType() == EventType.BASIC_EVENTS.getValue()) {
                eventList.add(event);
            }
            else {
                for (Event item : DaoEventDb.getInstance()
                        .getEventsByEventId(dbName, event.getId().replace(TARGET, REPLACEMENT))) {

                    if (item.getType() == EventType.BASIC_EVENTS.getValue()) {
                        eventList.add(item);
                    }
                }
            }
        }

        return eventList;
    }
}

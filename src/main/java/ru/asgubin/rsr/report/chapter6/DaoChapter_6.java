package ru.asgubin.rsr.report.chapter6;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ru.asgubin.rsr.clients.rest.rsrdb.model.Event;
import ru.asgubin.rsr.clients.rest.rsrfmea.DaoEquipmentGroup;
import ru.asgubin.rsr.report.chapter6.pojo.*;
import ru.asgubin.rsr.report.factory.BasicEvent;
import ru.asgubin.rsr.report.factory.TableRowFactory;

import java.io.IOException;
import java.util.*;
import java.util.stream.Collectors;

public class DaoChapter_6 {
    private static final Logger LOG = LoggerFactory.getLogger(DaoChapter_6.class);

    private DaoChapter_6() {
    }

    private static class SingletonHelper {
        private static final DaoChapter_6 INSTANCE = new DaoChapter_6();
    }

    public static DaoChapter_6 getInstance() {
        return DaoChapter_6.SingletonHelper.INSTANCE;
    }

    public Chapter_6 getChapter_6(List<Event> eventList, String rsrDbName)
            throws IOException {

        return new Chapter_6(getChapter_6_1(eventList, rsrDbName), getChapter_6_2(eventList, rsrDbName));
//        return new Chapter_6(getChapter_6_2(rsrDbName));
    }

    private Chapter_6_1 getChapter_6_1(List<Event> eventList, String rsrDbName)
            throws IOException {

        List<BasicEvent_6_1_1> basicEvent_6_1_1s = new ArrayList<>();
        for (Event event : eventList) {

            BasicEvent basicEvent = TableRowFactory.getInstance().getTableRow(rsrDbName, event);

            if (basicEvent instanceof BasicEvent_6_1_1) {
                basicEvent_6_1_1s.add((BasicEvent_6_1_1) basicEvent);
            }
        }

        Map<Integer, List<BasicEvent_6_1_1>> groupIdMap =
                basicEvent_6_1_1s.stream()
                        .collect(Collectors.groupingBy(BasicEvent_6_1_1::getEqGroupId));

        List<TableRow_6_1_1> table_6_1_1 = new ArrayList<>();

        int num = 1;
        for (Map.Entry<Integer, List<BasicEvent_6_1_1>> entryGroupId : groupIdMap.entrySet()) {

            Map<String, List<BasicEvent_6_1_1>> modelTypeMap =
                    entryGroupId.getValue().stream()
                            .collect(Collectors.groupingBy(BasicEvent_6_1_1::getEventModel));

            int count = 1;
            for (Map.Entry<String, List<BasicEvent_6_1_1>> entry : modelTypeMap.entrySet()) {

                table_6_1_1.add(getTableRow_6_1_1(
                        num + "." + count,
                        entryGroupId.getKey(),
                        entry.getValue()));

                count++;
            }

            num++;
        }

        return new Chapter_6_1(table_6_1_1);
    }

    private Chapter_6_2 getChapter_6_2(List<Event> eventList, String rsrDbName)
            throws IOException {

        List<TableRow_6_2_1> table_6_2_1 = new ArrayList<>();
        for (Event event : eventList) {

            BasicEvent basicEvent = TableRowFactory.getInstance().getTableRow(rsrDbName, event);

            if (basicEvent instanceof TableRow_6_2_1) {
                table_6_2_1.add((TableRow_6_2_1)basicEvent);
            }
        }

        return new Chapter_6_2(table_6_2_1);
    }

    private TableRow_6_1_1 getTableRow_6_1_1(String number, int eqGroupId, List<BasicEvent_6_1_1> eventList)
            throws IOException {

        Set<EqKks> eqKKSSet = new HashSet<>();
        Set<EventText> eventTextSet = new HashSet<>();
        Set<EventId> eventIdSet = new HashSet<>();
        Set<EventModel> eventModelSet = new HashSet<>();
        Set<MissionTime> missionTimeSet = new HashSet<>();
        Set<Probability> probabilitySet = new HashSet<>();
        Set<FailureRate> failureRateSet = new HashSet<>();
        Set<TestInterval> testIntervalSet = new HashSet<>();

        for (BasicEvent_6_1_1 event : eventList) {
            eqKKSSet.add(new EqKks(event.getEqKKS()));
            eventTextSet.add(new EventText(event.getText()));
            eventIdSet.add(new EventId(event.getId()));
            eventModelSet.add(new EventModel(event.getEventModel()));
            missionTimeSet.add(new MissionTime(event.getMissionTime()));
            probabilitySet.add(new Probability(event.getProbability()));
            failureRateSet.add(new FailureRate(event.getFailureRate()));
            testIntervalSet.add(new TestInterval(event.getTestInterval()));
        }

        return new TableRow_6_1_1(
                number,
                eqGroupId,
                DaoEquipmentGroup.getInstance().getById(eqGroupId).getTextEng(),
                new ArrayList<>(eqKKSSet),
                new ArrayList<>(eventTextSet),
                new ArrayList<>(eventIdSet),
                new ArrayList<>(eventModelSet),
                new ArrayList<>(missionTimeSet),
                new ArrayList<>(probabilitySet),
                new ArrayList<>(failureRateSet),
                new ArrayList<>(testIntervalSet));
    }
}

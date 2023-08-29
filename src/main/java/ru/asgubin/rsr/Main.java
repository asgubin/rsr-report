package ru.asgubin.rsr;

import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.JAXBException;
import jakarta.xml.bind.Marshaller;
import org.docx4j.Docx4J;
import org.docx4j.model.datastorage.BindingHandler;
import org.docx4j.openpackaging.exceptions.Docx4JException;
import org.docx4j.openpackaging.packages.WordprocessingMLPackage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ru.asgubin.rsr.clients.rest.rsrdb.DaoEventDb;
import ru.asgubin.rsr.clients.rest.rsrdb.model.Event;
import ru.asgubin.rsr.clients.soap.rsrresultdb.DaoMcs;
import ru.asgubin.rsr.report.DocxReport;
import ru.asgubin.rsr.report.chapter10.DaoChapter_10;
import ru.asgubin.rsr.report.chapter12.Chapter_12;
import ru.asgubin.rsr.report.chapter12.Chapter_12_1;
import ru.asgubin.rsr.report.chapter12.DaoChapter_12;
import ru.asgubin.rsr.report.chapter12.TableRow_12_1_1_1;
import ru.asgubin.rsr.report.chapter13.DaoChapter_13;
import ru.asgubin.rsr.report.chapter6.DaoChapter_6;
import ru.asgubin.rsr.report.chapter7.DaoChapter_7;
import ru.asgubin.rsr.report.chapter8.DaoChapter_8;
import ru.asgubin.rsr.report.factory.BasicEvent;
import ru.asgubin.rsr.report.factory.TableRowFactory;
import ru.asgubin.rsr.report.factory.BeException;
import ru.asgubin.rsr.rsrresult.IOException_Exception;
import ru.asgubin.rsr.rsrresultdb.Mcs;
import ru.asgubin.rsr.rsrresultdb.RsrDbException_Exception;
import ru.asgubin.rsr.rsrresultdb.RsrResultFileException_Exception;
import ru.asgubin.rsr.utils.AppProperties;
import ru.asgubin.rsr.utils.BasicFolder;

import java.io.File;
import java.io.IOException;
import java.io.StringWriter;
import java.nio.charset.StandardCharsets;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class Main {

    private static final Logger LOG = LoggerFactory.getLogger(Main.class);

    public static JAXBContext context = org.docx4j.jaxb.Context.jc;

    public static void main(String[] args) {

        LOG.debug("Starting to read data base name");
        String dbName = BasicFolder.getInstance().getDbName();
        LOG.debug("Data base name " + dbName);

        LOG.debug("Starting to get list of rsr result files");
        List<String> rsrResultFiles = BasicFolder.getInstance().getRsrResultFiles();

        LOG.debug("Starting to make report instance");
        DocxReport report = null;
        try {
            List<Event> eventList = TableRowFactory.getInstance().getEventList(rsrResultFiles, dbName);

            report = new DocxReport
                    .ReportBuilder()
                    .withChapter6(DaoChapter_6.getInstance().getChapter_6(eventList, dbName))
                    .withChapter7(DaoChapter_7.getInstance().getChapter_7(eventList, dbName))
                    .withChapter8(DaoChapter_8.getInstance().getChapter_8(eventList, dbName))
                    .withChapter10(DaoChapter_10.getInstance().getChapter_10(rsrResultFiles, dbName))
                    .withChapter12(DaoChapter_12.getInstance().getChapter_12(rsrResultFiles, dbName))
                    .withChapter13(DaoChapter_13.getInstance().getChapter_13(rsrResultFiles, dbName))
                    .build();

            LOG.debug("Report made successful");

        } catch (RsrResultFileException_Exception | IOException | RsrDbException_Exception | IOException_Exception e) {
            e.printStackTrace();
        }

        if (report == null) {
            LOG.debug("Report instance is null");
        }

        try {
            JAXBContext jaxbContext = JAXBContext.newInstance(DocxReport.class);
            Marshaller jaxbMarshaller = jaxbContext.createMarshaller();
            jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
            jaxbMarshaller.setProperty(Marshaller.JAXB_ENCODING, "windows-1251");

            String saveXmlPath = Paths
                    .get(AppProperties.getProperties().getProperty("rsrBasicFile")).getParent().toString()
                    + File.separator
                    + AppProperties.getProperties().getProperty("outFileName")
                    + ".xml";
            jaxbMarshaller.marshal(report, new File(saveXmlPath));

            jaxbMarshaller.setProperty(Marshaller.JAXB_ENCODING, "UTF-8");
            StringWriter xmlStream = new StringWriter();
            jaxbMarshaller.marshal(report, xmlStream);
            Thread makeMainReport = new Thread(() -> {
                try {
                    String templatePath = AppProperties.getProperties().getProperty("templateReportFile");
                    String saveReportPath = Paths
                            .get(AppProperties.getProperties().getProperty("rsrBasicFile")).getParent().toString()
                            + File.separator
                            + AppProperties.getProperties().getProperty("outFileName");
                    makeReport(xmlStream, templatePath, saveReportPath);
                } catch (Docx4JException e) {
                    e.printStackTrace();
                }
            });
            makeMainReport.start();

            boolean makeStage6 = Boolean.parseBoolean(AppProperties.getProperties().getProperty("makeStage6"));
            if(makeStage6 && report != null) {
                for (Chapter_12_1 chapter_12_1 : report.getChapter12().getChapter_12_1s()) {
                    if (chapter_12_1.getChapter_12_1_1().getTable_12_1_1_1().size() > 3) {

                        List<TableRow_12_1_1_1> table_12_1_1_1 =
                                chapter_12_1.getChapter_12_1_1().getTable_12_1_1_1();
                        table_12_1_1_1.clear();
                        table_12_1_1_1.addAll(DaoChapter_12.getTable_12_1_1_1(
                                chapter_12_1.getRsrResultFile(),
                                chapter_12_1.getRsrDbName(),
                                3));
                    }
                }

                StringWriter xmlStage6Stream = new StringWriter();
                jaxbMarshaller.marshal(report, xmlStage6Stream);
                Thread makeStage6Report = new Thread(() -> {
                    try {
                        String templatePath = AppProperties.getProperties().getProperty("templateStage6File");
                        String saveReportPath = Paths
                                .get(AppProperties.getProperties().getProperty("rsrBasicFile")).getParent().toString()
                                + File.separator
                                + AppProperties.getProperties().getProperty("outFileStage6Name");

                        makeReport(xmlStage6Stream, templatePath, saveReportPath);
                    } catch (Docx4JException e) {
                        e.printStackTrace();
                    }
                });
                makeStage6Report.start();
            }
        } catch (JAXBException | RsrResultFileException_Exception | RsrDbException_Exception | IOException e) {
            e.printStackTrace();
        }
    }

    public static void makeReport(StringWriter xmlStream, String templatePath, String savePath)
            throws Docx4JException {

        LOG.debug("Get root path to template.docx" + templatePath);

        WordprocessingMLPackage wordMLPackage = Docx4J.load(new File(templatePath));
        BindingHandler.getHyperlinkResolver().setHyperlinkStyle("Hyperlink");
        Docx4J.bind(wordMLPackage, xmlStream.toString(), Docx4J.FLAG_BIND_INSERT_XML | Docx4J.FLAG_BIND_BIND_XML | Docx4J.FLAG_BIND_REMOVE_SDT);

        LOG.debug("File saved in " + savePath);

        Docx4J.save(wordMLPackage, new File(savePath), Docx4J.FLAG_NONE);
    }
}

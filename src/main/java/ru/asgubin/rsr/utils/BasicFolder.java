package ru.asgubin.rsr.utils;

import org.apache.commons.io.FilenameUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class BasicFolder {

    private static final Logger LOG = LoggerFactory.getLogger(BasicFolder.class);

    private BasicFolder() {
    }

    private static class SingletonHelper {
        private static final BasicFolder INSTANCE = new BasicFolder();
    }

    public static BasicFolder getInstance() {
        return BasicFolder.SingletonHelper.INSTANCE;
    }

    public String getDbName() {

        return getFileName(AppProperties.getProperties().getProperty("rsrBasicFile"));
    }

    public String getFileName(String fileName) {

        return FilenameUtils.removeExtension(Paths
                .get(fileName)
                .getFileName()
                .toString());
    }

    public List<String> getRsrResultFiles() {

        String rsrResultFolder = Paths
                .get(AppProperties.getProperties().getProperty("rsrBasicFile"))
                .getParent().toString() + File.separator + getDbName() + ".RPR";

        List<String> rsrResultFiles = new ArrayList<>();
        try (Stream<Path> walk = Files.walk(Paths.get(rsrResultFolder))) {

            rsrResultFiles = walk.filter(Files::isRegularFile)
                    .map(Object::toString)
                    .filter(str -> str.contains(".RSR"))
                    .collect(Collectors.toList());
        } catch (IOException e) {
            e.printStackTrace();
        }

        return rsrResultFiles;
    }
}

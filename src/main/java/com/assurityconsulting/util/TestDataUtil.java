package com.assurityconsulting.util;

import org.apache.log4j.Logger;

import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class TestDataUtil {
    private static final Logger logger = Logger.getLogger(TestDataUtil.class.getName());

    public static String getTestDataFromPropertyFile(String fileName, String propertyName) {
        String TestData = "";
        try {
            FileReader fileReader = new FileReader(fileName);
            Properties properties = new Properties();
            properties.load(fileReader);
            TestData = properties.getProperty(propertyName);
        } catch (IOException exception) {
            logger.error("Exception occurred while reading the file", exception);
        }
        return TestData;
    }
}

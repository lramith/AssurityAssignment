package com.assurity.util;

import org.apache.log4j.Logger;

import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

/**
 * <h1>Test Data Util Class</h1>
 * This class stores all the test data util methods
 *
 * @author Ramith Wanniarachchi
 */
public class TestDataUtil {
    private static final Logger logger = Logger.getLogger(TestDataUtil.class);

    /**
     * This method is used to get the test data for the given property.
     *
     * @param fileName     file name of the test data file
     * @param propertyName property name of the test data
     * @return value of the requested property
     */
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

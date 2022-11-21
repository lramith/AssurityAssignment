package com.assurity;

import com.assurity.util.TestDataUtil;

/**
 * <h1>Base Test Class</h1>
 * This class stores all the test methods that are common to all the tests
 *
 * @author Ramith Wanniarachchi
 */
public class TestBase {

    private static String testDataFilePath = System.getProperty("user.dir") + "/src/main/resources/testdata/";

    /**
     * This method is used to set the test data file path.
     */
    public static void setTestDataPath(String fileName) {
        testDataFilePath = testDataFilePath + fileName;
    }

    /**
     * This method is used to get each property from the test data file.
     *
     * @param propertyName test data file name
     * @return value of the requested property
     */
    protected static String getTestData(String propertyName) {
        return TestDataUtil.getTestDataFromPropertyFile(testDataFilePath, propertyName);
    }
}

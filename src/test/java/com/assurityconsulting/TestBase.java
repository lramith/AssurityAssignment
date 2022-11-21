package com.assurityconsulting;

import com.assurityconsulting.util.TestDataUtil;

public class TestBase {
    private static String testDataFilePath = System.getProperty("user.dir") + "/src/main/resources/testdata/";

    public static void setTestDataPath(String fileName) {
        testDataFilePath = testDataFilePath + fileName;
    }

    protected static String getTestData(String propertyName) {
        return TestDataUtil.getTestDataFromPropertyFile(testDataFilePath, propertyName);
    }
}

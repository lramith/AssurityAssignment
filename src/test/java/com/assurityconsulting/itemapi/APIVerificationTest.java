package com.assurityconsulting.itemapi;

import com.assurityconsulting.TestBase;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.assurityconsulting.data.Item;
import com.assurityconsulting.data.Promotion;
import com.assurityconsulting.functions.APIDetails;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.util.ArrayList;
import java.util.List;

public class APIVerificationTest extends TestBase {
    private static SoftAssert softAssert;
    private static String itemId;
    private static boolean categoryFlag;
    private static String expectedPromotionName;
    private static String expectedItemName;
    private static boolean expectedCanRelist;
    private static String expectedDescription;

    @BeforeClass
    public static void setup(){
        prepareTestData();
        softAssert = new SoftAssert();
    }

    @Test(description = "Validate correct details are return from the Item API" )
    public static void testAPIDetails() throws JsonProcessingException {
        Item itemDataFromAPI = APIDetails.getDetailsFromItemAPI(itemId, categoryFlag);

        softAssert.assertEquals(itemDataFromAPI.getName(), expectedItemName, "Name returned from the API is not as expected");
        softAssert.assertEquals(itemDataFromAPI.getCanRelist(), expectedCanRelist, "CanRelist returned from the API is not as expected");

        List<String> listOfAvailablePromotions = new ArrayList<>();
        for(Promotion promotion : itemDataFromAPI.getPromotions()) {
            String currentPromotion = promotion.getName();
            listOfAvailablePromotions.add(currentPromotion);
            if (currentPromotion.equals(expectedPromotionName)) {
                softAssert.assertEquals(promotion.getDescription(), expectedDescription, "Description for " + expectedPromotionName + " is not as expected");
                break;
            }
        }

        softAssert.assertTrue(listOfAvailablePromotions.contains(expectedPromotionName), "There is no promotion available called " + expectedPromotionName);
        softAssert.assertAll();
    }

    private static void prepareTestData(){
        TestBase.setTestDataPath("APIVerification.properties");
        itemId = TestBase.getTestData("ItemId");
        categoryFlag = Boolean.getBoolean(TestBase.getTestData("CategoryFlag"));
        expectedPromotionName = TestBase.getTestData("Promotion");
        expectedDescription = TestBase.getTestData("Description");
        expectedItemName = TestBase.getTestData("Name");
        expectedCanRelist = Boolean.parseBoolean(TestBase.getTestData("CanRelist"));
    }
}

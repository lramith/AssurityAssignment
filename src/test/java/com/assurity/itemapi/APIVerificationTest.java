package com.assurity.itemapi;

import com.assurity.TestBase;
import com.assurity.data.Item;
import com.assurity.data.Promotion;
import com.assurity.functions.APIDetails;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.util.ArrayList;
import java.util.List;

public class APIVerificationTest extends TestBase {
    private SoftAssert softAssert;
    private String itemId;
    private boolean categoryFlag;
    private String expectedPromotionName;
    private String expectedItemName;
    private boolean expectedCanRelist;
    private String expectedDescription;

    @BeforeClass
    public void setup() {
        prepareTestData();
        softAssert = new SoftAssert();
    }

    @Test(description = "Validate correct details are return from the Item API")
    public void testAPIDetails() throws JsonProcessingException {
        Item itemDataFromAPI = APIDetails.getDetailsFromItemAPI(itemId, categoryFlag);

        softAssert.assertEquals(itemDataFromAPI.getName(), expectedItemName, "Name returned from the API is not as expected");
        softAssert.assertEquals(itemDataFromAPI.getCanRelist(), expectedCanRelist, "CanRelist returned from the API is not as expected");

        List<String> listOfAvailablePromotions = new ArrayList<>();
        for (Promotion promotion : itemDataFromAPI.getPromotions()) {
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

    private void prepareTestData() {
        TestBase.setTestDataPath("APIVerification.properties");
        itemId = TestBase.getTestData("ItemId");
        categoryFlag = Boolean.getBoolean(TestBase.getTestData("CategoryFlag"));
        expectedPromotionName = TestBase.getTestData("Promotion");
        expectedDescription = TestBase.getTestData("Description");
        expectedItemName = TestBase.getTestData("Name");
        expectedCanRelist = Boolean.parseBoolean(TestBase.getTestData("CanRelist"));
    }
}

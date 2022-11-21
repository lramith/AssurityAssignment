package com.assurity.categoryapi;

import com.assurity.TestBase;
import com.assurity.data.Category;
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
    private String categoryId;
    private boolean categoryFlag;
    private String expectedPromotionName;
    private String expectedCategoryName;
    private boolean expectedCanRelist;
    private String expectedDescription;

    @BeforeClass
    public void setup() {
        prepareTestData();
        softAssert = new SoftAssert();
    }

    @Test(description = "Validate correct details are return from the Category API")
    public void testCategoryAPIDetails() throws JsonProcessingException {
        Category categoryDataFromAPI = APIDetails.getDetailsFromCategoryAPI(categoryId, categoryFlag);

        softAssert.assertEquals(categoryDataFromAPI.getName(), expectedCategoryName, "Name returned from the API is not as expected");
        softAssert.assertEquals(categoryDataFromAPI.getCanRelist(), expectedCanRelist, "CanRelist returned from the API is not as expected");

        List<String> listOfAvailablePromotions = new ArrayList<>();
        for (Promotion promotion : categoryDataFromAPI.getPromotions()) {
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

        categoryId = TestBase.getTestData("CategoryId");
        categoryFlag = Boolean.getBoolean(TestBase.getTestData("CategoryFlag"));
        expectedCategoryName = TestBase.getTestData("Name");
        expectedCanRelist = Boolean.parseBoolean(TestBase.getTestData("CanRelist"));
        expectedPromotionName = TestBase.getTestData("Promotion");
        expectedDescription = TestBase.getTestData("Description");
    }
}

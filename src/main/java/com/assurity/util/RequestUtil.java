package com.assurity.util;

import static com.jayway.restassured.RestAssured.given;

/**
 * <h1>Request Util Class</h1>
 * This class is the util class for all the API requests
 *
 * @author Ramith Wanniarachchi
 */
public class RequestUtil {

    /**
     * This method is used to call the get API for the give url.
     *
     * @param url URL for the request
     * @return String response body
     */
    public static String get(String url) {
        return given().when().get(url).then().statusCode(200).extract().body().asString();
    }
}

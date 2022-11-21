package com.assurityconsulting.util;

import static com.jayway.restassured.RestAssured.given;

public class RequestUtil {

    public static String get(String url) {
        return given().when().get(url).then().statusCode(200).extract().body().asString();
    }
}

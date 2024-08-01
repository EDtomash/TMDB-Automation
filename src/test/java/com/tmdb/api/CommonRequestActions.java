package com.tmdb.api;

import com.tmdb.pojo.RequestToken;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import static com.tmdb.api.SpecBuilder.getRequestSpec;
import static com.tmdb.api.SpecBuilder.getResponseSpec;
import static io.restassured.RestAssured.given;

public class CommonRequestActions {

    @Test
    public static Response getRequest(String path) {
      return  given().spec(getRequestSpec())
                .when()
                .get(path)
                .then()
                .spec(getResponseSpec())
                .extract()
                .response();
    }

    public static Response postRequest(String path, RequestToken token) {
        return  given().spec(getRequestSpec())
                .body(token)
                .when()
                .post(path)
                .then()
                .spec(getResponseSpec())
                .extract()
                .response();
    }
}

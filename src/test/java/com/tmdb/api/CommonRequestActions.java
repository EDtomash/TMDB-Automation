package com.tmdb.api;

import com.tmdb.pojo.movierating.MovieRating;
import com.tmdb.pojo.requesttoken.RequestToken;
import io.restassured.response.Response;

import static com.tmdb.api.SpecBuilder.*;
import static io.restassured.RestAssured.given;

public class CommonRequestActions {

    public static Response getRequest(String path, String sessionId) {
      return  given().spec(getRequestSpec())
              .queryParam("session_id", sessionId)
              .when()
              .get(path)
              .then()
              .spec(getResponseSpec())
              .extract()
              .response();
    }

    public static Response getWithQueryRequest(String path, String sessionId, String queryName, String queryParam) {
        return  given().spec(getRequestSpec())
                .queryParam("session_id", sessionId)
                .queryParam(queryName, queryParam)
                .when()
                .get(path)
                .then()
                .spec(getResponseSpec())
                .extract()
                .response();
    }

    public static Response postRequest(String path, String sessionId, Object movie) {
        return  given().spec(getRequestSpec())
                .queryParam("session_id", sessionId)
                .body(movie)
                .when()
                .post(path)
                .then()
                .spec(getResponseSpec())
                .extract()
                .response();
    }

    public static Response getTokenRequest(String path) {
        return  given().spec(getTokenRequestSpec())
                .when()
                .get(path)
                .then()
                .spec(getTokenResponseSpec())
                .extract()
                .response();
    }

    public static Response postTokenRequest(String path, RequestToken token) {
        return  given().spec(getTokenRequestSpec())
                .body(token)
                .when()
                .post(path)
                .then()
                .spec(getTokenResponseSpec())
                .extract()
                .response();
    }

    public static Response deleteRequest(String path, String sessionId) {
        return  given().spec(getRequestSpec())
                .queryParam("session_id", sessionId)
                .when()
                .delete(path)
                .then()
                .spec(getResponseSpec())
                .extract()
                .response();
    }
}

package com.tmdb.api;

import com.tmdb.utils.ConfigLoader;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.filter.log.LogDetail;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

import static com.tmdb.api.Routes.*;

public class SpecBuilder {

    public static RequestSpecification getRequestSpec() {
        return new RequestSpecBuilder()
                .setBaseUri(TMDB_BASE_URL)
                .setBasePath(BASE_PATH)
                .addHeader("Authorization", "Bearer " + ConfigLoader.getInstance().getBearerToken())
                .addHeader("Accept", "application/json")
                .setContentType(ContentType.JSON)
                .log(LogDetail.ALL)
                .build();
    }

    public static ResponseSpecification getResponseSpec() {
        return new ResponseSpecBuilder()
                .log(LogDetail.ALL)
                .build();
    }

    public static RequestSpecification getTokenRequestSpec() {
        return new RequestSpecBuilder()
                .setBaseUri(TMDB_BASE_URL)
                .setBasePath(BASE_PATH)
                .addHeader("Authorization", "Bearer " + ConfigLoader.getInstance().getBearerToken())
                .addHeader("Accept", "application/json")
                .setContentType(ContentType.JSON)
                .build();
    }

    public static ResponseSpecification getTokenResponseSpec() {
        return new ResponseSpecBuilder()
                .build();
    }
}

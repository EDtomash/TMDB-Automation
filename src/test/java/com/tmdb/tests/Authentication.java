package com.tmdb.tests;

import com.tmdb.utils.ConfigLoader;
import org.testng.annotations.Test;

import static com.tmdb.api.Routes.*;
import static io.restassured.RestAssured.given;

public class Authentication {
    static String requestToken;

    @Test
    public void validateApiKey() {
        given()
                .baseUri(TMDB_BASE_URL)
                .basePath(BASE_PATH)
                .queryParam("api_key", ConfigLoader.getInstance().getBearerToken())
                .log().all()
                .when()
                .get(AUTHENTICATION)
                .then()
                .log().all();
    }
}

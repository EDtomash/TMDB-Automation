package com.tmdb.api;

import com.tmdb.utils.ConfigLoader;
import com.tmdb.utils.DataLoader;
import com.tmdb.webelements.LoginAndAuthenticationUi;

import static com.codeborne.selenide.Selenide.closeWebDriver;
import static com.codeborne.selenide.Selenide.open;
import static com.tmdb.api.Routes.*;
import static com.tmdb.api.Routes.TOKEN;
import static io.restassured.RestAssured.given;

public class TokenManager {

    public void loginAndApprovePermission() {
        open(TMDB_BASE_URL + AUTHENTICATE + "/" + getRequestToken());

        new LoginAndAuthenticationUi()
                .clickLoginButton()
                .enterUsername(DataLoader.getInstance().getUserLogin())
                .enterPassword(DataLoader.getInstance().getUserLogin())
                .submitLoginForm()
                .clickApproveButton()
                .verifyAuthenticationGranted();

        closeWebDriver();
    }

    public String getRequestToken() {
        return given()
                .baseUri(TMDB_API_URL)
                .basePath(BASE_PATH)
                .queryParam("api_key", ConfigLoader.getInstance().getApiKey())
                .log().all()
                .when()
                .get(AUTHENTICATION + TOKEN + "/new")
                .then()
                .log().all()
                .extract()
                .response().path("request_token").toString();
    }
}

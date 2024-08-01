package com.tmdb.api;

import com.codeborne.selenide.Configuration;
import com.tmdb.pojo.requesttoken.RequestToken;
import com.tmdb.utils.DataLoader;
import com.tmdb.webelements.LoginAndAuthenticationUi;
import io.restassured.response.Response;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

import static com.codeborne.selenide.Selenide.closeWebDriver;
import static com.codeborne.selenide.Selenide.open;
import static com.tmdb.api.CommonRequestActions.*;
import static com.tmdb.api.Routes.*;
import static com.tmdb.api.Routes.TOKEN;

public class TokenManager {
    private static String requestToken;
    private static String sessionId;
    private static LocalDateTime tokenAcquiredTime;
    private static final long TOKEN_LIFETIME_MINUTES = 60;

    public static String getSessionId() {
        if (sessionId == null || isTokenExpired()) {
            loginAndApprovePermission();
            sessionId = fetchNewSessionId();
        }
        return sessionId;
    }

    private static String fetchNewSessionId() {
        Response response = postTokenRequest(AUTHENTICATION + "/session/new", buildRequestToken());
        return response.path("session_id");
    }

    private static String getRequestToken() {
        if (requestToken == null || isTokenExpired()) {
            requestToken = fetchNewRequestToken();
            tokenAcquiredTime = LocalDateTime.now();
        }
        return  requestToken;
    }

    private static String fetchNewRequestToken() {
        Response response = getTokenRequest(AUTHENTICATION + TOKEN + "/new");
        return response.path("request_token");
    }

    private static boolean isTokenExpired() {
        return  tokenAcquiredTime == null ||
                ChronoUnit.MINUTES.between(tokenAcquiredTime, LocalDateTime.now()) >= TOKEN_LIFETIME_MINUTES;
    }

    private static void loginAndApprovePermission() {
        Configuration.headless = true;
        open(TMDB_REQUEST_TOKEN + AUTHENTICATE + "/" + getRequestToken());
        new LoginAndAuthenticationUi()
                .performLogin(DataLoader.getInstance().getUserLogin(),
                        DataLoader.getInstance().getUserPassword());
        closeWebDriver();
    }

    private static RequestToken buildRequestToken() {
        return RequestToken.builder()
                .request_token(requestToken)
                .build();
    }
}
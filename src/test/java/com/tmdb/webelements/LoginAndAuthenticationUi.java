package com.tmdb.webelements;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;

public class LoginAndAuthenticationUi {
    public static final SelenideElement LOGIN_BUTTON = $x("//div[@class='button']/a[@href='/login']");
    public static final SelenideElement USERNAME_FIELD = $(By.id("username"));
    public static final SelenideElement PASSWORD_FIELD = $(By.id("password"));
    public static final SelenideElement SUBMIT_BTN = $(By.id("login_button"));
    public static final SelenideElement APPROVE_BTN = $(By.id("allow_authentication"));
    public static final SelenideElement AUTHENTICATION_GRANTED_MESSAGE = $x("//h2[@class='title']");

    public LoginAndAuthenticationUi clickLoginButton() {
        LOGIN_BUTTON.shouldBe(visible).click();
        return this;
    }

    public LoginAndAuthenticationUi enterUsername(String userName) {
        USERNAME_FIELD.shouldBe(visible).sendKeys(userName);
        return this;
    }

    public LoginAndAuthenticationUi enterPassword(String userPassword) {
        PASSWORD_FIELD.shouldBe(visible).sendKeys(userPassword);
        return this;
    }

    public LoginAndAuthenticationUi submitLoginForm() {
        SUBMIT_BTN.shouldBe(visible).submit();
        return this;
    }

    public LoginAndAuthenticationUi clickApproveButton() {
        APPROVE_BTN.shouldBe(visible).click();
        return this;
    }

    public void verifyAuthenticationGranted() {
        AUTHENTICATION_GRANTED_MESSAGE.shouldBe(visible).shouldHave(text("Authentication Granted"));
    }
}

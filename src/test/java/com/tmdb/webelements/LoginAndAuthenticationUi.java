package com.tmdb.webelements;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;

public class LoginAndAuthenticationUi {
    private static final SelenideElement LOGIN_BUTTON = $x("//div[@class='button']/a[@href='/login']");
    private static final SelenideElement USERNAME_FIELD = $(By.id("username"));
    private static final SelenideElement PASSWORD_FIELD = $(By.id("password"));
    private static final SelenideElement SUBMIT_BTN = $(By.id("login_button"));
    private static final SelenideElement APPROVE_BTN = $(By.id("allow_authentication"));
    private static final SelenideElement AUTHENTICATION_GRANTED_MESSAGE = $x("//h2[@class='title']");

    public LoginAndAuthenticationUi performLogin(String userName, String userPassword) {
        clickLoginButton();
        enterUsername(userName);
        enterPassword(userPassword);
        submitLoginForm();
        clickApproveButton();
        verifyAuthenticationGranted();
        return this;
    }

    private LoginAndAuthenticationUi clickLoginButton() {
        LOGIN_BUTTON.shouldBe(visible).click();
        return this;
    }

    private LoginAndAuthenticationUi enterUsername(String userName) {
        USERNAME_FIELD.shouldBe(visible).sendKeys(userName);
        return this;
    }

    private LoginAndAuthenticationUi enterPassword(String userPassword) {
        PASSWORD_FIELD.shouldBe(visible).sendKeys(userPassword);
        return this;
    }

    private LoginAndAuthenticationUi submitLoginForm() {
        SUBMIT_BTN.shouldBe(visible).submit();
        return this;
    }

    private LoginAndAuthenticationUi clickApproveButton() {
        APPROVE_BTN.shouldBe(visible).click();
        return this;
    }

    private void verifyAuthenticationGranted() {
        AUTHENTICATION_GRANTED_MESSAGE.shouldBe(visible).shouldHave(text("Authentication Granted"));
    }
}

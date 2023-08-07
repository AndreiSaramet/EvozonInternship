package com.evozon.steps;


import net.thucydides.core.annotations.Step;
import org.junit.Assert;

public class LoginSteps extends BaseSteps {
    @Step
    public void navigateToLoginPage() {
        this.homePage.clickAccountLink();
        this.homePage.clickLoginLink();
    }

    @Step
    public void enterEmailAddress(final String email) {
        this.loginPage.setEmailInput(email);
    }

    @Step
    public void enterPassword(final String password) {
        this.loginPage.setPasswordInput(password);
    }

    @Step
    public void clickLogin() {
        this.loginPage.clickLoginButton();
    }

    @Step
    public void verifyUserIsLoggedIn(final String username) {
        Assert.assertEquals(username, this.accountPage.getWelcomeTextUsername());
    }

    @Step
    public void doLogin(final String email, final String password) {
        this.navigateToLoginPage();
        this.enterEmailAddress(email);
        this.enterPassword(password);
        this.clickLogin();
    }
}

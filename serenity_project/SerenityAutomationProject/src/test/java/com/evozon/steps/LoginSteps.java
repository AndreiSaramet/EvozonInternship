package com.evozon.steps;

import com.evozon.pages.AccountPage;
import com.evozon.pages.LoginPage;
import net.thucydides.core.annotations.Step;
import org.junit.Assert;

public class LoginSteps extends BaseSteps {
    private LoginPage loginPage;
    private AccountPage accountPage;

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
}

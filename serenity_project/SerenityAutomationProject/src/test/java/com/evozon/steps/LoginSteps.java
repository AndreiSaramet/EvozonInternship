package com.evozon.steps;

import com.evozon.pages.AccountPage;
import com.evozon.pages.HomePage;
import com.evozon.pages.LoginPage;
import net.thucydides.core.annotations.Step;
import net.thucydides.core.steps.ScenarioSteps;
import org.junit.Assert;

public class LoginSteps extends ScenarioSteps {

    private HomePage homePage;
    private LoginPage loginPage;
    private AccountPage accountPage;

    @Step
    public void navigateToHomepage() {
        this.homePage.open();
    }

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

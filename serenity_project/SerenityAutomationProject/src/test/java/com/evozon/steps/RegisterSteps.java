package com.evozon.steps;

import net.thucydides.core.annotations.Step;
import org.hamcrest.Matchers;
import org.junit.Assert;

public class RegisterSteps extends BaseSteps {
    @Step
    public void navigateToRegisterPage() {
        this.homePage.clickAccountLink();
        this.homePage.clickRegisterLink();
    }

    @Step
    public void enterFirstName(final String firstName) {
        this.registerPage.setFirstNameInput(firstName);
    }

    @Step
    public void enterMiddleName(final String middleName) {
        this.registerPage.setMiddleNameInput(middleName);
    }

    @Step
    public void enterLastName(final String lastName) {
        this.registerPage.setLastNameInput(lastName);
    }

    @Step
    public void enterEmailAddress(final String email) {
        this.registerPage.setEmailInput(email);
    }

    @Step
    public void enterPassword(final String password) {
        this.registerPage.setPasswordInput(password);
    }

    @Step
    public void enterConfirmPassword(final String password) {
        this.registerPage.setConfirmPasswordInput(password);
    }

    @Step
    public void signUpForNewsletter() {
        this.registerPage.setSignUpNewsletterCheckbox();
    }

    @Step
    public void clickRegister() {
        this.registerPage.clickRegisterButton();
    }

    @Step
    public void verifyUserIsRegistered(final String username) {
        Assert.assertThat(this.headerPage.getWelcomeTextUsername(), Matchers.equalToIgnoringCase(username));
    }
}

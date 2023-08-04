package com.evozon.test;

import com.github.javafaker.Faker;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class RegisterTest extends BaseTest {
    @Before
    public void beforeEach() {
        this.homepage.clickAccountLink();
        this.homepage.clickRegisterLink();
    }

    @Test
    public void validRegisterTest() {
        final Faker faker = new Faker();
        final String firstName = faker.name().firstName();
        final String middleName = faker.name().nameWithMiddle();
        final String lastName = faker.name().lastName();
        final String email = faker.internet().emailAddress();
        final String password = faker.internet().password(6, 20);

        this.registerPage.setFirstNameInput(firstName);
        this.registerPage.setMiddleNameInput(middleName);
        this.registerPage.setLastNameInput(lastName);
        this.registerPage.setEmailInput(email);
        this.registerPage.setPasswordInput(password);
        this.registerPage.setConfirmPasswordInput(password);
        this.registerPage.setSignUpNewsletterCheckbox();
        this.registerPage.clickRegisterButton();

        Assert.assertEquals(String.format("Welcome, %s %s %s!", firstName, middleName, lastName).toUpperCase(), this.headerPage.getWelcomeText());
    }
}
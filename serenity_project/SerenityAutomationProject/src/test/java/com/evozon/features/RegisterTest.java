package com.evozon.features;

import com.github.javafaker.Faker;
import net.serenitybdd.junit.runners.SerenityRunner;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(SerenityRunner.class)
public class RegisterTest extends BaseTest {
    @Test
    public void validRegisterTest() {
        final Faker faker = new Faker();
        final String firstName = faker.name().firstName();
        final String middleName = faker.name().nameWithMiddle();
        final String lastName = faker.name().lastName();
        final String password = faker.internet().password(6, 20);
        this.registerSteps.navigateToRegisterPage();
        this.registerSteps.enterFirstName(firstName);
        this.registerSteps.enterMiddleName(middleName);
        this.registerSteps.enterLastName(lastName);
        this.registerSteps.enterEmailAddress(faker.internet().emailAddress());
        this.registerSteps.enterPassword(password);
        this.registerSteps.enterConfirmPassword(password);
        this.registerSteps.signUpForNewsletter();
        this.registerSteps.clickRegister();
        this.registerSteps.verifyUserIsRegistered(String.format("%s %s %s", firstName, middleName, lastName));
    }
}

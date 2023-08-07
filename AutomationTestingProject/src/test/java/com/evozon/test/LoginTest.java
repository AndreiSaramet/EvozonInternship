package com.evozon.test;

import com.evozon.utils.Constants;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class LoginTest extends BaseApplicationTest {

    @Before
    public void beforeEach() {
        this.homepage.clickAccountLink();
        this.homepage.clickLoginLink();
    }

    @Test
    public void validLoginTest() {
        this.loginPage.setEmailInput(Constants.USER_EMAIL);
        this.loginPage.setPasswordInput(Constants.USER_PASSWORD);
        this.loginPage.clickLoginButton();

        Assert.assertEquals(String.format("Hello, %s!", Constants.USER_NAME), this.accountPage.getWelcomeText());
    }
}

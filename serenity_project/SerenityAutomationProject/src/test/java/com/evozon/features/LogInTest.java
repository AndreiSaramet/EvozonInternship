package com.evozon.features;

import com.evozon.utils.Constants;
import net.serenitybdd.junit.runners.SerenityRunner;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(SerenityRunner.class)
public class LogInTest extends BaseTest {
    @Test
    public void validLoginTest() {
        this.loginSteps.navigateToLoginPage();
        this.loginSteps.enterEmailAddress(Constants.USER_EMAIL);
        this.loginSteps.enterPassword(Constants.USER_PASSWORD);
        this.loginSteps.clickLogin();
        this.loginSteps.verifyUserIsLoggedIn(Constants.USER_NAME);
    }
}

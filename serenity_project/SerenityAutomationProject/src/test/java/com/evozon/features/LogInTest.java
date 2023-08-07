package com.evozon.features;

import com.evozon.steps.LoginSteps;
import com.evozon.utils.Constants;
import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Steps;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(SerenityRunner.class)
public class LogInTest extends BaseTest {

    @Steps
    private LoginSteps loginSteps;

    @Test
    public void validLoginTest() {
        this.loginSteps.navigateToHomepage();
        this.loginSteps.navigateToLoginPage();
        this.loginSteps.enterEmailAddress(Constants.USER_EMAIL);
        this.loginSteps.enterPassword(Constants.USER_PASSWORD);
        this.loginSteps.clickLogin();
        this.loginSteps.verifyUserIsLoggedIn(Constants.USER_NAME);
    }
}

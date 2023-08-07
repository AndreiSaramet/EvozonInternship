package com.evozon.features;


import com.evozon.steps.CartSteps;
import com.evozon.steps.LoginSteps;
import com.evozon.steps.RegisterSteps;
import com.evozon.utils.Constants;
import net.thucydides.core.annotations.Managed;
import net.thucydides.core.annotations.Steps;
import org.junit.Before;
import org.openqa.selenium.WebDriver;

public class BaseTest {
    @Steps
    protected CartSteps cartSteps;
    @Steps
    protected LoginSteps loginSteps;
    @Steps
    protected RegisterSteps registerSteps;
    @Managed(uniqueSession = true)
    protected WebDriver driver;

    @Before
    public void init() {
        this.driver.manage().window().maximize();
        this.driver.get(Constants.BASE_URL);
    }
}

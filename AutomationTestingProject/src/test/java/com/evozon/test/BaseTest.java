package com.evozon.test;

import com.evozon.pages.AccountPage;
import com.evozon.pages.Homepage;
import com.evozon.pages.LoginPage;
import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class BaseTest {
    protected WebDriver driver;
    protected Homepage homepage;
    protected LoginPage loginPage;
    protected AccountPage accountPage;

    @Before
    public void initDriver() {
        System.setProperty("webdriver.chrome.driver", "resources/chromedriver");
        this.driver = new ChromeDriver();
        this.driver.manage().window().maximize();
        this.homepage = new Homepage(driver);
        this.loginPage = new LoginPage(driver);
        this.accountPage = new AccountPage(driver);
        this.homepage.open();
    }

    @After
    public void closeDriver() {
        this.driver.close();
    }
}

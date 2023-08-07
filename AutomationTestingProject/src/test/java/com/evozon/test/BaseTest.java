package com.evozon.test;

import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public abstract class BaseTest {
    protected WebDriver driver;

    @Before
    public void initDriver() {
        System.setProperty("webdriver.chrome.driver", "resources/chromedriver");
        this.driver = new ChromeDriver();
        this.driver.manage().window().maximize();
    }

    @After
    public void closeDriver() {
        this.driver.close();
    }
}

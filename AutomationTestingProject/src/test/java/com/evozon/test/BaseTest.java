package com.evozon.test;

import com.evozon.pages.*;
import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public abstract class BaseTest {
    protected WebDriver driver;
    protected Homepage homepage;
    protected LoginPage loginPage;
    protected RegisterPage registerPage;
    protected AccountPage accountPage;
    protected HeaderPage headerPage;
    protected ProductsGridPage productsGridPage;
    protected WishlistPage wishlistPage;

    @Before
    public void initDriver() {
        System.setProperty("webdriver.chrome.driver", "resources/chromedriver");
        this.driver = new ChromeDriver();
        this.driver.manage().window().maximize();
        this.homepage = new Homepage(driver);
        this.loginPage = new LoginPage(driver);
        this.registerPage = new RegisterPage(driver);
        this.accountPage = new AccountPage(driver);
        this.headerPage = new HeaderPage(driver);
        this.productsGridPage = new ProductsGridPage(driver);
        this.wishlistPage = new WishlistPage(driver);
        this.homepage.open();
    }

    @After
    public void closeDriver() {
        this.driver.close();
    }
}

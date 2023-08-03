package com.evozon;

import org.junit.*;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

@RunWith(JUnit4.class)
public class LoginTest extends BaseTest {
    private WebDriver driver;

    @Before
    public void beforeEach() {
        this.driver = new ChromeDriver();
        driver.get("http://qa1magento.dev.evozon.com");
        driver.findElement(By.cssSelector(".skip-account")).click();
        driver.findElement(By.cssSelector("[title=\"Log In\"]")).click();
    }

    @Test
    public void validLoginTest() {
        final String email = "john@email.com";
        final String password = "password";

        this.driver.findElement(By.cssSelector("#email")).sendKeys(email);
        this.driver.findElement(By.cssSelector("#pass")).sendKeys(password);
        this.driver.findElement(By.cssSelector("#send2")).click();

        final String expected = "Hello, John Smith!";
        final String actual = driver.findElement(By.cssSelector(".hello")).getText();
        Assert.assertEquals(expected, actual);
    }

    @After
    public void afterEach() {
        this.driver.close();
    }
}

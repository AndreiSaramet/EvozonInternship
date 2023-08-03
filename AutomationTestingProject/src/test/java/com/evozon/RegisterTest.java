package com.evozon;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.Random;

@RunWith(JUnit4.class)
public class RegisterTest extends BaseTest {
    private WebDriver driver;

    @Before
    public void beforeEach() {
        this.driver = new ChromeDriver();
        this.driver.get("http://qa1magento.dev.evozon.com");
        driver.findElement(By.cssSelector(".skip-account")).click();
        driver.findElement(By.cssSelector("a[title=Register]")).click();
    }

    @Test
    public void validRegisterTest() {
        final String firstName = this.generateString(10);
        final String middleName = this.generateString(10);
        final String lastName = this.generateString(10);
        final String password = "password";
        final String email = String.format("%s%s", this.generateString(5), "@email.com");

        driver.findElement(By.cssSelector("#firstname")).sendKeys(firstName);
        driver.findElement(By.cssSelector("#middlename")).sendKeys(middleName);
        driver.findElement(By.cssSelector("#lastname")).sendKeys(lastName);
        driver.findElement(By.cssSelector("#email_address")).sendKeys(email);
        driver.findElement(By.cssSelector("#password")).sendKeys(password);
        driver.findElement(By.cssSelector("#confirmation")).sendKeys(password);
        driver.findElement(By.cssSelector("#is_subscribed")).click();
        driver.findElement(By.cssSelector("button[title=Register]")).click();

        final String expected = String.format("Welcome, %s %s %s!", firstName, middleName, lastName).toUpperCase();
        final String actual = this.driver.findElement(By.cssSelector("p.welcome-msg")).getText();
        Assert.assertEquals(expected, actual);
    }

    private String generateString(final Integer length) {
        return new Random().ints()
                .filter(i -> (i >= 'a' && i <= 'z') || (i >= 'A' && i <= 'Z'))
                .limit(length)
                .collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append)
                .toString();
    }

    @After
    public void afterEach() {
        this.driver.close();
    }
}
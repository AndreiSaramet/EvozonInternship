package com.evozon;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

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
        final String firstName = "elton";
        final String middleName = "Michael";
        final String lastName = "John";
        final String email = "elton@john.com";
        final String password = "password";

        this.driver.get("http://qa1magento.dev.evozon.com/admin");
        final String adminUsername = "testuser";
        final String adminPassword = "password123";
        this.driver.findElement(By.cssSelector("#username")).sendKeys(adminUsername);
        this.driver.findElement(By.cssSelector("#login")).sendKeys(adminPassword);
        this.driver.findElement(By.cssSelector(".form-button")).click();
        this.driver.findElement(By.cssSelector(".message-popup-head a")).click();
        new Actions(this.driver).moveToElement(this.driver.findElement(By.cssSelector("#nav > li:nth-child(4) > a"))).perform();
        this.driver.findElement(By.cssSelector("#nav > li:nth-child(4) > ul > li:first-of-type")).click();
        this.driver.findElement(By.cssSelector("[id=\"customerGrid_filter_email\"]")).sendKeys(email, Keys.RETURN);

        new WebDriverWait(this.driver, Duration.ofSeconds(60)).until(ExpectedConditions.stalenessOf(this.driver.findElement(By.cssSelector("#customerGrid_table"))));

        List<? extends WebElement> elements = this.driver.findElement(By.cssSelector("#customerGrid_table")).findElements(By.cssSelector("#customerGrid_table tbody tr td:not(.empty-text)"));
        elements.stream()
                .filter(el -> email.equals(el.findElement(By.cssSelector("td:nth-child(4)")).getText()))
                .findAny()
                .ifPresent(customer -> {
                    customer.findElement(By.cssSelector("td a")).click();
                    this.driver.findElement(By.cssSelector(".main-col [title=\"Delete Customer\"]")).click();
                    this.driver.switchTo().alert().accept();
                });

        this.driver.get("http://qa1magento.dev.evozon.com");
        driver.findElement(By.cssSelector(".skip-account")).click();
        driver.findElement(By.cssSelector("a[title=Register]")).click();

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

    @After
    public void afterEach() {
        this.driver.close();
    }
}

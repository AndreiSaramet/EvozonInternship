package com.evozon;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
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

public class AdminCustomersTest {
    private WebDriver driver;

    @Before
    public void beforeEach() {
        this.driver = new ChromeDriver();
        this.driver.get("http://qa1magento.dev.evozon.com/admin");
        final String username = "testuser";
        final String password = "password123";
        this.driver.findElement(By.cssSelector("#username")).sendKeys(username);
        this.driver.findElement(By.cssSelector("#login")).sendKeys(password);
        this.driver.findElement(By.cssSelector(".form-button")).click();
        this.driver.findElement(By.cssSelector(".message-popup-head a")).click();
    }

    @After
    public void afterEach() {
        this.driver.close();
    }

    @Test
    public void removeCustomerTest() {
        final String email = "john@email.com";
        new Actions(this.driver).moveToElement(this.driver.findElement(By.cssSelector("#nav > li:nth-child(4) > a"))).perform();
        this.driver.findElement(By.cssSelector("#nav > li:nth-child(4) > ul > li:first-of-type")).click();
        this.driver.findElement(By.cssSelector("[id=\"customerGrid_filter_email\"]")).sendKeys(email, Keys.RETURN);

        new WebDriverWait(this.driver, Duration.ofSeconds(60)).until(ExpectedConditions.stalenessOf(this.driver.findElement(By.cssSelector("#customerGrid_table"))));

        List<? extends WebElement> elements = this.driver.findElement(By.cssSelector("#customerGrid_table")).findElements(By.cssSelector("#customerGrid_table tbody tr"));
        elements.stream()
                .filter(el -> email.equals(el.findElement(By.cssSelector("td:nth-child(4)")).getText()))
                .findAny()
                .ifPresent(customer -> {
                    customer.findElement(By.cssSelector("td a")).click();
                    this.driver.findElement(By.cssSelector(".main-col [title=\"Delete Customer\"]")).click();
                    this.driver.switchTo().alert().accept();
                    final String expected = "The customer has been deleted.";
                    final String actual = this.driver.findElement(By.cssSelector(".success-msg span")).getText();
                    Assert.assertEquals(expected, actual);
                });
    }
}

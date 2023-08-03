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
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

@RunWith(JUnit4.class)
public class CheckoutTest {
    private WebDriver driver;

    @Before
    public void beforeEach() {
        this.driver = new ChromeDriver();
        this.driver.get("http://qa1magento.dev.evozon.com/");
        driver.findElement(By.cssSelector(".skip-account")).click();
        driver.findElement(By.cssSelector("[title=\"Log In\"]")).click();
        this.driver.findElement(By.cssSelector("#email")).sendKeys("user@email.com");
        this.driver.findElement(By.cssSelector("#pass")).sendKeys("password");
        this.driver.findElement(By.cssSelector("#send2")).click();
        new Actions(driver).moveToElement(driver.findElement(By.cssSelector("li.nav-1 > a"))).perform();
        driver.findElement(By.cssSelector("li.nav-1-3 > a")).click();
        new WebDriverWait(driver, Duration.ofSeconds(30)).until(ExpectedConditions.elementToBeClickable(By.cssSelector(String.format("li:not(.odd) .product-image[title=\"%s\"]", "Park Avenue Pleat Front Trousers")))).click();
        driver.findElement(By.cssSelector(".option-taupe img")).click();
        driver.findElement(By.cssSelector(".option-6")).click();
        driver.findElement(By.cssSelector(".add-to-cart-buttons .btn-cart")).click();
    }

    @Test
    public void validCheckoutTest() {
        new WebDriverWait(driver, Duration.ofSeconds(120)).until(ExpectedConditions.elementToBeClickable(By.cssSelector(".skip-cart"))).click();
        driver.findElement(By.cssSelector(".checkout-button")).click();
        driver.findElement(By.cssSelector("[id='billing:use_for_shipping_no']")).click();
        driver.findElement(By.cssSelector("#billing-buttons-container button")).click();
        new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.elementToBeClickable(By.cssSelector("#shipping-buttons-container button"))).click();
        new WebDriverWait(driver, Duration.ofSeconds(120)).until(ExpectedConditions.elementToBeClickable(By.cssSelector("#s_method_freeshipping_freeshipping"))).click();
        driver.findElement(By.cssSelector("#shipping-method-buttons-container button")).click();
        new WebDriverWait(driver, Duration.ofSeconds(120)).until(ExpectedConditions.elementToBeClickable(By.cssSelector("#payment-buttons-container button"))).click();
        new WebDriverWait(driver, Duration.ofSeconds(120)).until(ExpectedConditions.elementToBeClickable(By.cssSelector("#review-buttons-container button"))).click();

        final String expected = "Thank you for your purchase!".toUpperCase();
        final String actual = new WebDriverWait(driver, Duration.ofSeconds(120)).until(drv -> drv.findElement(By.cssSelector(".sub-title"))).getText();
        Assert.assertEquals(expected, actual);
    }

    @After
    public void afterEach() {
        this.driver.close();
    }
}

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
public class CartTest extends BaseTest {
    private WebDriver driver;

    @Before
    public void beforeEach() {
        this.driver = new ChromeDriver();
        driver.get("http://qa1magento.dev.evozon.com/");
        driver.findElement(By.cssSelector(".skip-account")).click();
        driver.findElement(By.cssSelector("[title=\"Log In\"]")).click();
        this.driver.findElement(By.cssSelector("#email")).sendKeys("user@email.com");
        this.driver.findElement(By.cssSelector("#pass")).sendKeys("password");
        this.driver.findElement(By.cssSelector("#send2")).click();
    }

    @After
    public void afterEach() {
        this.driver.close();
    }

    @Test
    public void validAddToCartTest() {
        final String productName = "Park Avenue Pleat Front Trousers";
        new Actions(driver).moveToElement(driver.findElement(By.cssSelector("li.nav-1 > a"))).perform();
        driver.findElement(By.cssSelector("li.nav-1-3 > a")).click();
        new WebDriverWait(driver, Duration.ofSeconds(30)).until(ExpectedConditions.elementToBeClickable(By.cssSelector(String.format("li:not(.odd) .product-image[title=\"%s\"]", productName)))).click();
        driver.findElement(By.cssSelector(".option-taupe img")).click();
        driver.findElement(By.cssSelector(".option-6")).click();
        driver.findElement(By.cssSelector(".add-to-cart-buttons .btn-cart")).click();

        final String expected = String.format("%s was added to your shopping cart.", productName);
        final String actual = driver.findElement(By.cssSelector(".success-msg span")).getText();
        Assert.assertEquals(expected, actual);
    }
}

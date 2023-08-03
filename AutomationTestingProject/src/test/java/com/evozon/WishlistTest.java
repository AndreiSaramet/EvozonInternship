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


@RunWith(JUnit4.class)
public class WishlistTest extends BaseTest {
    private WebDriver driver;

    @Before
    public void beforeAll() {
        this.driver = new ChromeDriver();
        driver.get("http://qa1magento.dev.evozon.com");
        driver.findElement(By.cssSelector(".skip-account")).click();
        driver.findElement(By.cssSelector("[title=\"Log In\"]")).click();
        this.driver.findElement(By.cssSelector("#email")).sendKeys("john@email.com");
        this.driver.findElement(By.cssSelector("#pass")).sendKeys("password");
        this.driver.findElement(By.cssSelector("#send2")).click();
    }

    @Test
    public void validAddToWishlistTest() {
        final String productName = "Core Striped Sport Shirt";

        new Actions(driver).moveToElement(driver.findElement(By.cssSelector("li.nav-2 > a"))).perform();
        driver.findElement(By.cssSelector("li.nav-2-3 > a")).click();
        driver.findElement(By.cssSelector(String.format("[title=\"%s\"] + div a.link-wishlist", productName))).click();

        final String expected = String.format("%s has been added to your wishlist. Click here to continue shopping.", productName);
        final String actual = driver.findElement(By.cssSelector(".success-msg span")).getText();
        Assert.assertEquals(expected, actual);
    }

    @After
    public void afterEach() {
        this.driver.close();
    }
}

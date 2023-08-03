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
public class CompareTest extends BaseTest {
    private WebDriver driver;

    @Before
    public void beforeEach() {
        this.driver = new ChromeDriver();
        driver.get("http://qa1magento.dev.evozon.com/");
        driver.findElement(By.cssSelector(".skip-account")).click();
        driver.findElement(By.cssSelector("[title=\"Log In\"]")).click();
        this.driver.findElement(By.cssSelector("#email")).sendKeys("john@email.com");
        this.driver.findElement(By.cssSelector("#pass")).sendKeys("password");
        this.driver.findElement(By.cssSelector("#send2")).click();
    }

    @Test
    public void validAddToCompareTest() {
        new Actions(driver).moveToElement(driver.findElement(By.cssSelector("#nav > ol > li.level0.nav-4.parent > a"))).perform();
        driver.findElement(By.cssSelector("#nav > ol > li.level0.nav-4.parent > ul > li.level1.nav-4-2 > a")).click();
        driver.findElement(By.cssSelector("body > div > div.page > div.main-container.col3-layout > div > div.col-wrapper > div.col-main > div.category-products > ul > li:nth-child(2) > div > div.actions > ul > li:nth-child(2) > a")).click();

        final String expected = String.format("The product %s has been added to comparison list.", "Shea Enfused Hydrating Body Lotion");
        final String actual = driver.findElement(By.cssSelector("body > div > div.page > div.main-container.col3-layout > div > div.col-wrapper > div.col-main > ul > li > ul > li > span")).getText();
        Assert.assertEquals(expected, actual);
    }

    @After
    public void afterEach() {
        this.driver.close();
    }
}

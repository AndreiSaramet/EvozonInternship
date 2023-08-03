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
import org.openqa.selenium.chrome.ChromeDriver;

@RunWith(JUnit4.class)
public class SearchTest extends BaseTest {
    private WebDriver driver;

    @Before
    public void beforeEach() {
        this.driver = new ChromeDriver();
        driver.get("http://qa1magento.dev.evozon.com");
    }

    @Test
    public void validSearchNoResultTest() {
        this.searchDriver("efygreuifwyugefvg");

        final String expected = "You're search returns no results.";
        final String actual = driver.findElement(By.cssSelector("body > div > div > div.main-container.col3-layout > div > div.col-wrapper > div.col-main > p")).getText();
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void validSearchWithResultsTest() {
        this.searchDriver("shirt");

        final String expected = String.format("%d Item(s)", 5);
        final String actual = driver.findElement(By.cssSelector("body > div > div > div.main-container.col3-layout > div > div.col-wrapper > div.col-main > div.category-products > div.toolbar > div.pager > div > p > strong")).getText();
        Assert.assertEquals(expected, actual);
    }

    @After
    public void afterEach() {
        this.driver.close();
    }

    private void searchDriver(String keywords) {
        driver.findElement(By.cssSelector("#search")).sendKeys(keywords);
        driver.findElement(By.cssSelector("#search")).sendKeys(Keys.RETURN);
    }
}

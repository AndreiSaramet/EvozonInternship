package com.evozon;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class SearchTest {
    public void validSearchNoResultTest() {
        final WebDriver driver = new ChromeDriver();
        driver.get("http://qa1magento.dev.evozon.com");

        this.searchDriver(driver, "efygreuifwyugefvg");

        final String expected = "You're search returns no results.";
        if (driver.findElement(By.cssSelector("body > div > div > div.main-container.col3-layout > div > div.col-wrapper > div.col-main > p")).getText().equals(expected)) {
            System.out.println("Success");
        } else {
            System.err.println("Fail");
        }
        driver.close();
    }

    public void validSearchWithResultsTest() {
        final WebDriver driver = new ChromeDriver();
        driver.get("http://qa1magento.dev.evozon.com");

        this.searchDriver(driver, "shirt");

        final String expected = String.format("%d Item(s)", 5);
        if (driver.findElement(By.cssSelector("body > div > div > div.main-container.col3-layout > div > div.col-wrapper > div.col-main > div.category-products > div.toolbar > div.pager > div > p > strong")).getText().equals(expected)) {
            System.out.println("Success");
        } else {
            System.err.println("Fail");
        }
        driver.close();
    }

    public void searchDriver(WebDriver driver, String keywords) {
        driver.findElement(By.cssSelector("#search")).sendKeys(keywords);
        driver.findElement(By.cssSelector("#search")).sendKeys(Keys.RETURN);
    }
}

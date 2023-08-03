package com.evozon;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import java.text.NumberFormat;
import java.text.ParseException;
import java.util.Locale;
import java.util.function.BiPredicate;

public class SortTest {
    private WebDriver driver;

    @Before
    public void beforeEach() {
        this.driver = new ChromeDriver();
        this.driver.get("http://qa1magento.dev.evozon.com/");
    }

    @Test
    public void sortByPriceAscTest() {
        this.sortByDriver("Price");
        this.comparePrices((a, b) -> a <= b);
    }

    @Test
    public void sortByPriceDscTest() {
        this.sortByDriver("Price");
        this.sortDsc();
        this.comparePrices((a, b) -> a >= b);
    }

    @Test
    public void sortByNameAscTest() {
        this.sortByDriver("Name");
        this.compareNames((a, b) -> a.compareTo(b) <= 0);
    }

    @Test
    public void sortByNameDscTest() {
        this.sortByDriver("Name");
        this.sortDsc();
        this.compareNames((a, b) -> a.compareTo(b) >= 0);
    }

    @After
    public void afterEach() {
        this.driver.close();
    }

    private void comparePrices(final BiPredicate<Double, Double> compare) {
        NumberFormat format = NumberFormat.getInstance(Locale.UK);
        final String price1String = driver.findElement(By.cssSelector("body > div > div.page > div.main-container.col3-layout > div > div.col-wrapper > div.col-main > div.category-products > ul > li:nth-child(1) > div > div.price-box")).getText().substring(1);
        final String price2String = driver.findElement(By.cssSelector("body > div > div.page > div.main-container.col3-layout > div > div.col-wrapper > div.col-main > div.category-products > ul > li:nth-child(2) > div > div.price-box")).getText().substring(1);
        try {
            Assert.assertTrue(compare.test(format.parse(price1String).doubleValue(), format.parse(price2String).doubleValue()));
        } catch (ParseException nfe) {
            Assert.fail(nfe.toString());
        }
    }

    private void compareNames(final BiPredicate<String, String> compare) {
        final String name1 = driver.findElement(By.cssSelector("body > div > div.page > div.main-container.col3-layout > div > div.col-wrapper > div.col-main > div.category-products > ul > li:nth-child(2) > div > h2")).getText();
        final String name2 = driver.findElement(By.cssSelector("body > div > div.page > div.main-container.col3-layout > div > div.col-wrapper > div.col-main > div.category-products > ul > li:nth-child(7) > div > h2")).getText();
        Assert.assertTrue(compare.test(name1, name2));
    }

    private void sortByDriver(final String option) {
        new Actions(driver).moveToElement(driver.findElement(By.cssSelector("#nav > ol > li.level0.nav-3.parent > a"))).perform();
        driver.findElement(By.cssSelector("#nav > ol > li.level0.nav-3.parent > ul > li.level1.nav-3-2 > a")).click();
        new Select(driver.findElement(By.cssSelector("body > div > div.page > div.main-container.col3-layout > div > div.col-wrapper > div.col-main > div.category-products > div.toolbar > div.sorter > div > select"))).selectByVisibleText(option);
    }


    private void sortDsc() {
        driver.findElement(By.cssSelector("body > div > div.page > div.main-container.col3-layout > div > div.col-wrapper > div.col-main > div.category-products > div.toolbar > div.sorter > div > a")).click();
    }
}

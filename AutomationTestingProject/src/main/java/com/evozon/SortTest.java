package com.evozon;

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
    public void sortByPriceAscTest() {
        final WebDriver driver = new ChromeDriver();
        driver.get("http://qa1magento.dev.evozon.com/");

        this.sortByPriceDriver(driver);

        this.comparePrices(driver, (a, b) -> a <= b);

        driver.close();
    }

    public void sortByPriceDscTest() {
        final WebDriver driver = new ChromeDriver();
        driver.get("http://qa1magento.dev.evozon.com/");

        this.sortByPriceDriver(driver);
        this.sortDsc(driver);

        this.comparePrices(driver, (a, b) -> a >= b);

        driver.close();
    }

    public void comparePrices(final WebDriver driver, final BiPredicate<Double, Double> compare) {
        NumberFormat format = NumberFormat.getInstance(Locale.UK);
        final String price1String = driver.findElement(By.cssSelector("body > div > div.page > div.main-container.col3-layout > div > div.col-wrapper > div.col-main > div.category-products > ul > li:nth-child(1) > div > div.price-box")).getText().substring(1);
        final String price2String = driver.findElement(By.cssSelector("body > div > div.page > div.main-container.col3-layout > div > div.col-wrapper > div.col-main > div.category-products > ul > li:nth-child(2) > div > div.price-box")).getText().substring(1);
        try {
            if (compare.test(format.parse(price1String).doubleValue(), format.parse(price2String).doubleValue())) {
                System.out.println("Success");
            } else {
                System.err.println("Fail");
            }
        } catch (ParseException nfe) {
            throw new RuntimeException(nfe);
        }
    }

    public void sortByPriceDriver(final WebDriver driver) {
        new Actions(driver).moveToElement(driver.findElement(By.cssSelector("#nav > ol > li.level0.nav-3.parent > a"))).perform();
        driver.findElement(By.cssSelector("#nav > ol > li.level0.nav-3.parent > ul > li.level1.nav-3-2 > a")).click();
        new Select(driver.findElement(By.cssSelector("body > div > div.page > div.main-container.col3-layout > div > div.col-wrapper > div.col-main > div.category-products > div.toolbar > div.sorter > div > select"))).selectByVisibleText("Price");
    }

    public void sortDsc(final WebDriver driver) {
        driver.findElement(By.cssSelector("body > div > div.page > div.main-container.col3-layout > div > div.col-wrapper > div.col-main > div.category-products > div.toolbar > div.sorter > div > a")).click();
    }
}

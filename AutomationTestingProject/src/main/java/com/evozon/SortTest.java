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
import java.util.function.Consumer;

public class SortTest {

    public void sortByPriceAscTest() {
        this.sortByTest(driver -> this.sortByDriver(driver, "Price"),
                driver -> this.comparePrices(driver, (a, b) -> a <= b));
    }

    public void sortByPriceDscTest() {
        this.sortByTest(driver -> {
                    this.sortByDriver(driver, "Price");
                    this.sortDsc(driver);
                },
                driver -> this.comparePrices(driver, (a, b) -> a >= b));
    }

    public void sortByNameAscTest() {
        this.sortByTest(driver -> this.sortByDriver(driver, "Name"),
                driver -> this.compareNames(driver, (a, b) -> a.compareTo(b) <= 0));
    }

    public void sortByNameDscTest() {
        this.sortByTest(driver -> {
            this.sortByDriver(driver, "Name");
            this.sortDsc(driver);
        }, driver -> this.compareNames(driver, (a, b) -> a.compareTo(b) >= 0));
    }

    private void sortByTest(final Consumer<WebDriver> sortFunction,
                            final Consumer<WebDriver> compareFunction) {
        final WebDriver driver = new ChromeDriver();
        driver.get("http://qa1magento.dev.evozon.com/");

        sortFunction.accept(driver);

        compareFunction.accept(driver);

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

    public void compareNames(final WebDriver driver, final BiPredicate<String, String> compare) {
        final String name1 = driver.findElement(By.cssSelector("body > div > div.page > div.main-container.col3-layout > div > div.col-wrapper > div.col-main > div.category-products > ul > li:nth-child(2) > div > h2")).getText();
        final String name2 = driver.findElement(By.cssSelector("body > div > div.page > div.main-container.col3-layout > div > div.col-wrapper > div.col-main > div.category-products > ul > li:nth-child(7) > div > h2")).getText();
        if (compare.test(name1, name2)) {
            System.out.println("Success");
        } else {
            System.err.println("Fail");
        }
    }

    public void sortByDriver(final WebDriver driver, final String option) {
        new Actions(driver).moveToElement(driver.findElement(By.cssSelector("#nav > ol > li.level0.nav-3.parent > a"))).perform();
        driver.findElement(By.cssSelector("#nav > ol > li.level0.nav-3.parent > ul > li.level1.nav-3-2 > a")).click();
        new Select(driver.findElement(By.cssSelector("body > div > div.page > div.main-container.col3-layout > div > div.col-wrapper > div.col-main > div.category-products > div.toolbar > div.sorter > div > select"))).selectByVisibleText(option);
    }


    public void sortDsc(final WebDriver driver) {
        driver.findElement(By.cssSelector("body > div > div.page > div.main-container.col3-layout > div > div.col-wrapper > div.col-main > div.category-products > div.toolbar > div.sorter > div > a")).click();
    }
}

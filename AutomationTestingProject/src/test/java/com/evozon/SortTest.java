package com.evozon;

import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import java.text.NumberFormat;
import java.text.ParseException;
import java.util.Locale;
import java.util.function.BiPredicate;

public class SortTest extends BaseTest {
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
        try {
            int elementsNo = this.driver.findElements(By.cssSelector(".products-grid > li")).size();
            while (elementsNo > 1) {
                final String price1String = driver.findElement(By.cssSelector(String.format(".products-grid > li:nth-child(%d) .price", elementsNo - 1))).getText().substring(1);
                final String price2String = driver.findElement(By.cssSelector(String.format(".products-grid > li:nth-child(%d) .price", elementsNo))).getText().substring(1);
                Assert.assertTrue(compare.test(format.parse(price1String).doubleValue(), format.parse(price2String).doubleValue()));
                elementsNo--;
            }
        } catch (ParseException nfe) {
            Assert.fail(nfe.toString());
        }
    }

    private void compareNames(final BiPredicate<String, String> compare) {
        int elementsNo = this.driver.findElements(By.cssSelector(".products-grid > li")).size() - 1;
        while (elementsNo > 1) {
            final String name1 = driver.findElement(By.cssSelector(String.format(".products-grid li:nth-child(%d) .product-name", elementsNo - 1))).getText();
            final String name2 = driver.findElement(By.cssSelector(String.format(".products-grid li:nth-child(%d) .product-name", elementsNo))).getText();
            Assert.assertTrue(compare.test(name1, name2));
            elementsNo--;
        }
    }

    private void sortByDriver(final String option) {
        new Actions(driver).moveToElement(driver.findElement(By.cssSelector(".nav-3 > a"))).perform();
        driver.findElement(By.cssSelector(".nav-3-3 > a")).click();
        new Select(driver.findElement(By.cssSelector(".category-products > .toolbar select[title=\"Sort By\"]"))).selectByVisibleText(option);
    }


    private void sortDsc() {
        driver.findElement(By.cssSelector(".category-products > .toolbar .sort-by-switcher")).click();
    }
}

package com.evozon.test;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.text.NumberFormat;
import java.text.ParseException;
import java.util.Locale;
import java.util.function.Function;

public class SortTest extends BaseApplicationTest {
    private final NumberFormat format = NumberFormat.getInstance(Locale.UK);
    private final Function<WebElement, Double> priceExtractor = el -> {
        try {
            return format.parse(el.findElement(By.className("price")).getText().substring(1)).doubleValue();
        } catch (ParseException nfe) {
            return null;
        }
    };

    private final Function<WebElement, String> nameExtractor = el -> el.findElement(By.className("product-name")).getText();

    @Test
    public void sortByPriceAscTest() {
        this.sortByDriver("Price");
        this.productsGridPage.areItemsSorted(this.priceExtractor, (a, b) -> a <= b);

    }

    @Test
    public void sortByPriceDscTest() {
        this.sortByDriver("Price");
        this.sortDsc();
        this.productsGridPage.areItemsSorted(this.priceExtractor, (a, b) -> a >= b);
    }

    @Test
    public void sortByNameAscTest() {
        this.sortByDriver("Name");
        this.productsGridPage.areItemsSorted(this.nameExtractor, (a, b) -> a.compareTo(b) <= 0);
    }

    @Test
    public void sortByNameDscTest() {
        this.sortByDriver("Name");
        this.sortDsc();
        this.productsGridPage.areItemsSorted(this.nameExtractor, (a, b) -> a.compareTo(b) >= 0);
    }

    private void sortByDriver(final String option) {
        this.headerPage.clickAccessoriesSectionLink();
        this.headerPage.clickShoesSubsectionLink();
        this.productsGridPage.selectOptionSortByList(option);
    }


    private void sortDsc() {
        this.productsGridPage.clickSortByOrderLink();
    }
}

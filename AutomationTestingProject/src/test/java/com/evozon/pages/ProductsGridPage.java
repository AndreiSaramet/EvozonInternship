package com.evozon.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class ProductsGridPage extends BasePage {
    @FindBy(css = ".products-grid .item")
    List<WebElement> productsList;

    private final String partialItemCssSelector = ".products-grid .item";

    public ProductsGridPage(final WebDriver driver) {
        super(driver);
    }

    private WebElement findByName(final String name) {
        return this.productsList.stream()
                .filter(el -> name.equalsIgnoreCase(el.findElement(By.cssSelector(String.format("%s %s", this.partialItemCssSelector, ".product-name a"))).getText()))
                .findFirst()
                .orElse(null);
    }

    public void addToWishlistByName(final String name) {
        this.findByName(name).findElement(By.cssSelector(".products-grid .item .link-wishlist")).click();
    }
}

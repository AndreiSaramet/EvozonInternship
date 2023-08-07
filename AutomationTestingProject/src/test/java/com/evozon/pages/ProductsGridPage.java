package com.evozon.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class ProductsGridPage extends BasePage {
    private final String partialItemCssSelector = ".products-grid .item";
    @FindBy(css = ".products-grid .item")
    List<WebElement> productsList;

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

    public void addToCartByName(final String name) {
        this.findByName(name).findElement(By.cssSelector(".actions [type='button'].btn-cart")).click();
    }

    public void addToCompareByName(final String name) {
        this.findByName(name).findElement(By.cssSelector(String.format("[title='%s'] + div .link-compare", name))).click();
    }
}

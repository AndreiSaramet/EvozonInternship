package com.evozon.pages;

import net.serenitybdd.core.pages.WebElementFacade;
import org.openqa.selenium.By;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class ProductsGridPage extends BasePage {
    private final String partialItemsCSSSelector = ".products-grid .item";
    @FindBy(css = ".products-grid .item")
    List<WebElementFacade> productsList;

    public void addToCartByName(final String name) {
        this.clickOn(this.findByName(name).find(By.cssSelector(".actions button[type='button'].btn-cart")));

    }

    private WebElementFacade findByName(final String name) {
        return this.productsList
                .stream()
                .filter(el -> name.equalsIgnoreCase(el.find(By.cssSelector(String.format("%s %s", this.partialItemsCSSSelector, ".product-name a"))).getText()))
                .findFirst()
                .orElse(null);
    }
}

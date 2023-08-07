package com.evozon.steps;

import net.thucydides.core.annotations.Step;
import org.junit.Assert;

public class CartSteps extends BaseSteps {
    @Step
    public void enterSearchText(final String searchText) {
        this.headerPage.setSearchInput(searchText);
    }

    @Step
    public void clickSearch() {
        this.headerPage.clickSearchButton();
    }

    @Step
    public void addToCartByName(final String name) {
        this.productsGridPage.addToCartByName(name);
    }

    @Step
    public void verifyProductAddedToCart(final String name) {
        Assert.assertEquals(String.format("%s was added to your shopping cart.", name), this.cartPage.getSuccessMessageText());
    }

}

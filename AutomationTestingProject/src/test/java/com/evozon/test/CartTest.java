package com.evozon.test;

import org.junit.Assert;
import org.junit.Test;

public class CartTest extends BaseApplicationTest {
    @Test
    public void validAddToCartTest() {
        final String productName = "TestProduct";
        this.headerPage.setSearchInput(productName);
        this.headerPage.clickSearchButton();
        this.productsGridPage.addToCartByName(productName);

        Assert.assertEquals(String.format("%s was added to your shopping cart.", productName), this.cartPage.getSuccessMessageText());
    }
}

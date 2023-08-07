package com.evozon.features;

import net.serenitybdd.junit.runners.SerenityRunner;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(SerenityRunner.class)
public class CartTest extends BaseTest {
    @Test
    public void validAddToCartTest() {
        final String productName = "TestProduct";
        this.cartSteps.enterSearchText(productName);
        this.cartSteps.clickSearch();
        this.cartSteps.addToCartByName(productName);
        this.cartSteps.verifyProductAddedToCart(productName);
    }
}

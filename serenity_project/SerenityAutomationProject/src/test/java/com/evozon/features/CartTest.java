package com.evozon.features;

import com.evozon.steps.CartSteps;
import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Steps;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(SerenityRunner.class)
public class CartTest extends BaseTest {
    @Steps
    public CartSteps cartSteps;

    @Test
    public void validAddToCartTest() {
        final String productName = "TestProduct";
        this.cartSteps.navigateToHomepage();
        this.cartSteps.enterSearchText(productName);
        this.cartSteps.clickSearch();
        this.cartSteps.addToCartByName(productName);
        this.cartSteps.verifyProductAddedToCart(productName);
    }
}

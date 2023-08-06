package com.evozon.test;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class CheckoutTest extends LoggedInTests {

    @Before
    public void beforeEach() {
        final String productName = "TestProduct";
        this.headerPage.setSearchInput(productName);
        this.headerPage.clickSearchButton();
        this.productsGridPage.addToCartByName(productName);
        this.cartPage.clickBottomCheckoutButton();
    }

    @Test
    public void validCheckoutTest() {
        this.checkoutPage.setShipDifferentAddressRadioButton();
        this.checkoutPage.clickBillingContinueButton();
        this.checkoutPage.clickShippingContinueButton();
        this.checkoutPage.setFlatRateShippingMethodRadioButton();
        this.checkoutPage.clickShippingMethodContinueButton();
        this.checkoutPage.clickPaymentContinueButton();
        this.checkoutPage.clickReviewContinueButton();

        Assert.assertEquals("Thank you for your purchase!".toUpperCase(), this.orderConfirmationPage.getConfirmationSubtitleTextHeading());
    }
}

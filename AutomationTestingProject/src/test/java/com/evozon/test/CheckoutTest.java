package com.evozon.test;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

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

        new WebDriverWait(driver, Duration.ofSeconds(120)).until(ExpectedConditions.elementToBeClickable(By.cssSelector("#s_method_freeshipping_freeshipping"))).click();
        driver.findElement(By.cssSelector("#shipping-method-buttons-container button")).click();
        new WebDriverWait(driver, Duration.ofSeconds(120)).until(ExpectedConditions.elementToBeClickable(By.cssSelector("#payment-buttons-container button"))).click();
        new WebDriverWait(driver, Duration.ofSeconds(120)).until(ExpectedConditions.elementToBeClickable(By.cssSelector("#review-buttons-container button"))).click();

        final String expected = "Thank you for your purchase!".toUpperCase();
        final String actual = new WebDriverWait(driver, Duration.ofSeconds(120)).until(drv -> drv.findElement(By.cssSelector(".sub-title"))).getText();
        Assert.assertEquals(expected, actual);
    }
}

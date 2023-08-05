package com.evozon.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class CheckoutPage extends BasePage {
    @FindBy(id = "billing:use_for_shipping_no")
    private WebElement shipDifferentAddressRadioButton;

    @FindBy(css = "#billing-buttons-container button")
    private WebElement billingContinueButton;

    @FindBy(css = "#shipping-buttons-container button")
    private WebElement shippingContinueButton;

    @FindBy(id = "s_method_flatrate_flatrate")
    private WebElement flatRateShippingMethodRadioButton;

    @FindBy(css = "#shipping-method-buttons-container button")
    private WebElement shippingMethodContinueButton;

    @FindBy(css = "#payment-buttons-container button")
    private WebElement paymentContinueButton;

    @FindBy(css = "#review-buttons-container button")
    private WebElement reviewContinueButton;

    public CheckoutPage(final WebDriver driver) {
        super(driver);
    }

    public void setShipDifferentAddressRadioButton() {
        this.shipDifferentAddressRadioButton.click();
    }

    public void clickBillingContinueButton() {
        this.billingContinueButton.click();
    }

    public void clickShippingContinueButton() {
        new WebDriverWait(this.driver, Duration.ofSeconds(120)).until(ExpectedConditions.elementToBeClickable(this.shippingContinueButton)).click();
    }

    public void setFlatRateShippingMethodRadioButton() {
        new WebDriverWait(this.driver, Duration.ofSeconds(600)).until(ExpectedConditions.elementToBeClickable(this.flatRateShippingMethodRadioButton)).click();
    }


    public void clickShippingMethodContinueButton() {
        new WebDriverWait(this.driver, Duration.ofSeconds(660)).until(ExpectedConditions.elementToBeClickable(this.shippingMethodContinueButton)).click();
    }

    public void clickPaymentContinueButton() {
        new WebDriverWait(this.driver, Duration.ofSeconds(120)).until(ExpectedConditions.elementToBeClickable(this.paymentContinueButton)).click();
    }

    public void clickReviewContinueButton() {
        new WebDriverWait(this.driver, Duration.ofSeconds(120)).until(ExpectedConditions.elementToBeClickable(this.reviewContinueButton)).click();
    }
}

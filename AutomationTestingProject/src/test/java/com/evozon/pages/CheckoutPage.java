package com.evozon.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CheckoutPage extends BasePage {
    @FindBy(id = "billing:use_for_shipping_no")
    private WebElement shipDifferentAddressRadioButton;

    @FindBy(css = "#billing-buttons-container button")
    private WebElement billingContinueButton;

    @FindBy(css = "#shipping-buttons-container button")
    private WebElement shippingContinueButton;

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
        this.shippingContinueButton.click();
    }
}

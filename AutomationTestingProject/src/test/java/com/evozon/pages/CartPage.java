package com.evozon.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CartPage extends BasePage {
    @FindBy(css = ".success-msg span")
    private WebElement successMessageSpan;

    @FindBy(css = ".bottom .btn-checkout")
    private WebElement bottomCheckoutButton;

    public CartPage(WebDriver driver) {
        super(driver);
    }

    public String getSuccessMessageText() {
        return this.successMessageSpan.getText();
    }

    public void clickBottomCheckoutButton() {
        this.bottomCheckoutButton.click();
    }
}

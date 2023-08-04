package com.evozon.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CartPage extends BasePage {
    @FindBy(css = ".success-msg span")
    private WebElement successMessageSpan;

    public CartPage(WebDriver driver) {
        super(driver);
    }

    public String getSuccessMessageText() {
        return this.successMessageSpan.getText();
    }
}

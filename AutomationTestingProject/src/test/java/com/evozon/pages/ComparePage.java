package com.evozon.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ComparePage extends BasePage {
    @FindBy(css = ".success-msg span")
    private WebElement successMessageSpan;

    public ComparePage(WebDriver driver) {
        super(driver);
    }

    public String getSuccessMessageText() {
        return this.successMessageSpan.getText();
    }
}

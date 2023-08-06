package com.evozon.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class OrderConfirmationPage extends BasePage {
    @FindBy(className = "sub-title")
    private WebElement confirmationSubtitleTextHeading;

    public OrderConfirmationPage(WebDriver driver) {
        super(driver);
    }

    public String getConfirmationSubtitleTextHeading() {
        return this.confirmationSubtitleTextHeading.getText();
    }
}

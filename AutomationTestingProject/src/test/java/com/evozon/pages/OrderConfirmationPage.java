package com.evozon.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class OrderConfirmationPage extends BasePage {
    @FindBy(className = "sub-title")
    private WebElement confirmationSubtitleTextHeading;

    public OrderConfirmationPage(WebDriver driver) {
        super(driver);
    }

    public String getConfirmationSubtitleTextHeading() {
        return new WebDriverWait(this.driver, Duration.ofSeconds(120)).until(ExpectedConditions.visibilityOf(this.confirmationSubtitleTextHeading)).getText();
    }
}

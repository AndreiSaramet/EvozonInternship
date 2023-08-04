package com.evozon.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HeaderPage extends BasePage {
    @FindBy(className = "welcome-msg")
    private WebElement welcomeTextParagraph;

    public HeaderPage(final WebDriver driver) {
        super(driver);
    }

    public String getWelcomeText() {
        return this.welcomeTextParagraph.getText();
    }
}

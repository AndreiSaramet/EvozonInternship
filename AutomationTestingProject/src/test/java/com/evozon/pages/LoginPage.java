package com.evozon.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage {

    @FindBy(id = "email")
    private WebElement emailInput;

    @FindBy(id = "pass")
    private WebElement passwordInput;

    @FindBy(id = "send2")
    private WebElement loginButton;

    public LoginPage(final WebDriver driver) {
        super(driver);
    }

    public void setEmailInput(final String email) {
        this.emailInput.sendKeys(email);
    }

    public void setPasswordInput(final String password) {
        this.passwordInput.sendKeys(password);
    }

    public void clickLoginButton() {
        this.loginButton.click();
    }
}

package com.evozon.pages;

import com.evozon.utils.Constants;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AdminLoginPage extends BasePage {
    @FindBy(id = "username")
    private WebElement usernameInput;

    @FindBy(id = "login")
    private WebElement passwordInput;

    @FindBy(className = "form-button")
    private WebElement loginButton;

    public AdminLoginPage(final WebDriver driver) {
        super(driver);
    }

    public void open() {
        this.driver.get(Constants.BASE_ADMIN_URL);
    }

    public void setUsernameInput(final String username) {
        this.usernameInput.sendKeys(username);
    }

    public void setPasswordInput(final String password) {
        this.passwordInput.sendKeys(password);
    }

    public void clickLoginButton() {
        this.loginButton.click();
    }
}

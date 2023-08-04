package com.evozon.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class RegisterPage extends BasePage {
    @FindBy(id = "firstname")
    private WebElement firstNameInput;

    @FindBy(id = "middlename")
    private WebElement middleNameInput;

    @FindBy(id = "lastname")
    private WebElement lastNameInput;

    @FindBy(id = "email_address")
    private WebElement emailInput;

    @FindBy(id = "password")
    private WebElement passwordInput;

    @FindBy(id = "confirmation")
    private WebElement confirmPasswordInput;

    @FindBy(id = "is_subscribed")
    private WebElement signUpNewsletterCheckbox;

    @FindBy(css = "button[title=Register] span span")
    private WebElement registerButton;

    public RegisterPage(final WebDriver driver) {
        super(driver);
    }

    public void setFirstNameInput(final String firstName) {
        this.firstNameInput.sendKeys(firstName);
    }

    public void setMiddleNameInput(final String middleName) {
        this.middleNameInput.sendKeys(middleName);
    }

    public void setLastNameInput(final String lastName) {
        this.lastNameInput.sendKeys(lastName);
    }

    public void setEmailInput(final String email) {
        this.emailInput.sendKeys(email);
    }

    public void setPasswordInput(final String password) {
        this.passwordInput.sendKeys(password);
    }

    public void setConfirmPasswordInput(final String password) {
        this.confirmPasswordInput.sendKeys(password);
    }

    public void setSignUpNewsletterCheckbox() {
        this.signUpNewsletterCheckbox.click();
    }

    public void clickRegisterButton() {
        this.registerButton.click();
    }
}

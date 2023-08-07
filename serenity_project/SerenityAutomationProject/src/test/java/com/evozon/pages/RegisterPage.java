package com.evozon.pages;

import net.serenitybdd.core.pages.WebElementFacade;
import org.openqa.selenium.support.FindBy;

public class RegisterPage extends BasePage {
    @FindBy(id = "firstname")
    private WebElementFacade firstNameInput;

    @FindBy(id = "middlename")
    private WebElementFacade middleNameInput;

    @FindBy(id = "lastname")
    private WebElementFacade lastNameInput;

    @FindBy(id = "email_address")
    private WebElementFacade emailInput;

    @FindBy(id = "password")
    private WebElementFacade passwordInput;

    @FindBy(id = "confirmation")
    private WebElementFacade confirmPasswordInput;

    @FindBy(id = "is_subscribed")
    private WebElementFacade signUpNewsletterCheckbox;

    @FindBy(css = "button[title=Register] span span")
    private WebElementFacade registerButton;

    public void setFirstNameInput(final String firstName) {
        this.typeInto(this.firstNameInput, firstName);
    }

    public void setMiddleNameInput(final String middleName) {
        this.typeInto(this.middleNameInput, middleName);
    }

    public void setLastNameInput(final String lastName) {
        this.typeInto(this.lastNameInput, lastName);
    }

    public void setEmailInput(final String email) {
        this.typeInto(this.emailInput, email);
    }

    public void setPasswordInput(final String password) {
        this.typeInto(this.passwordInput, password);
    }

    public void setConfirmPasswordInput(final String password) {
        this.typeInto(this.confirmPasswordInput, password);
    }

    public void setSignUpNewsletterCheckbox() {
        this.clickOn(this.signUpNewsletterCheckbox);
    }

    public void clickRegisterButton() {
        this.clickOn(this.registerButton);
    }

}

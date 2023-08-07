package com.evozon.pages;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends PageObject {
    @FindBy(id = "email")
    private WebElementFacade emailInput;

    @FindBy(id = "pass")
    private WebElementFacade passwordInput;

    @FindBy(id = "send2")
    private WebElementFacade loginButton;

    public void setEmailInput(final String email) {
        this.typeInto(this.emailInput, email);
    }

    public void setPasswordInput(final String password) {
        this.typeInto(this.passwordInput, password);
    }

    public void clickLoginButton() {
        this.clickOn(this.loginButton);
    }
}

package com.evozon.pages;

import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.annotations.DefaultUrl;
import org.openqa.selenium.support.FindBy;

@DefaultUrl(value = "http://qa1magento.dev.evozon.com")
public class HomePage extends BasePage {
    @FindBy(css = ".skip-account .label")
    private WebElementFacade accountLink;

    @FindBy(css = "a[title='Log In']")
    private WebElementFacade loginLink;

    @FindBy(css = "a[title='Register']")
    private WebElementFacade registerLink;

    public void clickAccountLink() {
        this.clickOn(this.accountLink);
    }

    public void clickLoginLink() {
        this.clickOn(this.loginLink);
    }

    public void clickRegisterLink() {
        this.clickOn(this.registerLink);
    }
}

package com.evozon.pages;

import net.serenitybdd.core.pages.WebElementFacade;
import org.openqa.selenium.support.FindBy;

public class AccountPage extends BasePage {

    @FindBy(css = ".hello strong")
    private WebElementFacade welcomeTextParagraph;

    public String getWelcomeText() {
        return this.welcomeTextParagraph.getText();

    }

    public String getWelcomeTextUsername() {
        return this.welcomeTextParagraph.getText()
                .replaceAll("Hello, ", "")
                .replaceAll("!", "");
    }

}
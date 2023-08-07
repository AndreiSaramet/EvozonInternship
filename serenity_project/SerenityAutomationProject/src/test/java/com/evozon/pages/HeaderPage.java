package com.evozon.pages;

import net.serenitybdd.core.pages.WebElementFacade;
import org.openqa.selenium.support.FindBy;

public class HeaderPage extends BasePage {
    @FindBy(className = "welcome-msg")
    private WebElementFacade welcomeTextParagraph;

    @FindBy(id = "search")
    private WebElementFacade searchInput;

    @FindBy(className = "search-button")
    private WebElementFacade searchButton;

    public String getWelcomeText() {
        return this.welcomeTextParagraph.getText();
    }

    public String getWelcomeTextUsername() {
        return this.welcomeTextParagraph.getText()
                .replaceAll("WELCOME, ", "")
                .replaceAll("!", "");
    }

    public void setSearchInput(final String searchText) {
        this.typeInto(this.searchInput, searchText);
    }

    public void clickSearchButton() {
        this.clickOn(this.searchButton);
    }
}

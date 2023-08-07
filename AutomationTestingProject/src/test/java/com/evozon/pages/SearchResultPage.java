package com.evozon.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SearchResultPage extends BasePage {
    @FindBy(className = "note-msg")
    private WebElement resultMessageParagraph;

    @FindBy(css = ".category-products > .toolbar .amount strong")
    private WebElement productsNumberParagraph;

    public SearchResultPage(final WebDriver driver) {
        super(driver);
    }

    public String getResultMessageText() {
        return this.resultMessageParagraph.getText();
    }

    public String getProductsNumberText() {
        return this.productsNumberParagraph.getText();
    }
}

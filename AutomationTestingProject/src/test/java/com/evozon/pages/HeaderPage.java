package com.evozon.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

public class HeaderPage extends BasePage {
    @FindBy(className = "welcome-msg")
    private WebElement welcomeTextParagraph;

    @FindBy(id = "search")
    private WebElement searchInput;

    @FindBy(className = "search-button")
    private WebElement searchButton;

    @FindBy(css = "li.nav-1 > a")
    private WebElement womenSectionLink;

    @FindBy(css = ".nav-1-1 > a")
    private WebElement womenNewArrivalsSubsectionLink;

    @FindBy(css = ".nav-1-2 > a")
    private WebElement womenTopsBlousesSubsectionLink;

    @FindBy(css = ".nav-1-3 > a")
    private WebElement womenPantsDenimSubsectionLink;

    @FindBy(css = ".nav-1-4 > a")
    private WebElement womenDressesSkirtsSubsectionLink;

    @FindBy(css = "li.nav-2 > a")
    private WebElement menSectionLink;

    @FindBy(css = "li.nav-3 > a")
    private WebElement accessoriesSectionLink;

    @FindBy(css = "li.nav-4 > a")
    private WebElement homeDecorSectionLink;

    public HeaderPage(final WebDriver driver) {
        super(driver);
    }

    public String getWelcomeText() {
        return this.welcomeTextParagraph.getText();
    }

    public void setSearchInput(final String searchText) {
        this.searchInput.sendKeys(searchText);
    }

    public void clickSearchButton() {
        this.searchButton.click();
    }

    public void clickWomenSectionLink() {
        new Actions(driver).moveToElement(this.womenSectionLink).perform();
    }

    public void clickWomenNewArrivalsSubsectionLink() {
        this.womenNewArrivalsSubsectionLink.click();
    }

    public void clickWomenTopsBlousesSubsectionLink() {
        this.womenTopsBlousesSubsectionLink.click();
    }

    public void clickWomenPantsDenimSubsectionLink() {
        this.womenPantsDenimSubsectionLink.click();
    }

    public void clickWomenDressesSkirtsSubsectionLink() {
        this.womenDressesSkirtsSubsectionLink.click();
    }

    public void clickMenSectionLink() {
        new Actions(driver).moveToElement(this.menSectionLink).perform();
    }

    public void clickAccessoriesSectionLink() {
        new Actions(driver).moveToElement(this.accessoriesSectionLink).perform();
    }

    public void clickHomeDecorSectionLink() {
        new Actions(driver).moveToElement(this.homeDecorSectionLink).perform();
    }
}

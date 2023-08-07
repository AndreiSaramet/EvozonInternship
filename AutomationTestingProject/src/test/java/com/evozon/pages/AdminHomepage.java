package com.evozon.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

public class AdminHomepage extends BasePage {
    @FindBy(css = ".message-popup-head a")
    private WebElement popupCancelLink;

    @FindBy(css = "#nav > li:nth-child(4) > a span")
    private WebElement customersSectionLink;

    @FindBy(css = "#nav > li:nth-child(4) > ul > li:first-of-type")
    private WebElement manageCustomersSubsectionLink;

    public AdminHomepage(final WebDriver driver) {
        super(driver);
    }

    public void clickPopupCancelLink() {
        this.popupCancelLink.click();
    }

    public void hoverOverCustomersSectionLink() {
        new Actions(this.driver).moveToElement(this.customersSectionLink).perform();
    }

    public void clickManageCustomersSubsectionLink() {
        this.manageCustomersSubsectionLink.click();
    }
}

package com.evozon.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AdminCustomerDetailsPage extends BasePage {
    @FindBy(css = ".main-col button[title='Delete Customer']")
    private WebElement deleteCustomerButton;

    public AdminCustomerDetailsPage(final WebDriver driver) {
        super(driver);
    }

    public void clickDeleteCustomerButton() {
        this.deleteCustomerButton.click();
    }

    public void acceptDeleteAlert() {
        this.driver.switchTo().alert().accept();
    }
}

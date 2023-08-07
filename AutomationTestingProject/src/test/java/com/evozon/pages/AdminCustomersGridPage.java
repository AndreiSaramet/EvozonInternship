package com.evozon.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;
import java.util.Optional;

public class AdminCustomersGridPage extends BasePage {
    @FindBy(css = "#customerGrid_table tbody tr")
    private List<WebElement> customersList;
    @FindBy(id = "customerGrid_filter_email")
    private WebElement searchByEmailInput;

    @FindBy(css = ".success-msg span")
    private WebElement successMessageTextSpan;

    public AdminCustomersGridPage(final WebDriver driver) {
        super(driver);
    }

    public void setSearchByEmailInput(final String email) {
        this.searchByEmailInput.sendKeys(email);
    }

    public void submitSearchByEmailInput() {
        this.searchByEmailInput.sendKeys(Keys.RETURN);
        new WebDriverWait(this.driver, Duration.ofSeconds(60)).until(ExpectedConditions.stalenessOf(this.driver.findElement(By.cssSelector("#customerGrid_table"))));
        this.refreshCustomersList();
    }

    public Optional<WebElement> findCustomerByEmail(final String email) {
        return this.customersList
                .stream()
                .filter(el -> email.equals(el.findElement(By.cssSelector("td:nth-child(4)")).getText()))
                .findAny();
    }

    public void refreshCustomersList() {
        this.customersList = this.driver.findElements(By.cssSelector("#customerGrid_table tbody tr"));
    }

    public void clickOnCustomerByEmail(final String email) {
        this.findCustomerByEmail(email)
                .ifPresent(customer -> customer.findElement(By.cssSelector("td a")).click());
    }

    public String getSuccessMessageText() {
        return this.successMessageTextSpan.getText();
    }
}

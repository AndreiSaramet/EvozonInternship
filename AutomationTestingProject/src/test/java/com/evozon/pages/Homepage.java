package com.evozon.pages;

import com.evozon.utils.Constants;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Homepage extends BasePage {
    @FindBy(css = ".skip-account .label")
    private WebElement accountLink;

    @FindBy(css = "a[title='Log In']")
    private WebElement loginLink;

    @FindBy(css = "a[title=Register]")
    private WebElement registerLink;

    public Homepage(final WebDriver driver) {
        super(driver);
    }

    public void open() {
        this.driver.get(Constants.BASE_URL);
    }

    public void clickAccountLink() {
        this.accountLink.click();
    }

    public void clickLoginLink() {
        this.loginLink.click();
    }

    public void clickRegisterLink() {
        this.registerLink.click();
    }
}

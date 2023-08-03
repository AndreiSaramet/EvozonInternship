package com.evozon;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class CartTest {
    public void validAddToCartTest() {
        final WebDriver driver = new ChromeDriver();
        driver.get("http://qa1magento.dev.evozon.com/");

        new LoginTest().loginDriver(driver, "john@email.com", "password");
        final String productName = "Park Avenue Pleat Front Trousers";

        this.addToCartDriver(driver, productName);

        final String expected = String.format("%s was added to your shopping cart.", productName);
        if (driver.findElement(By.cssSelector(".success-msg span")).getText().equals(expected)) {
            System.out.println("Success");
        } else {
            System.err.println("Fail");
        }
        driver.close();
    }

    public void addToCartDriver(final WebDriver driver, final String productName) {
        final WebElement category = driver.findElement(By.cssSelector("li.nav-1 > a"));
        Actions action = new Actions(driver);
        action.moveToElement(category).perform();
        driver.findElement(By.cssSelector("li.nav-1-3 > a")).click();
        new WebDriverWait(driver, Duration.ofSeconds(30)).until(ExpectedConditions.elementToBeClickable(By.cssSelector(String.format("li:not(.odd) .product-image[title=\"%s\"]", productName)))).click();
        driver.findElement(By.cssSelector(".option-taupe img")).click();
        driver.findElement(By.cssSelector(".option-6")).click();
        driver.findElement(By.cssSelector(".add-to-cart-buttons .btn-cart")).click();
    }
}

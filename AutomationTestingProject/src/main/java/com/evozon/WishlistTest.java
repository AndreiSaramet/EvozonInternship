package com.evozon;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class WishlistTest {
    public void validAddToWishlistTest() {
        final WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("http://qa1magento.dev.evozon.com");

        new LoginTest().loginDriver(driver, "john@email.com", "password");

        final String productName = "Core Striped Sport Shirt";

        this.addToWishlistDriver(driver, productName);

        final String expected = String.format("%s has been added to your wishlist. Click here to continue shopping.", productName);
        if (driver.findElement(By.cssSelector(".success-msg span")).getText().equals(expected)) {
            System.out.println("Success!");
        } else {
            System.err.println("Fail");
        }
        driver.close();
    }

    public void addToWishlistDriver(final WebDriver driver, final String productName) {
        final WebElement category = driver.findElement(By.cssSelector("li.nav-2 > a"));
        Actions action = new Actions(driver);
        action.moveToElement(category).perform();
        driver.findElement(By.cssSelector("li.nav-2-3 > a")).click();
        driver.findElement(By.cssSelector(String.format("[title=\"%s\"] + div a.link-wishlist", productName))).click();
    }
}

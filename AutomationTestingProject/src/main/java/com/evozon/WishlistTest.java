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

        this.addToWishlistDriver(driver);

        final String expected = String.format("%s has been added to your wishlist. Click here to continue shopping.", "Chelsea Tee");
        if (driver.findElement(By.cssSelector("body > div > div > div.main-container.col2-left-layout > div > div.col-main > div.my-account > div.my-wishlist > ul > li > ul > li > span")).getText().equals(expected)) {
            System.out.println("Success!");
        } else {
            System.err.println("Fail");
        }
        driver.close();
    }

    public void addToWishlistDriver(WebDriver driver) {
        final WebElement category = driver.findElement(By.cssSelector("#nav > ol > li.level0.nav-2.parent > a"));
        Actions action = new Actions(driver);
        action.moveToElement(category).perform();
        driver.findElement(By.cssSelector("#nav > ol > li.level0.nav-2.parent > ul > li.level1.nav-2-1.first > a")).click();
        driver.findElement(By.cssSelector("body > div > div > div.main-container.col3-layout > div > div.col-wrapper > div.col-main > div.category-products > ul > li:nth-child(2) > div > div.actions > ul > li:nth-child(1) > a")).click();
    }
}

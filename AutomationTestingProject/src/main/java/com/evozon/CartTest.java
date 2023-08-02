package com.evozon;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class CartTest {
    public void validAddToCartTest() {
        final WebDriver driver = new ChromeDriver();
        driver.get("http://qa1magento.dev.evozon.com/");
        driver.findElement(By.cssSelector("#header > div > div.skip-links > div > a > span.label")).click();
        driver.findElement(By.cssSelector("#header-account > div > ul > li.last > a")).click();
        driver.findElement(By.cssSelector("#email")).sendKeys("john@email.com");
        driver.findElement(By.cssSelector("#pass")).sendKeys("password");
        driver.findElement(By.cssSelector("#send2 > span > span")).click();
        final WebElement category = driver.findElement(By.cssSelector("#nav > ol > li.level0.nav-2.parent > a"));
        Actions action = new Actions(driver);
        action.moveToElement(category).perform();
        driver.findElement(By.cssSelector("#nav > ol > li.level0.nav-2.parent > ul > li.level1.nav-2-1.first > a")).click();
        driver.findElement(By.cssSelector("body > div > div > div.main-container.col3-layout > div > div.col-wrapper > div.col-main > div.category-products > ul > li:nth-child(2) > div > div.actions > a")).click();
        driver.findElement(By.cssSelector("#swatch27 > span.swatch-label > img")).click();
        driver.findElement(By.cssSelector("#swatch80 > span.swatch-label")).click();
        driver.findElement(By.cssSelector("#product_addtocart_form > div.product-shop > div.product-options-bottom > div.add-to-cart > div.add-to-cart-buttons > button > span > span")).click();
        final String expected = String.format("%s was added to your shopping cart.", "Chelsea Tee");
        if (driver.findElement(By.cssSelector("body > div > div > div.main-container.col1-layout > div > div > div.cart.display-single-price > ul > li > ul > li > span")).getText().equals(expected)) {
            System.out.println("Success");
        } else {
            System.err.println("Fail");
        }
        driver.close();
    }
}

package com.evozon;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class CheckoutTest {
    public void validCheckoutTest() {
        final WebDriver driver = new ChromeDriver();
//        login
        driver.get("http://qa1magento.dev.evozon.com");
        driver.findElement(By.cssSelector("#header > div > div.skip-links > div > a > span.label")).click();
        driver.findElement(By.cssSelector("#header-account > div > ul > li.last > a")).click();
        driver.findElement(By.cssSelector("#email")).sendKeys("user@email.com");
        driver.findElement(By.cssSelector("#pass")).sendKeys("password");
        driver.findElement(By.cssSelector("#send2 > span > span")).click();

//        add product to the cart
        final WebElement category = driver.findElement(By.cssSelector("#nav > ol > li.level0.nav-2.parent > a"));
        Actions action = new Actions(driver);
        action.moveToElement(category).perform();
        driver.findElement(By.cssSelector("#nav > ol > li.level0.nav-2.parent > ul > li.level1.nav-2-1.first > a")).click();
        driver.findElement(By.cssSelector("body > div > div > div.main-container.col3-layout > div > div.col-wrapper > div.col-main > div.category-products > ul > li:nth-child(2) > div > div.actions > a")).click();
        driver.findElement(By.cssSelector("#swatch27 > span.swatch-label > img")).click();
        driver.findElement(By.cssSelector("#swatch80 > span.swatch-label")).click();
        driver.findElement(By.cssSelector("#product_addtocart_form > div.product-shop > div.product-options-bottom > div.add-to-cart > div.add-to-cart-buttons > button > span > span")).click();

//        checkout cart
        driver.findElement(By.cssSelector("#header > div > div.skip-links > div > div > a > span.label")).click();
        driver.findElement(By.cssSelector("#header-cart > div.minicart-wrapper > div.minicart-actions > ul > li > a")).click();
        driver.findElement(By.cssSelector("#co-billing-form > div > ul > li:nth-child(4) > label")).click();
        driver.findElement(By.cssSelector("#billing-buttons-container > button")).click();
        new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.elementToBeClickable(By.cssSelector("#shipping-buttons-container > button"))).click();
        new WebDriverWait(driver, Duration.ofSeconds(60)).until(ExpectedConditions.elementToBeClickable(By.cssSelector("#checkout-shipping-method-load > dl > dd:nth-child(4) > ul > li > label"))).click();
        driver.findElement(By.cssSelector("#shipping-method-buttons-container > button > span > span")).click();
        new WebDriverWait(driver, Duration.ofSeconds(60)).until(ExpectedConditions.elementToBeClickable(By.cssSelector("#payment-buttons-container > button"))).click();
        new WebDriverWait(driver, Duration.ofSeconds(120)).until(ExpectedConditions.elementToBeClickable(By.cssSelector("#review-buttons-container > button"))).click();
        final String expected = "Your order has been received.".toUpperCase();
        if (new WebDriverWait(driver, Duration.ofSeconds(120)).until(drv -> drv.findElement(By.cssSelector("body > div > div > div.main-container.col1-layout > div > div > div.page-title > h1"))).getText().equals(expected)) {
            System.out.println("Wow, SUCCESS");
        } else {
            System.err.println("Oops, FAIL");
        }
    }
}

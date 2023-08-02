package com.evozon;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class CheckoutTest {
    public void validCheckoutTest() {
        final WebDriver driver = new ChromeDriver();
        driver.get("http://qa1magento.dev.evozon.com/");

        new LoginTest().loginDriver(driver, "user@email.com", "password");

        new CartTest().addToCartDriver(driver);

        this.checkoutDriver(driver);

        final String expected = "Your order has been received.".toUpperCase();
        if (new WebDriverWait(driver, Duration.ofSeconds(120)).until(drv -> drv.findElement(By.cssSelector("body > div > div > div.main-container.col1-layout > div > div > div.page-title > h1"))).getText().equals(expected)) {
            System.out.println("Wow, SUCCESS");
        } else {
            System.err.println("Oops, FAIL");
        }
        driver.close();
    }

    public void checkoutDriver(WebDriver driver) {
        driver.findElement(By.cssSelector("#header > div > div.skip-links > div > div > a > span.label")).click();
        driver.findElement(By.cssSelector("#header-cart > div.minicart-wrapper > div.minicart-actions > ul > li > a")).click();
        driver.findElement(By.cssSelector("#co-billing-form > div > ul > li:nth-child(4) > label")).click();
        driver.findElement(By.cssSelector("#billing-buttons-container > button")).click();
        new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.elementToBeClickable(By.cssSelector("#shipping-buttons-container > button"))).click();
        new WebDriverWait(driver, Duration.ofSeconds(60)).until(ExpectedConditions.elementToBeClickable(By.cssSelector("#checkout-shipping-method-load > dl > dd:nth-child(4) > ul > li > label"))).click();
        driver.findElement(By.cssSelector("#shipping-method-buttons-container > button > span > span")).click();
        new WebDriverWait(driver, Duration.ofSeconds(60)).until(ExpectedConditions.elementToBeClickable(By.cssSelector("#payment-buttons-container > button"))).click();
        new WebDriverWait(driver, Duration.ofSeconds(120)).until(ExpectedConditions.elementToBeClickable(By.cssSelector("#review-buttons-container > button"))).click();
    }
}

package com.evozon;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class RegisterTest {
    public void validRegisterTest() throws Exception {
        final WebDriver driver = new ChromeDriver();
        driver.get("http://qa1magento.dev.evozon.com");
        final String firstName = "Elton";
        final String middleName = "Michael";
        final String lastName = "John";
        final String password = "johnny";
        final String email = "elton.john@email.com";

        registerDriver(driver, firstName, middleName, lastName, email, password);

        final String expected = String.format("Welcome, %s %s %s!", firstName, middleName, lastName).toUpperCase();

        if (driver.findElement(By.cssSelector("p.welcome-msg")).getText().equals(expected)) {
            System.out.println("Success");
        } else {
            System.err.println("Fail");
        }
        driver.close();
    }

    private static void registerDriver(final WebDriver driver, final String firstName, final String middleName, final String lastName, final String email, final String password) {
        driver.findElement(By.cssSelector(".skip-account")).click();
        driver.findElement(By.cssSelector("a[title=Register]")).click();
        driver.findElement(By.cssSelector("#firstname")).sendKeys(firstName);
        driver.findElement(By.cssSelector("#middlename")).sendKeys(middleName);
        driver.findElement(By.cssSelector("#lastname")).sendKeys(lastName);
        driver.findElement(By.cssSelector("#email_address")).sendKeys(email);
        driver.findElement(By.cssSelector("#password")).sendKeys(password);
        driver.findElement(By.cssSelector("#confirmation")).sendKeys(password);
        driver.findElement(By.cssSelector("#is_subscribed")).click();
        driver.findElement(By.cssSelector("button[title=Register]")).click();
    }
}

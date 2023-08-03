package com.evozon;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class LoginTest {
    public void validLoginTest() {
        final WebDriver driver = new ChromeDriver();
        final String email = "john@email.com";
        final String password = "password";

        driver.get("http://qa1magento.dev.evozon.com");

        this.loginDriver(driver, email, password);

        final String expected = "Hello, John Smith!";
        if (driver.findElement(By.cssSelector(".hello")).getText().equals(expected)) {
            System.out.println("Success");
        } else {
            System.err.println("Fail");
        }
        driver.close();
    }

    public void loginDriver(final WebDriver driver, final String email, final String password) {
        driver.findElement(By.cssSelector(".skip-account")).click();
        driver.findElement(By.cssSelector("[title=\"Log In\"]")).click();
        driver.findElement(By.cssSelector("#email")).sendKeys(email);
        driver.findElement(By.cssSelector("#pass")).sendKeys(password);
        driver.findElement(By.cssSelector("#send2")).click();
    }
}

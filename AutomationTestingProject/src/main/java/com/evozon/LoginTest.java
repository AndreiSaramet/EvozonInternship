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
        if (driver.findElement(By.cssSelector("body > div > div > div.main-container.col2-left-layout > div > div.col-main > div.my-account > div > div.welcome-msg > p.hello > strong")).getText().equals(expected)) {
            System.out.println("Success");
        } else {
            System.err.println("Fail");
        }
        driver.close();
    }

    public void loginDriver(final WebDriver driver, final String email, final String password) {
        driver.findElement(By.cssSelector("#header > div > div.skip-links > div > a > span.label")).click();
        driver.findElement(By.cssSelector("#header-account > div > ul > li.last > a")).click();
        driver.findElement(By.cssSelector("#email")).sendKeys(email);
        driver.findElement(By.cssSelector("#pass")).sendKeys(password);
        driver.findElement(By.cssSelector("#send2 > span > span")).click();
    }
}

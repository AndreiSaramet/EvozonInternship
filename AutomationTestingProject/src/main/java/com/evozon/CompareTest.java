package com.evozon;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class CompareTest {
    public void validAddToCompareTest() {
        final WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("http://qa1magento.dev.evozon.com/");

        new LoginTest().loginDriver(driver, "john@email.com", "password");

        this.addToCompareDriver(driver);

        final String expected = String.format("The product %s has been added to comparison list.", "Shea Enfused Hydrating Body Lotion");
        if (driver.findElement(By.cssSelector("body > div > div.page > div.main-container.col3-layout > div > div.col-wrapper > div.col-main > ul > li > ul > li > span")).getText().equals(expected)) {
            System.out.println("Success");
        } else {
            System.err.println("Fail");
        }

        driver.close();
    }

    public void addToCompareDriver(WebDriver driver) {
        final Actions actions = new Actions(driver);
        actions.moveToElement(driver.findElement(By.cssSelector("#nav > ol > li.level0.nav-4.parent > a"))).perform();
        driver.findElement(By.cssSelector("#nav > ol > li.level0.nav-4.parent > ul > li.level1.nav-4-2 > a")).click();
        driver.findElement(By.cssSelector("body > div > div.page > div.main-container.col3-layout > div > div.col-wrapper > div.col-main > div.category-products > ul > li:nth-child(2) > div > div.actions > ul > li:nth-child(2) > a")).click();
    }
}

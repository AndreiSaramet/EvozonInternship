package com.evozon;

public class BaseTest {
    public void beforeEach() {
        System.setProperty("webdriver.chrome.driver", "resources/chromedriver");
    }
}

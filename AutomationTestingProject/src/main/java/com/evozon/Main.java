package com.evozon;

public class Main {
    public static void main(String[] args) throws Exception {
         System.setProperty("webdriver.chrome.driver", "resources/chromedriver");
//         new RegisterTest().validRegisterTest();
//        new LoginTest().validLoginTest();
        new WishlistTest().validAddToWishlistTest();
    }
}
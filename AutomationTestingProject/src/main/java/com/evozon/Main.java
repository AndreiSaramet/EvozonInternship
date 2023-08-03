package com.evozon;

public class Main {
    public static void main(String[] args) throws Exception {
        System.setProperty("webdriver.chrome.driver", "resources/chromedriver");
//        new RegisterTest().validRegisterTest();
//        new LoginTest().validLoginTest();
//        new WishlistTest().validAddToWishlistTest();
//        new CartTest().validAddToCartTest();
//        new SearchTest().validSearchNoResultTest();
//        new SearchTest().validSearchWithResultsTest();
//        new CheckoutTest().validCheckoutTest();
//        new CompareTest().validAddToCompareTest();
        final SortTest sortTest = new SortTest();
        sortTest.sortByPriceAscTest();
        sortTest.sortByPriceDscTest();
        sortTest.sortByNameAscTest();
        sortTest.sortByNameDscTest();
    }
}
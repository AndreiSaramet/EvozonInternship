package com.evozon.test;

import com.evozon.pages.CheckoutPage;
import com.evozon.pages.WishlistPage;
import com.evozon.utils.Constants;
import org.junit.Before;

public class LoggedInTests extends BaseTest {
    protected WishlistPage wishlistPage;

    protected CheckoutPage checkoutPage;

    @Before
    public void login() {
        this.wishlistPage = new WishlistPage(driver);
        this.checkoutPage = new CheckoutPage(driver);
        this.homepage.clickAccountLink();
        this.homepage.clickLoginLink();
        this.loginPage.setEmailInput(Constants.USER_EMAIL);
        this.loginPage.setPasswordInput(Constants.USER_PASSWORD);
        this.loginPage.clickLoginButton();
    }
}

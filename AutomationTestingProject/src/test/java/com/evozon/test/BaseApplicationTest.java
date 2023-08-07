package com.evozon.test;

import com.evozon.pages.*;
import org.junit.Before;

public abstract class BaseApplicationTest extends BaseTest {
    protected Homepage homepage;
    protected LoginPage loginPage;
    protected RegisterPage registerPage;
    protected AccountPage accountPage;
    protected HeaderPage headerPage;
    protected ProductsGridPage productsGridPage;
    protected CartPage cartPage;
    protected OrderConfirmationPage orderConfirmationPage;
    protected ComparePage comparePage;
    protected SearchResultPage searchResultPage;

    @Before
    public void initPages() {
        this.homepage = new Homepage(driver);
        this.loginPage = new LoginPage(driver);
        this.registerPage = new RegisterPage(driver);
        this.accountPage = new AccountPage(driver);
        this.headerPage = new HeaderPage(driver);
        this.productsGridPage = new ProductsGridPage(driver);
        this.cartPage = new CartPage(driver);
        this.orderConfirmationPage = new OrderConfirmationPage(driver);
        this.comparePage = new ComparePage(driver);
        this.searchResultPage = new SearchResultPage(driver);
        this.homepage.open();
    }
}

package com.evozon.test;

import com.evozon.pages.AdminCustomerDetailsPage;
import com.evozon.pages.AdminCustomersGridPage;
import com.evozon.pages.AdminHomepage;
import com.evozon.pages.AdminLoginPage;
import org.junit.Before;

public abstract class BaseAdminTest extends BaseTest {
    protected AdminLoginPage adminLoginPage;
    protected AdminHomepage adminHomepage;
    protected AdminCustomersGridPage adminCustomersGridPage;
    protected AdminCustomerDetailsPage adminCustomerDetailsPage;

    @Before
    public void initPages() {
        this.adminLoginPage = new AdminLoginPage(driver);
        this.adminHomepage = new AdminHomepage(driver);
        this.adminCustomersGridPage = new AdminCustomersGridPage(driver);
        this.adminCustomerDetailsPage = new AdminCustomerDetailsPage(driver);
        this.adminLoginPage.open();
    }
}

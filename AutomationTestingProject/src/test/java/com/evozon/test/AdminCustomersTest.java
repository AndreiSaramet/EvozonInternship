package com.evozon.test;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class AdminCustomersTest extends BaseAdminTest {

    @Before
    public void beforeEach() {
        final String username = "testuser";
        final String password = "password123";
        this.adminLoginPage.setUsernameInput(username);
        this.adminLoginPage.setPasswordInput(password);
        this.adminLoginPage.clickLoginButton();
        this.adminHomepage.clickPopupCancelLink();
    }

    @Test
    public void removeCustomerTest() {
        final String email = "john@email.com";
        this.adminHomepage.hoverOverCustomersSectionLink();
        this.adminHomepage.clickManageCustomersSubsectionLink();
        this.adminCustomersGridPage.setSearchByEmailInput(email);
        this.adminCustomersGridPage.submitSearchByEmailInput();
        this.adminCustomersGridPage.clickOnCustomerByEmail(email);
        this.adminCustomerDetailsPage.clickDeleteCustomerButton();
        this.adminCustomerDetailsPage.acceptDeleteAlert();

        Assert.assertEquals("The customer has been deleted.", this.adminCustomersGridPage.getSuccessMessageText());
    }
}

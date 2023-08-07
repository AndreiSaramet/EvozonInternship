package com.evozon.test;

import org.junit.Assert;
import org.junit.Test;

public class SearchTest extends BaseTest {

    @Test
    public void validSearchNoResultTest() {
        this.searchDriver("efygreuifwyugefvg");

        Assert.assertEquals("You're search returns no results.", this.searchResultPage.getResultMessageText());
    }

    @Test
    public void validSearchWithResultsTest() {
        this.searchDriver("shirt");

        Assert.assertEquals(String.format("%d Item(s)", 5), this.searchResultPage.getProductsNumberText());
    }

    private void searchDriver(String keywords) {
        this.headerPage.setSearchInput(keywords);
        this.headerPage.clickSearchButton();
    }
}

package com.evozon.test;

import org.junit.Assert;
import org.junit.Test;

public class WishlistTest extends LoggedInTests {
    @Test
    public void validAddToWishlistTest() {
        final String productName = "TestProduct";
        this.headerPage.setSearchInput(productName);
        this.headerPage.clickSearchButton();
        this.productsGridPage.addToWishlistByName(productName);

        Assert.assertEquals(String.format("%s has been added to your wishlist. Click here to continue shopping.", productName), this.wishlistPage.getSuccessMessageText());
    }
}

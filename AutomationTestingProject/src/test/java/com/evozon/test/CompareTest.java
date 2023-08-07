package com.evozon.test;

import org.junit.Assert;
import org.junit.Test;

public class CompareTest extends BaseApplicationTest {

    @Test
    public void validAddToCompareTest() {
        final String productName = "Shea Enfused Hydrating Body Lotion";
        this.headerPage.setSearchInput(productName);
        this.headerPage.clickSearchButton();
        this.productsGridPage.addToCompareByName(productName);

        Assert.assertEquals(String.format("The product %s has been added to comparison list.", productName), this.comparePage.getSuccessMessageText());
    }
}

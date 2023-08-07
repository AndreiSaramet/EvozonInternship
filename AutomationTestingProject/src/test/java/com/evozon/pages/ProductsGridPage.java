package com.evozon.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

import java.util.List;
import java.util.function.BiPredicate;
import java.util.function.Function;

public class ProductsGridPage extends BasePage {
    private final String partialItemCssSelector = ".products-grid .item";
    @FindBy(css = ".products-grid .item")
    private List<WebElement> productsList;

    @FindBy(css = ".category-products > .toolbar select[title='Sort By']")
    private WebElement sortBySelectList;

    @FindBy(css = ".category-products > .toolbar .sort-by-switcher")
    private WebElement sortByOrderLink;

    public ProductsGridPage(final WebDriver driver) {
        super(driver);
    }

    private WebElement findByName(final String name) {
        return this.productsList.stream()
                .filter(el -> name.equalsIgnoreCase(el.findElement(By.cssSelector(String.format("%s %s", this.partialItemCssSelector, ".product-name a"))).getText()))
                .findFirst()
                .orElse(null);
    }

    public <T> boolean areItemsSorted(final Function<WebElement, T> extractor, final BiPredicate<T, T> comparator) {
        int elementsNo = this.productsList.size() - 1;
        WebElement currentElement = this.productsList.get(elementsNo);
        WebElement prevElement;
        while (elementsNo > 0) {
            prevElement = this.productsList.get(elementsNo - 1);
            if (!comparator.test(extractor.apply(prevElement), extractor.apply(currentElement))) {
                return false;
            }
            currentElement = prevElement;
            elementsNo--;
        }
        return true;
    }

    public void addToWishlistByName(final String name) {
        this.findByName(name).findElement(By.cssSelector(".products-grid .item .link-wishlist")).click();
    }

    public void addToCartByName(final String name) {
        this.findByName(name).findElement(By.cssSelector(".actions [type='button'].btn-cart")).click();
    }

    public void addToCompareByName(final String name) {
        this.findByName(name).findElement(By.cssSelector(String.format("[title='%s'] + div .link-compare", name))).click();
    }

    public void selectOptionSortByList(final String option) {
        new Select(this.sortBySelectList).selectByVisibleText(option);
    }

    public void clickSortByOrderLink() {
        this.sortByOrderLink.click();
    }
}

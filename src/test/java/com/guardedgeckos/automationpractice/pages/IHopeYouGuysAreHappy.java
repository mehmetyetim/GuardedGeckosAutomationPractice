package com.guardedgeckos.automationpractice.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class IHopeYouGuysAreHappy extends BasePage
{
    protected static WebDriver driver;
    protected static final String DEFAULT_URL = "http://automationpractice.com/index.php";

    public IHopeYouGuysAreHappy(WebDriver webDriver){
        super(driver, DEFAULT_URL);
    }
    
    public String getCurrentUrl() {
        return driver.getCurrentUrl();
    }
    /**
     * Adds the given item to the cart.
     * @param i the item to add.
     */
    public void addItemToCart(Item i) {
        driver.findElement(i.BY_ADD).click();
    }

    /**
     * Removes the given item from the cart.
     * @param i the item to remove.
     */
    public void removeItem(Item i) {
        driver.findElement(i.BY_REMOVE).click();
    }

    public void proceedToCheckout() {
        driver.findElement(By.xpath("//button[@type='submit' and contains(., 'Proceed to checkout')]")).click();
    }

    public void continueShopping() {
        driver.findElement(By.xpath("//button[@type='submit' and contains(., 'Continue Shopping')]")).click();
    }
    public void NumOfItemsInCart() {
        driver.findElement(By.xpath("//button[@type='submit' and contains(., 'Continue Shopping')]")).click();
    }
}

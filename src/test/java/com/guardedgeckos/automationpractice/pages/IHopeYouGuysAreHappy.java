package com.guardedgeckos.automationpractice.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class IHopeYouGuysAreHappy extends BasePage
{
    public static String DEFAULT_URL = "http://automationpractice.com/index.php";

    private final By proceedToCheckoutButton = By.xpath("//a[@title='Proceed to checkout']");
    private final By continueShoppingButton = By.xpath("//span[@title='Continue shopping']");
    private final By numOfItemsInCart = By.className("ajax_cart_quantity");
    private final By itemsList = By.className("center_column");
    private final By itemsBlock = By.className("ajax_block_product");
    private final By homePageTabs = By.className("home-page-tabs");
    private final By bestSeller = By.className("blockbestsellers");
    private final By popular = By.className("homefeatured");
    private final By itemPhoto = By.className("replace-2x");

    public IHopeYouGuysAreHappy(WebDriver driver)
    {
        super(driver, DEFAULT_URL);
    }

    public String getCurrentUrl() {
        return driver.getCurrentUrl();
    }

    public void addItemToCart(Item i) {
        driver.findElement(i.BY_ADD).click();
    }

    public void removeItem(Item i) {
        driver.findElement(i.BY_REMOVE).click();
    }

    public void proceedToCheckout() {
        driver.findElement(By.xpath("//a[@title='Proceed to checkout']")).click();
    }

    public void continueShopping() {
        driver.findElement(By.xpath("//span[@title='Continue shopping']")).click();
    }
    public void NumOfItemsInCart() {
        driver.findElement(By.xpath("//span[@class='ajax_cart_quantity']")).click();
    }

    public void clickOnProceedToCheckout(){
        driver.findElement(proceedToCheckoutButton).click();
    }

    public void clickOnContinueShopping(){
        driver.findElement(continueShoppingButton).click();
    }

    public Integer getNumOfItemsInCart(){
        return Integer.parseInt(driver.findElement(numOfItemsInCart).getText());
    }

    public void clickBestSellers(){
        try {
            driver.findElement(itemsList)
                    .findElement(homePageTabs)
                    .findElement(bestSeller)
                    .click();
        }catch (IndexOutOfBoundsException e){
            System.out.println("Unable to click");
        }
    }
    public void clickPopular(){
        try {
            driver.findElement(itemsList)
                    .findElement(homePageTabs)
                    .findElement(popular)
                    .click();
        }catch (IndexOutOfBoundsException e){
            System.out.println("Unable to click");
        }
    }
    public void getItemPhotos(int index){
        try {
            driver.findElement(itemsList)
                    .findElement(itemsBlock)
                    .findElements(itemPhoto)
                    .get(index)
                    .click();
        }catch (IndexOutOfBoundsException e){
            System.out.println("Unable to click");
        }
    }
    public void clickAddToCartForProduct(int index){
        try {
            driver.findElement(itemsList)
                    .findElement(itemsBlock)
                    .findElements(itemPhoto)
                    .get(index)
                    .click();
        }catch (IndexOutOfBoundsException e){
            System.out.println("Unable to click");
        }
    }
}
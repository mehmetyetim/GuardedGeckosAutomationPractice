package com.guardedgeckos.automationpractice.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public abstract class BasePage {
    protected static WebDriver driver;
    private By banner = new By.ByClassName("img-responsive");
    private By shopPhone = new By.ByClassName("shop-phone");
    private By contactUs = new By.ById("contact-link");
    private By signIn = new By.ByClassName("login");
    private By yourLogoImg = new By.ByClassName("logo img-responsive");
    private By searchBox = new By.ByClassName("search_query form-control ac_input");
    private By buttonSearchBox = new By.ByClassName("btn btn-default button-search");
    private By cart = new By.ByClassName("shopping_cart");
    private By productsList = new By.ByClassName("products");
    private By checkoutButton = new By.ByClassName("button_order_cart");

    protected BasePage(WebDriver driver) {
        this.driver = driver;
    }

    public String getCurrentUrl() {
        return driver.getCurrentUrl();
    }

    public void bannerURL() {
        try {
            this.driver.findElement(banner).getAttribute("img");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public String businessPhoneNumber() {
        try {
            Pattern pattern = Pattern.compile("[0-9]{4}-[0-9]{3}-[0-9]{3}");
            Matcher matcher = pattern.matcher(this.driver.findElement(shopPhone).getText());
            return matcher.group(1);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "";
    }

    public void getContactUs() {
        try {
            this.driver.findElement(contactUs).click();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void getSigIn() {
        try {
            this.driver.findElement(signIn).click();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void getHomePage() {
        try {
            this.driver.findElement(yourLogoImg).click();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void getSearchBox(String word) {
        try {
            this.driver.findElement(searchBox).sendKeys(word);
            this.driver.findElement(buttonSearchBox).click();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void getCart() {
        try {
            this.driver.findElement(cart).click();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void productsListCart() {
        try {
            this.driver.findElement(productsList);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void checkoutButtonCart() {
        try {
            this.driver.findElement(checkoutButton).click();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void getNavWomen() {
        try {

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void getNavDresses() {
        try {

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void getNavTShirts() {
        try {

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}

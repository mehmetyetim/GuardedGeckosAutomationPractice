package com.guardedgeckos.automationpractice.pages.cart;

import com.guardedgeckos.automationpractice.pages.BasePage;
import com.guardedgeckos.automationpractice.pages.LinksInterface;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CartPage {

    public enum Links implements LinksInterface {
        CONTINUE_SHOPPING{
            @Override
            public BasePage getPage(WebDriver driver) {
                driver.findElement(BY_CONTINUE_SHOPPING);
                return null; // return MainPage? ProductPage? IDK
            }
        },
        CHECKOUT_LOGGED_OUT{
            @Override
            public BasePage getPage(WebDriver driver) {
                driver.findElement(BY_CHECKOUT);
                return null; // return CheckoutPageOne(driver)
            }
        },

        CHECKOUT_LOGGED_IN{
          @Override
          public BasePage getPage(WebDriver driver){
              driver.findElement(BY_CHECKOUT);
              return null; // return CheckoutPageOne(driver, user)
          }
        }
    }


    private static final By
            BY_CONTINUE_SHOPPING = new By.ByClassName("button-exclusive"),
            BY_CHECKOUT = new By.ByClassName("standard-checkout");


//    public CartPage(WebDriver driver){
//        super(driver, "http://automationpractice.com/index.php?controller=order")
//    }


    public boolean isCartEmpty(WebDriver driver){
        if (Integer.parseInt(driver.findElement(new By.ByClassName("ajax_cart_quantity")).getText()) > 0){
            return false;
        }
        return true;
    }
}

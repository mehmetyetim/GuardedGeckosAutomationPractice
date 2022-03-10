package com.guardedgeckos.automationpractice.pages.cart;

import com.guardedgeckos.automationpractice.pages.BasePage;
import com.guardedgeckos.automationpractice.pages.LinksInterface;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ShippingPage extends BasePage{

    public ShippingPage(WebDriver driver) {
        super(driver, false);
    }

    public enum Links implements LinksInterface{
        CONTINUE_SHOPPING{
            @Override
            public BasePage getPage(WebDriver driver) {
                driver.findElement(BY_CONTINUE_SHOPPING).click();
                return new CheckoutAddressPage(driver);
            }
        },
        CHECKOUT_LOGGED_IN{
            @Override
            public BasePage getPage(WebDriver driver){
                driver.findElement(BY_CHECKOUT).click();
                return new PaymentPage(driver);
            }
        }
    }

    private static final By
            BY_CONTINUE_SHOPPING = new By.ByClassName("button-exclusive"),
            BY_CHECKOUT = new By.ByName("processCarrier");


    public void tickTheTermsBox(){
        driver.findElement(By.name("cgv")).click();
    }



}

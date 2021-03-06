package com.guardedgeckos.automationpractice.pages.cart;

import com.guardedgeckos.automationpractice.pages.BasePage;
import com.guardedgeckos.automationpractice.pages.LinksInterface;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CheckoutAddressPage extends BasePage {

    public CheckoutAddressPage(WebDriver driver) {
        super(driver, "http://automationpractice.com/index.php?controller=order&step=1");
    }

    public enum Links implements LinksInterface {
        CONTINUE_SHOPPING{
            @Override
            public BasePage getPage(WebDriver driver) {
                driver.findElement(BY_CONTINUE_SHOPPING).click();
                return null;
            }
        },
        CHECKOUT_LOGGED_IN{
            @Override
            public BasePage getPage(WebDriver driver){
                driver.findElement(BY_CHECKOUT).click();
                return new ShippingPage(driver);
            }
        },
        UPDATE_DELIVERY_ADDRESS {
            @Override
            public BasePage getPage(WebDriver driver) {
                driver.findElements(BY_UPDATE).get(0).click();
                return null;
            }
        },
        UPDATE_BILLING_ADDRESS{
            @Override
            public BasePage getPage(WebDriver driver) {
                driver.findElements(BY_UPDATE).get(1).click();
                return null;
            }
        }
    }

    private static final By
            BY_CONTINUE_SHOPPING = new By.ByClassName("button-exclusive"),
            BY_CHECKOUT = new By.ByXPath("//*[@id=\"center_column\"]/form/p/button"),
            BY_UPDATE = new By.ByLinkText("Update");
}

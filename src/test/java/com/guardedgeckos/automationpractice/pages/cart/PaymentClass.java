package com.guardedgeckos.automationpractice.pages.cart;

import com.guardedgeckos.automationpractice.pages.BasePage;
import com.guardedgeckos.automationpractice.pages.LinksInterface;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class PaymentClass extends BasePage {

    protected PaymentClass(WebDriver driver, String url) {
        super(driver, url);
    }

    public enum Links implements LinksInterface{
        CONTINUE_SHOPPING{
            @Override
            public BasePage getPage(WebDriver driver) {
                driver.findElement(BY_CONTINUE_SHOPPING).click();
                return new ShippingPage(driver, "http://automationpractice.com/index.php?controller=order&step=2");
                }
            }

    }

    private static final By
            BY_CONTINUE_SHOPPING = new By.ByClassName("button-exclusive"),
            BY_BANKWIRE = new By.ByClassName("bankwire"),
            BY_CHECK = new By.ByClassName("check");


    public void BankWireTransfer(WebDriver driver){
        driver.findElement(By.className("bankwire")).click();
    }

}

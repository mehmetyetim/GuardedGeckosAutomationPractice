package com.guardedgeckos.automationpractice.pages.cart;

import com.guardedgeckos.automationpractice.pages.BasePage;
import com.guardedgeckos.automationpractice.pages.LinksInterface;
import com.guardedgeckos.automationpractice.pages.cart.payment.BankWirePage;
import com.guardedgeckos.automationpractice.pages.cart.payment.CheckPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class PaymentPage extends BasePage {

    public PaymentPage(WebDriver driver) {
        super(driver, "http://automationpractice.com/index.php?controller=order&step=3");
    }

    public enum Links implements LinksInterface{
        CONTINUE_SHOPPING{
            @Override
            public BasePage getPage(WebDriver driver) {
                driver.findElement(BY_CONTINUE_SHOPPING).click();
                return new ShippingPage(driver);
                }
            },
        PAY_BY_BANK_WIRE{
            @Override
            public BasePage getPage(WebDriver driver) {
                driver.findElement(BY_BANKWIRE).click();
                return new BankWirePage(driver);
            }
        },
        PAY_BY_CHECK{
            @Override
            public BasePage getPage(WebDriver driver) {
                driver.findElement(BY_CHECK).click();
                return new CheckPage(driver);
            }
        }

    }

    private static final By
            BY_CONTINUE_SHOPPING = new By.ByClassName("button-exclusive"),
            BY_BANKWIRE = new By.ByClassName("bankwire"),
            BY_CHECK = new By.ByClassName("cheque");


//    public void BankWireTransfer(WebDriver driver){
//        driver.findElement(By.className("bankwire")).click();
//    }

}

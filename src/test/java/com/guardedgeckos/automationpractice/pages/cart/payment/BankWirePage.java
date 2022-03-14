package com.guardedgeckos.automationpractice.pages.cart.payment;

import com.guardedgeckos.automationpractice.pages.BasePage;
import com.guardedgeckos.automationpractice.pages.LinksInterface;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class BankWirePage extends BasePage {

    public BankWirePage(WebDriver driver) {
        super(driver, false);
    }

    public BasePage confirmPayment(){
        driver.findElement(By.xpath("//*[@id=\"cart_navigation\"]/button")).click();
        return new FinalPaymentPage(driver);
    }
}

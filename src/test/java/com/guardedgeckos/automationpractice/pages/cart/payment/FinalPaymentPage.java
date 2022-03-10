package com.guardedgeckos.automationpractice.pages.cart.payment;

import com.guardedgeckos.automationpractice.pages.BasePage;
import com.guardedgeckos.automationpractice.pages.ContactUsPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class FinalPaymentPage extends BasePage {

    public FinalPaymentPage(WebDriver driver) {
        super(driver, false);
    }

    public BasePage getContactPage() {
        driver.findElement(By.xpath("//*[@id=\"center_column\"]/div/a")).click();
        return new ContactUsPage(driver);
    }



}

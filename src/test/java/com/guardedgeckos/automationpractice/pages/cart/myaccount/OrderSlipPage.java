package com.guardedgeckos.automationpractice.pages.cart.myaccount;

import com.guardedgeckos.automationpractice.pages.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;

public class OrderSlipPage extends BasePage
{
    private By alert = new By.ByClassName("alert");

    //General
    private By buttonLink = new By.ByTagName("a");
    private By myAccountPageFooter = new By.ByClassName("footer_links");

    //My account page footer buttons
    private final int backToYourAccountButton = 0;
    private final int homeButton = 1;

    public static final String DEFAULT_URL = "http://automationpractice.com/index.php?controller=order-slip";

    public OrderSlipPage(WebDriver driver)
    {
        super(driver, DEFAULT_URL);
    }

    public String getAlertText(){
        try {
            driver.findElement(alert).getText();
        }catch (NoSuchElementException e){
            e.printStackTrace();
            return "NO ALERT";
        }
        return driver.findElement(alert).getText();
    }

    public void clickHomeButton(){
        driver.findElement(myAccountPageFooter).findElements(buttonLink).get(homeButton).click();
    }
    public void clickBackToYourAccountButton(){
        driver.findElement(myAccountPageFooter).findElements(buttonLink).get(backToYourAccountButton).click();
    }


}

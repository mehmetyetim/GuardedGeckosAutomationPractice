package com.guardedgeckos.automationpractice.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;

public class OrderSlipPage extends BasePage {

    private WebDriver webDriver;
    private By alert = new By.ByClassName("alert");


    //General
    private By options = new By.ByTagName("option");
    private By colorMyAccountText = new By.ByClassName("color-myaccount");
    private By paragraph = new By.ByTagName("p");
    private By darkText = new By.ByClassName("dark");
    private By buttonLink = new By.ByTagName("a");
    private By linkButton = new By.ByClassName("link-button");
    private By button = new By.ByClassName("btn");
    private By myAccountPageFooter = new By.ByClassName("footer_links");
    private By footableRow = new By.ByClassName("footable-row-detail-row");
    private By foottableRowValue = new By.ByClassName("footable-row-detail-value");

    //My account page footer buttons
    private final int backToYourAccountButton = 0;
    private final int homeButton = 1;

    public OrderSlipPage(WebDriver webDriver){
        super(webDriver);
        this.webDriver.get("http://automationpractice.com/index.php?controller=order-slip");
    }

    public String getAlertText(){
        try {
            webDriver.findElement(alert).getText();
        }catch (NoSuchElementException e){
            e.printStackTrace();
            return "NO ALERT";
        }
        return webDriver.findElement(alert).getText();
    }

    public void clickHomeButton(){
        webDriver.findElement(myAccountPageFooter).findElements(buttonLink).get(homeButton).click();
    }
    public void clickBackToYourAccountButton(){
        webDriver.findElement(myAccountPageFooter).findElements(buttonLink).get(backToYourAccountButton).click();
    }

}

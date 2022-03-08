package com.guardedgeckos.automationpractice.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AddressesPage {

    private WebDriver webDriver;

    private By centerColumn = new By.ById("center_column");

    //General
    private By clearfix = new By.ByClassName("clearfix");
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


//    public AddressesPage(WebDriver webDriver){
//       }

    public void clickAddANewAddressButton(){
        webDriver
                .findElement(centerColumn)
                .findElement(clearfix)
                .findElement(button)
                .click();
    }

}

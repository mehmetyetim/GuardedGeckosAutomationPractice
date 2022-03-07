package com.guardedgeckos.automationpractice.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class MyAccountPage {

    private WebDriver webDriver;

    private By myAccountButtonList = new By.ByClassName("myaccount-link-list");
    private By myAccountPageFooter = new By.ByClassName("footer_links");
    private By buttonLink = new By.ByTagName("a");

    //Link list column 0
    private final int orderHistoryButton = 0;
    private final int myCreditSlipsButton = 1;
    private final int myAddressesButton = 2;
    private final int myPersonalInfoButton = 3;

    //Link list Column 1
    private final int myWishlistsButton = 0;

    //My account page footer buttons
    private final int homeButton = 0;

//    public MyAccountPage(WebDriver webDriver){
//    }

    public void clickOrderHistoryAndDetailsButton(){
        webDriver.findElements(myAccountButtonList).get(0).findElements(buttonLink).get(orderHistoryButton).click();
    }
    public void clickMyCreditSlipsButton(){
        webDriver.findElements(myAccountButtonList).get(0).findElements(buttonLink).get(myCreditSlipsButton).click();
    }

    public void clickMyAddressesButton(){
        webDriver.findElements(myAccountButtonList).get(0).findElements(buttonLink).get(myAddressesButton).click();
    }

    public void clickMyPersonalInformationButton(){
        webDriver.findElements(myAccountButtonList).get(0).findElements(buttonLink).get(myPersonalInfoButton).click();
    }

    public void clickMyWishlistsButton(){
        webDriver.findElements(myAccountButtonList).get(1).findElements(buttonLink).get(myWishlistsButton).click();
    }

    public void clickHomeButton(){
        webDriver.findElement(myAccountPageFooter).findElements(buttonLink).get(homeButton).click();
    }

}

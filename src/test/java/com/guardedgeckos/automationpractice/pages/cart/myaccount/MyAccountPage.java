package com.guardedgeckos.automationpractice.pages.cart.myaccount;

import com.guardedgeckos.automationpractice.pages.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class MyAccountPage extends BasePage
{

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
    protected static final String DEFAULT_URL = "http://automationpractice.com/index.php?controller=my-account";

    public MyAccountPage(WebDriver driver)
    {
        super(driver, DEFAULT_URL);
    }

    public void clickOrderHistoryAndDetailsButton(){
        driver.findElements(myAccountButtonList).get(0).findElements(buttonLink).get(orderHistoryButton).click();
    }
    public void clickMyCreditSlipsButton(){
        driver.findElements(myAccountButtonList).get(0).findElements(buttonLink).get(myCreditSlipsButton).click();
    }

    public void clickMyAddressesButton(){
        driver.findElements(myAccountButtonList).get(0).findElements(buttonLink).get(myAddressesButton).click();
    }

    public void clickMyPersonalInformationButton(){
        driver.findElements(myAccountButtonList).get(0).findElements(buttonLink).get(myPersonalInfoButton).click();
    }

    public void clickMyWishlistsButton(){
        driver.findElements(myAccountButtonList).get(1).findElements(buttonLink).get(myWishlistsButton).click();
    }

    public void clickHomeButton(){
        driver.findElement(myAccountPageFooter).findElements(buttonLink).get(homeButton).click();
    }

}

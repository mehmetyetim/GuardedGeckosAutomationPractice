package com.guardedgeckos.automationpractice.pages;

import org.openqa.selenium.WebDriver;

public class MyWishlistsPage extends BasePage {

    WebDriver webDriver;

    public MyWishlistsPage(WebDriver webDriver){
        super(webDriver);
        this.webDriver.get("http://automationpractice.com/index.php?fc=module&module=blockwishlist&controller=mywishlist");
    }
}

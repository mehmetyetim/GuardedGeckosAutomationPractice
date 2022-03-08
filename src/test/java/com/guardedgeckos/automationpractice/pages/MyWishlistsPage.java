package com.guardedgeckos.automationpractice.pages;

import org.openqa.selenium.WebDriver;

public class MyWishlistsPage {

    WebDriver webDriver;

    public MyWishlistsPage(WebDriver webDriver){
        this.webDriver = webDriver;
        this.webDriver.get("http://automationpractice.com/index.php?fc=module&module=blockwishlist&controller=mywishlist");
    }


    public String getCurrentUrl() {
        return webDriver.getCurrentUrl();
    }
}

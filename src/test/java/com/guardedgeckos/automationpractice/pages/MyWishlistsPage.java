package com.guardedgeckos.automationpractice.pages;

import org.openqa.selenium.WebDriver;

public class MyWishlistsPage extends BasePage
{

    WebDriver webDriver;

    protected static final String DEFAULT_URL = "http://automationpractice.com/index.php?fc=module&module=blockwishlist&controller=mywishlist";

    public MyWishlistsPage(WebDriver driver)
    {
        super(driver, DEFAULT_URL);
    }

    public String getCurrentUrl() {
        return webDriver.getCurrentUrl();
    }
}

package com.guardedgeckos.automationpractice.pages.cart.myaccount;

import com.guardedgeckos.automationpractice.pages.BasePage;
import org.openqa.selenium.WebDriver;

public class MyWishlistsPage extends BasePage
{

    protected static final String DEFAULT_URL = "http://automationpractice.com/index.php?fc=module&module=blockwishlist&controller=mywishlist";

    public MyWishlistsPage(WebDriver driver)
    {
        super(driver, DEFAULT_URL);
    }

    public String getCurrentUrl() {
        return driver.getCurrentUrl();
    }
}

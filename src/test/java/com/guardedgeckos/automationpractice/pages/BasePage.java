package com.guardedgeckos.automationpractice.pages;

import org.openqa.selenium.WebDriver;

public abstract class BasePage {

    protected static WebDriver driver;
    protected final String URL;

    protected BasePage(WebDriver driver, String url){
        this.driver = driver;
        URL = url;
    }

    public BasePage getPage(LinksInterface l) {
        return l.getPage(driver);
    }

}

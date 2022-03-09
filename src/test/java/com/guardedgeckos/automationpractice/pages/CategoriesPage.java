package com.guardedgeckos.automationpractice.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CategoriesPage extends BasePage {

    private final By homeIcon = By.className("icon-home");
    private final By womenIconNextToHomeIcon = By.className("navigation_page");
    private final By subcategories = By.className("replace-2x");
    private final By checkboxes = By.className("checker");

    public CategoriesPage(WebDriver driver) {
        super(driver);
    }

    public boolean isSubcategoriesDisplayed(){
        for(WebElement subcategory:driver.findElements(subcategories)){
           if(!subcategory.isDisplayed()){
               return false;
           }
        }
        return true;
    }

    public boolean isHomeIconDisplayed(){
        return driver.findElement(homeIcon).isDisplayed();
    }

    public boolean isWomenIconNextToHomeIconDisplayed(){
        return driver.findElement(womenIconNextToHomeIcon).isDisplayed();
    }

    public boolean isAllCheckboxesEnabled(){
        for(WebElement checkbox : driver.findElements(checkboxes)){
            if(!checkbox.isEnabled()){
                return false;
            }
        }
        return true;
    }
}

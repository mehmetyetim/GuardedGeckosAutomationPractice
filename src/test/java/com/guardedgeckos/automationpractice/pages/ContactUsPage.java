package com.guardedgeckos.automationpractice.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

import java.util.Random;

public class ContactUsPage extends BasePage{

    public ContactUsPage(WebDriver driver) {
        super(driver, "http://automationpractice.com/index.php?controller=contact");
    }

    private static final By
            BY_SUBJECT_HEADING = new By.ByName("id_contact"),
            BY_EMAIL_ADDRESS = new By.ByName("from"),
            BY_ORDER_REFERENCE = new By.ByName("id_order"),
            BY_MESSAGE_BODY = new By.ByName("message"),
            BY_SUBMIT = new By.ByName("submitMessage");


    public void contactUsForm(String heading, String message){
        driver.findElement(BY_SUBJECT_HEADING).click();
        if (heading != null){
            if (heading.substring(0, 1).equalsIgnoreCase("c")){
                driver.findElement(BY_SUBJECT_HEADING).sendKeys("c", Keys.ENTER);
            }
            else
                driver.findElement(BY_SUBJECT_HEADING).sendKeys("w", Keys.ENTER);
        }
        else {
            driver.findElement(BY_SUBJECT_HEADING).click();
            driver.findElement(BY_SUBJECT_HEADING).sendKeys("c", Keys.ENTER);
        }
        driver.findElement(BY_ORDER_REFERENCE).click();
        driver.findElement(BY_ORDER_REFERENCE).sendKeys(Keys.ARROW_DOWN, Keys.ENTER);



        driver.findElement(By.className("product_select")).click();
        driver.findElement(By.className("product_select")).sendKeys(Keys.PAGE_DOWN, Keys.ENTER);

        driver.findElement(BY_MESSAGE_BODY).sendKeys(message);

        driver.findElement(BY_SUBMIT).click();

    }


}

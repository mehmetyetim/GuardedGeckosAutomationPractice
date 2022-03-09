package com.guardedgeckos.automationpractice.pages.cart.myaccount;

import com.guardedgeckos.automationpractice.pages.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;

public class IdentityPage extends BasePage
{

    private By alert = new By.ByClassName("alert");

    private By Mr = new By.ById("id_gender1");
    private By Mrs = new By.ById("id_gender2");
    private By firstname = new By.ByName("firstname");
    private By lastname = new By.ByName("lastname");
    private By email = new By.ByName("email");
    private By oldPasswd = new By.ByName("old_passwd");
    private By passwd = new By.ByName("passwd");
    private By passwdConfirmation = new By.ByName("confirmation");
    private By newsLetterCheckBox = new By.ById("uniform-newsletter");
    private By specialOffersCheckBox = new By.ById("uniform-optin");
    private By daysOption = new By.ByName("days");
    private By monthsOption = new By.ByName("months");
    private By yearsOption = new By.ByName("years");


    //General
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

    protected static final String DEFAULT_URL = "http://automationpractice.com/index.php?controller=identity";

    public IdentityPage(WebDriver driver)
    {
        super(driver, DEFAULT_URL);
    }


    public String getAlertText(){
        try {
            driver.findElement(alert).getText();
        }catch (NoSuchElementException e){
            e.printStackTrace();
            return "NO ALERT";
        }
        return driver.findElement(alert).getText();
    }

    public void clickMr(){
        driver.findElement(Mr).click();
    }

    public void clickMrs(){
        driver.findElement(Mrs).click();
    }

    public void inputFirstName(String string){
        driver.findElement(firstname).clear();
        driver.findElement(firstname).sendKeys(string);
    }
    public void inputLastName(String string){
        driver.findElement(lastname).clear();
        driver.findElement(lastname).sendKeys(string);
    }
    public void inputEmail(String string){
        driver.findElement(email).clear();
        driver.findElement(email).sendKeys(string);
    }
    public void inputOldPassword(String string){
        driver.findElement(oldPasswd).clear();
        driver.findElement(oldPasswd).sendKeys(string);
    }
    public void inputNewPassword(String string){
        driver.findElement(passwd).clear();
        driver.findElement(passwd).sendKeys(string);
    }
    public void inputConfirmNewPassword(String string){
        driver.findElement(passwdConfirmation).clear();
        driver.findElement(passwdConfirmation).sendKeys(string);
    }
    public void clickNewsLetterCheckBox(){
        driver.findElement(newsLetterCheckBox).click();
    }
    public void clickSpecialOffersCheckbox(){
        driver.findElement(specialOffersCheckBox).click();
    }

    public void selectDay(int d){
        try{
            driver.findElement(daysOption).click();
            driver.findElement(daysOption).findElements(options).get(d).click();
        }
        catch (IndexOutOfBoundsException e){
            System.out.println("INVALID INDEX");
        }
    }

    public void selectMonth(int m){
        try{
            driver.findElement(monthsOption).click();
            driver.findElement(monthsOption).findElements(options).get(m).click();
        }
        catch (IndexOutOfBoundsException e){
            System.out.println("INVALID INDEX");
        }
    }

    public void selectYear(int y){                                                    //input = how many years ago
        try{
            driver.findElement(yearsOption).click();
            driver.findElement(yearsOption).findElements(options).get(y+1).click();
        }
        catch (IndexOutOfBoundsException e){
            System.out.println("INVALID INDEX");
        }
    }

    public void clickHomeButton(){
        driver.findElement(myAccountPageFooter).findElements(buttonLink).get(homeButton).click();
    }
    public void clickBackToYourAccountButton(){
        driver.findElement(myAccountPageFooter).findElements(buttonLink).get(backToYourAccountButton).click();
    }


    public String getCurrentUrl() {
        return driver.getCurrentUrl();
    }

}

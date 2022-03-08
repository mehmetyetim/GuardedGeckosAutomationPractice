package com.guardedgeckos.automationpractice.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;

public class IdentityPage {

    private WebDriver webDriver;
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


    public IdentityPage(WebDriver webDriver){
        this.webDriver = webDriver;
        this.webDriver.get("http://automationpractice.com/index.php?controller=identity");
    }


    public String getAlertText(){
        try {
            webDriver.findElement(alert).getText();
        }catch (NoSuchElementException e){
            e.printStackTrace();
            return "NO ALERT";
        }
        return webDriver.findElement(alert).getText();
    }

    public void clickMr(){
            webDriver.findElement(Mr).click();
    }

    public void clickMrs(){
        webDriver.findElement(Mrs).click();
    }

    public void inputFirstName(String string){
        webDriver.findElement(firstname).clear();
        webDriver.findElement(firstname).sendKeys(string);
    }
    public void inputLastName(String string){
        webDriver.findElement(lastname).clear();
        webDriver.findElement(lastname).sendKeys(string);
    }
    public void inputEmail(String string){
        webDriver.findElement(email).clear();
        webDriver.findElement(email).sendKeys(string);
    }
    public void inputOldPassword(String string){
        webDriver.findElement(oldPasswd).clear();
        webDriver.findElement(oldPasswd).sendKeys(string);
    }
    public void inputNewPassword(String string){
        webDriver.findElement(passwd).clear();
        webDriver.findElement(passwd).sendKeys(string);
    }
    public void inputConfirmNewPassword(String string){
        webDriver.findElement(passwdConfirmation).clear();
        webDriver.findElement(passwdConfirmation).sendKeys(string);
    }
    public void clickNewsLetterCheckBox(){
        webDriver.findElement(newsLetterCheckBox).click();
    }
    public void clickSpecialOffersCheckbox(){
        webDriver.findElement(specialOffersCheckBox).click();
    }

    public void selectDay(int d){
        try{
            webDriver.findElement(daysOption).click();
            webDriver.findElement(daysOption).findElements(options).get(d).click();
        }
        catch (IndexOutOfBoundsException e){
            System.out.println("INVALID INDEX");
        }
    }

    public void selectMonth(int m){
        try{
            webDriver.findElement(monthsOption).click();
            webDriver.findElement(monthsOption).findElements(options).get(m).click();
        }
        catch (IndexOutOfBoundsException e){
            System.out.println("INVALID INDEX");
        }
    }

    public void selectYear(int y){                                                    //input = how many years ago
        try{
            webDriver.findElement(yearsOption).click();
            webDriver.findElement(yearsOption).findElements(options).get(y+1).click();
        }
        catch (IndexOutOfBoundsException e){
            System.out.println("INVALID INDEX");
        }
    }

    public void clickHomeButton(){
        webDriver.findElement(myAccountPageFooter).findElements(buttonLink).get(homeButton).click();
    }
    public void clickBackToYourAccountButton(){
        webDriver.findElement(myAccountPageFooter).findElements(buttonLink).get(backToYourAccountButton).click();
    }


    public String getCurrentUrl() {
        return webDriver.getCurrentUrl();
    }

}

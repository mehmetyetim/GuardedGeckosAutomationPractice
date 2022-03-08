package com.guardedgeckos.automationpractice.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;

public class AddressPage extends BasePage
{
    private WebDriver webDriver;

    private By alert = new By.ByClassName("alert");

    private By firstname = new By.ByName("firstname");
    private By lastname = new By.ByName("lastname");
    private By address1 = new By.ByName("address1");
    private By address2 = new By.ByName("address2");
    private By city = new By.ByName("city");
    private By postcode = new By.ByName("postcode");
    private By phone = new By.ByName("phone");
    private By phoneMobile = new By.ByName("phone_mobile");
    private By other = new By.ByName("other");
    private By alias = new By.ByName("alias");
    private By idState = new By.ByName("id_state");
    private By idCountry = new By.ByName("id_country");
    private By submitButton = new By.ByName("submitAddress");

    //General
    private By clearfix = new By.ByClassName("clearfix");
    private By options = new By.ByTagName("option");

    protected static final String DEFAULT_URL = "http://automationpractice.com/index.php?controller=address";

    public AddressPage(WebDriver driver)
    {
        super(driver, DEFAULT_URL);
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


    public void inputFirstName(String string){
        webDriver.findElement(firstname).clear();
        webDriver.findElement(firstname).sendKeys(string);
    }
    public void inputLastName(String string){
        webDriver.findElement(lastname).clear();
        webDriver.findElement(lastname).sendKeys(string);
    }
    public void inputAddressOne(String string){
        webDriver.findElement(address1).clear();
        webDriver.findElement(address1).sendKeys(string);
    }
    public void inputAddressTwo(String string){
        webDriver.findElement(address2).clear();
        webDriver.findElement(address2).sendKeys(string);
    }
    public void inputCity(String string){
        webDriver.findElement(city).clear();
        webDriver.findElement(city).sendKeys(string);
    }
    public void inputPostcode(String string){
        webDriver.findElement(postcode).clear();
        webDriver.findElement(postcode).sendKeys(string);
    }
    public void inputMobilePhone(String string){
        webDriver.findElement(phoneMobile).clear();
        webDriver.findElement(phoneMobile).sendKeys(string);
    }
    public void inputPhone(String string){
        webDriver.findElement(phone).clear();
        webDriver.findElement(phone).sendKeys(string);
    }
    public void inputOther(String string){
        webDriver.findElement(other).clear();
        webDriver.findElement(other).sendKeys(string);
    }
    public void inputAlias(String string){
        webDriver.findElement(alias).clear();
        webDriver.findElement(alias).sendKeys(string);
    }

    public void selectState(int index){                                             // 0 = --options--
        webDriver.findElement(idState).click();
        webDriver.findElement(idState).findElements(options).get(index).click();
    }

    public void selectCountry(int index){                                             // only 0 (United States) is available
        webDriver.findElement(idCountry).click();
        webDriver.findElement(idCountry).findElements(options).get(index).click();
    }

    public void clickSaveButton(){
        webDriver.findElement(submitButton).click();
    }



    public String getCurrentUrl() {
        return webDriver.getCurrentUrl();
    }

}

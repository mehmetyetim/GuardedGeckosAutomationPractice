package com.guardedgeckos.automationpractice.pages.cart.myaccount;

import com.guardedgeckos.automationpractice.pages.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;

public class AddressPage extends BasePage
{

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
            driver.findElement(alert).getText();
        }catch (NoSuchElementException e){
            e.printStackTrace();
            return "NO ALERT";
        }
        return driver.findElement(alert).getText();
    }


    public void inputFirstName(String string){
        driver.findElement(firstname).clear();
        driver.findElement(firstname).sendKeys(string);
    }
    public void inputLastName(String string){
        driver.findElement(lastname).clear();
        driver.findElement(lastname).sendKeys(string);
    }
    public void inputAddressOne(String string){
        driver.findElement(address1).clear();
        driver.findElement(address1).sendKeys(string);
    }
    public void inputAddressTwo(String string){
        driver.findElement(address2).clear();
        driver.findElement(address2).sendKeys(string);
    }
    public void inputCity(String string){
        driver.findElement(city).clear();
        driver.findElement(city).sendKeys(string);
    }
    public void inputPostcode(String string){
        driver.findElement(postcode).clear();
        driver.findElement(postcode).sendKeys(string);
    }
    public void inputMobilePhone(String string){
        driver.findElement(phoneMobile).clear();
        driver.findElement(phoneMobile).sendKeys(string);
    }
    public void inputPhone(String string){
        driver.findElement(phone).clear();
        driver.findElement(phone).sendKeys(string);
    }
    public void inputOther(String string){
        driver.findElement(other).clear();
        driver.findElement(other).sendKeys(string);
    }
    public void inputAlias(String string){
        driver.findElement(alias).clear();
        driver.findElement(alias).sendKeys(string);
    }

    public void selectState(int index){                                             // 0 = --options--
        driver.findElement(idState).click();
        driver.findElement(idState).findElements(options).get(index).click();
    }

    public void selectCountry(int index){                                             // only 0 (United States) is available
        driver.findElement(idCountry).click();
        driver.findElement(idCountry).findElements(options).get(index).click();
    }

    public void clickSaveButton(){
        driver.findElement(submitButton).click();
    }

}

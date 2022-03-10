package com.guardedgeckos.automationpractice.pages.cart.myaccount;

import com.guardedgeckos.automationpractice.pages.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AddressesPage extends BasePage
{

    private By centerColumn = new By.ById("center_column");

    private By addressField = new By.ByClassName("addresses");
    private By addressFieldRow = new By.ByClassName("bloc_adresses");               // row number
    private By addressFieldColumn = new By.ByClassName("col-xs-12");                // 2 blocks (index 0-1) in a row

    private By addressFieldName = new By.ByClassName("address_name");
    private By addressFieldAlias = new By.ByClassName("page-subheading");
    private By addressFieldCompanyName = new By.ByClassName("address_company");
    private By addressFieldAddress1 = new By.ByClassName("address_address1");
    private By addressFieldAddress2 = new By.ByClassName("address_address2");
    private By addressFieldPhoneNum = new By.ByClassName("address_phone");
    private By addressFieldMobilePhoneNum = new By.ByClassName("address_phone_mobile");

    //General
    private By address = new By.ByClassName("address");
    private By list = new By.ByTagName("li");
    private By clearfix = new By.ByClassName("clearfix");
    private By options = new By.ByTagName("option");
    private By colorMyAccountText = new By.ByClassName("color-myaccount");
    private By paragraph = new By.ByTagName("p");
    private By darkText = new By.ByClassName("dark");
    private By buttonLink = new By.ByTagName("a");
    private By linkButton = new By.ByClassName("link-button");
    private By button = new By.ByClassName("btn");
    private By myAccountPageFooter = new By.ByClassName("footer_links");

    //My account page footer buttons
    private final int backToYourAccountButton = 0;
    private final int homeButton = 1;

    public static final String DEFAULT_URL = "http://automationpractice.com/index.php?controller=addresses";

    public AddressesPage(WebDriver driver)
    {
        super(driver, DEFAULT_URL);
    }

    public void clickAddANewAddressButton(){
        driver
                .findElement(centerColumn)
                .findElement(clearfix)
                .findElement(button)
                .click();
    }

    public int getAddressBlocksSize(){
        return driver
                .findElement(addressField)
                .findElements(address).size();
    }


    public String getFirstName(int rowIndex, int columnIndex){
        try {
            return driver
                    .findElement(addressField)
                    .findElements(addressFieldRow).get(rowIndex)
                    .findElements(addressFieldColumn).get(columnIndex)
                    .findElements(addressFieldName).get(0).getText();
        }catch (IndexOutOfBoundsException e){
            System.out.println("INVALID INDEX");
            return "INVALID INDEX";
        }
    }

    public String getLastName(int rowIndex, int columnIndex){
        try {
            return driver
                    .findElement(addressField)
                    .findElements(addressFieldRow).get(rowIndex)
                    .findElements(addressFieldColumn).get(columnIndex)
                    .findElements(addressFieldName).get(1).getText();
        }catch (IndexOutOfBoundsException e){
            System.out.println("INVALID INDEX");
            return "INVALID INDEX";
        }
    }


    public String getAddressAlias(int rowIndex, int columnIndex){
        try {
            return driver
                    .findElement(addressField)
                    .findElements(addressFieldRow).get(rowIndex)
                    .findElements(addressFieldColumn).get(columnIndex)
                    .findElement(addressFieldAlias).getText();
        }catch (IndexOutOfBoundsException e){
            System.out.println("INVALID INDEX");
            return "INVALID INDEX";
        }
    }

    public String getAddressCompanyName(int rowIndex, int columnIndex){
        try {
            return driver
                    .findElement(addressField)
                    .findElements(addressFieldRow).get(rowIndex)
                    .findElements(addressFieldColumn).get(columnIndex)
                    .findElement(addressFieldCompanyName).getText();
        }catch (IndexOutOfBoundsException e){
            System.out.println("INVALID INDEX");
            return "INVALID INDEX";
        }
    }

    public String getAddressAddressOne(int rowIndex, int columnIndex){
        try {
            return driver
                    .findElement(addressField)
                    .findElements(addressFieldRow).get(rowIndex)
                    .findElements(addressFieldColumn).get(columnIndex)
                    .findElement(addressFieldAddress1).getText();
        }catch (IndexOutOfBoundsException e){
            System.out.println("INVALID INDEX");
            return "INVALID INDEX";
        }
    }

    public String getAddressAddressTwo(int rowIndex, int columnIndex){
        try {
            return driver
                    .findElement(addressField)
                    .findElements(addressFieldRow).get(rowIndex)
                    .findElements(addressFieldColumn).get(columnIndex)
                    .findElement(addressFieldAddress2).getText();
        }catch (IndexOutOfBoundsException e){
            System.out.println("INVALID INDEX");
            return "INVALID INDEX";
        }
    }

    public String getAddressPhoneNum(int blockRowIndex, int blockColumnIndex){
        try {
            return driver
                    .findElement(addressField)
                    .findElements(addressFieldRow).get(blockRowIndex)
                    .findElements(addressFieldColumn).get(blockColumnIndex)
                    .findElement(addressFieldPhoneNum).getText();
        }catch (IndexOutOfBoundsException e){
            System.out.println("INVALID INDEX");
            return "INVALID INDEX";
        }
    }

    public String getAddressMobilePhoneNum(int blockRowIndex, int blockColumnIndex){
        try {
            return driver
                    .findElement(addressField)
                    .findElements(addressFieldRow).get(blockRowIndex)
                    .findElements(addressFieldColumn).get(blockColumnIndex)
                    .findElement(addressFieldMobilePhoneNum).getText();
        }catch (IndexOutOfBoundsException e){
            System.out.println("INVALID INDEX");
            return "INVALID INDEX";
        }
    }


    public void updateAddressBlock(int blockRowIndex, int blockColumnIndex){
        try {
            driver
                    .findElement(addressField)
                    .findElements(addressFieldRow).get(blockRowIndex)
                    .findElements(addressFieldColumn).get(blockColumnIndex)
                    .findElements(button).get(0)
                    .click();

        }catch (IndexOutOfBoundsException e){
            System.out.println("INVALID INDEX");
        }
    }

    public void deleteAddressBlock(int blockRowIndex, int blockColumnIndex, boolean areYouSure){
        try {
            driver
                    .findElement(addressField)
                    .findElements(addressFieldRow).get(blockRowIndex)
                    .findElements(addressFieldColumn).get(blockColumnIndex)
                    .findElements(button).get(1)
                    .click();

            if(areYouSure){
                driver.switchTo().alert().accept();
            }else {
                driver.switchTo().alert().dismiss();
            }

        }catch (IndexOutOfBoundsException e){
            System.out.println("INVALID INDEX");
        }
    }

    //Another way to access string in each block
    //City, State, Postal code & Country only accessible by inputting row number, this website is trolling

    public String getStringInAddressBlock(int blockRowIndex, int blockColumnIndex, int rowIndex){
        try {
            return driver
                    .findElement(addressField)
                    .findElements(addressFieldRow).get(blockRowIndex)
                    .findElements(addressFieldColumn).get(blockColumnIndex)
                    .findElements(list).get(rowIndex)
                    .getText();
        }catch (IndexOutOfBoundsException e){
            System.out.println("INVALID INDEX");
            return "INVALID INDEX";
        }
    }

    public void clickHomeButton(){
        driver.findElement(myAccountPageFooter).findElements(buttonLink).get(homeButton).click();
    }
    public void clickBackToYourAccountButton(){
        driver.findElement(myAccountPageFooter).findElements(buttonLink).get(backToYourAccountButton).click();
    }
    

}

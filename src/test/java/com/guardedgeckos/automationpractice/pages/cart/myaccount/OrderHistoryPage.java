package com.guardedgeckos.automationpractice.pages.cart.myaccount;

import com.guardedgeckos.automationpractice.pages.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.ElementNotInteractableException;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;

import java.util.concurrent.TimeUnit;

public class OrderHistoryPage extends BasePage
{

    private By alert = new By.ByClassName("alert");
    private By orderHistoryTable = new By.ById("order-list");
    private By orderHistoryList = new By.ByTagName("tbody");
    private By orderTableRow = new By.ByTagName("tr");
    private By orderDateColumn = new By.ByClassName("history_date");
    private By orderPriceColumn = new By.ByClassName("price");
    private By orderStatusColumn = new By.ByClassName("label");
    private By orderHistoryDetailColumn = new By.ByClassName("history_detail");
    private By plusButton = new By.ByClassName("footable-toggle");

    private By orderReferenceBox = new By.ByClassName("box");

    private By infoOrderBox = new By.ByClassName("info-order");

    private By addMessageProductList = new By.ByName("id_product");
    private By messageTextBox = new By.ByName("msgText");
    private By submitButton = new By.ByName("submitMessage");

    private By sendOrderMessageField = new By.ById("sendOrderMessage");
    private By submitField = new By.ByClassName("submit");
    private By submitFieldButton = new By.ByClassName("button");

    private By footableSorter = new By.ByClassName("footable-sortable");

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

    protected static final String DEFAULT_URL = "http://automationpractice.com/index.php?controller=history";

    public OrderHistoryPage(WebDriver driver)
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


    public int getOrderHistorySize() {                        //Get total orders in order history
        try {
            return
                    driver.findElement(orderHistoryTable)
                            .findElement(orderHistoryList)
                            .findElements(orderTableRow)
                            .size();
        }catch (NoSuchElementException e){
            System.out.println("NO ORDER HISTORY FOUND");
            return 0;
        }
    }



    public String getOrderReferenceText(int orderIndex){
        try {
            return
                    driver.findElement(orderHistoryTable)
                    .findElement(orderHistoryList)
                    .findElements(orderTableRow)
                    .get(orderIndex)
                    .findElement(colorMyAccountText)
                    .getText();
        }catch (IndexOutOfBoundsException e){
            System.out.println("INVALID INDEX");
            return "INVALID INDEX";
        }
    }

    public void clickOrderReference(int orderIndex){
        try {
            driver.findElement(orderHistoryTable)
                            .findElement(orderHistoryList)
                            .findElements(orderTableRow)
                            .get(orderIndex)
                            .findElement(colorMyAccountText)
                            .click();
        }catch (IndexOutOfBoundsException e){
            System.out.println("INVALID INDEX");
        }
    }

    public String getOrderDate(int orderIndex){
        try {
            return
                    driver.findElement(orderHistoryTable)
                            .findElement(orderHistoryList)
                            .findElements(orderTableRow)
                            .get(orderIndex)
                            .findElement(orderDateColumn)
                            .getText();
        }catch (IndexOutOfBoundsException e){
            System.out.println("INVALID INDEX");
            return "INVALID INDEX";
        }
    }

    public String getOrderPrice(int orderIndex){
        try {
            return
                    driver.findElement(orderHistoryTable)
                            .findElement(orderHistoryList)
                            .findElements(orderTableRow)
                            .get(orderIndex)
                            .findElement(orderPriceColumn)
                            .getText();
        }catch (IndexOutOfBoundsException e){
            System.out.println("INVALID INDEX");
            return "INVALID INDEX";
        }
    }

    public String getOrderStatus(int orderIndex){
        try {
            return
                    driver.findElement(orderHistoryTable)
                            .findElement(orderHistoryList)
                            .findElements(orderTableRow)
                            .get(orderIndex)
                            .findElement(orderStatusColumn)
                            .getText();
        }catch (IndexOutOfBoundsException e){
            System.out.println("INVALID INDEX");
            return "INVALID INDEX";
        }
    }

    public void clickOrderInvoiceButton(int orderIndex){                                      //Can't see this web element if the browser window is too small!
        try {
            driver.findElement(orderHistoryTable)
                            .findElement(orderHistoryList)
                            .findElements(orderTableRow)
                            .get(orderIndex)
                            .findElement(linkButton)
                            .click();
        }catch (IndexOutOfBoundsException e){
            System.out.println("INVALID INDEX");
        }
    }

    public void clickOrderDetailsButton(int orderIndex){                                      //Can't see this web element if the browser window is too small!
        try {
            driver.findElement(orderHistoryTable)
                    .findElement(orderHistoryList)
                    .findElements(orderTableRow)
                    .get(orderIndex)
                    .findElement(orderHistoryDetailColumn)
                    .findElement(button)
                    .click();
        }catch (IndexOutOfBoundsException e){
            System.out.println("INVALID INDEX");
        }
    }

    public void clickReorderButtonFromTable(int orderIndex){                                     //Can't see this web element if the browser window is too small!
        try {
            driver.findElement(orderHistoryTable)
                    .findElement(orderHistoryList)
                    .findElements(orderTableRow)
                    .get(orderIndex)
                    .findElement(orderHistoryDetailColumn)
                    .findElement(linkButton)
                    .click();
        }catch (IndexOutOfBoundsException e){
            System.out.println("INVALID INDEX");
        }
    }

    public void clickPlusButton(int orderIndex){                                                 //Can't see this web element if the browser window is too Large
        try {
            driver.findElement(orderHistoryTable)
                    .findElement(orderHistoryList)
                    .findElements(orderTableRow)
                    .get(orderIndex)
                    .findElement(plusButton)
                    .click();
        }catch (IndexOutOfBoundsException| ElementNotInteractableException e){
            System.out.println("INVALID INDEX OR ELEMENT NOT INTERACTABLE");
        }
    }

    public String getPaymentTypeFromFootableBox(int orderIndex){                                                 //Can't see this web element if the browser window is too Large / can only be used after pressing the plus button
        try {
            return
                    driver.findElement(orderHistoryTable)
                    .findElement(orderHistoryList)
                    .findElements(orderTableRow)
                    .get(orderIndex+1)
                    .findElements(footableRow)
                    .get(0)
                    .findElement(foottableRowValue)
                    .getText();
        }catch (IndexOutOfBoundsException| ElementNotInteractableException e){
            System.out.println("INVALID INDEX OR ELEMENT NOT INTERACTABLE");
            return "INVALID INDEX OR ELEMENT NOT INTERACTABLE";
        }
    }

    public void clickPDFButtonFromFootableBox(int orderIndex){                                                 //Can't see this web element if the browser window is too Large / can only be used after pressing the plus button
        try {
            driver.findElement(orderHistoryTable)
                            .findElement(orderHistoryList)
                            .findElements(orderTableRow)
                            .get(orderIndex+1)
                            .findElements(footableRow)
                            .get(1)
                            .findElement(foottableRowValue)
                            .findElement(linkButton)
                            .click();
        }catch (IndexOutOfBoundsException| ElementNotInteractableException e){
            System.out.println("INVALID INDEX OR ELEMENT NOT INTERACTABLE");
        }
    }

    public void clickDetailsButtonFromFootableBox(int orderIndex){                                                 //Can't see this web element if the browser window is too Large / can only be used after pressing the plus button
        try {
            driver.findElement(orderHistoryTable)
                    .findElement(orderHistoryList)
                    .findElements(orderTableRow)
                    .get(orderIndex+1)
                    .findElements(footableRow)
                    .get(2)
                    .findElement(foottableRowValue)
                    .findElement(button)
                    .click();
        }catch (IndexOutOfBoundsException| ElementNotInteractableException e){
            System.out.println("ALERT: INVALID INDEX OR ELEMENT NOT INTERACTABLE");
        }
    }

    public void clickReorderButtonFromFootableBox(int orderIndex){                                                 //Can't see this web element if the browser window is too Large / can only be used after pressing the plus button
        try {
            driver.findElement(orderHistoryTable)
                    .findElement(orderHistoryList)
                    .findElements(orderTableRow)
                    .get(orderIndex+1)
                    .findElements(footableRow)
                    .get(2)
                    .findElement(foottableRowValue)
                    .findElement(linkButton)
                    .click();
        }catch (IndexOutOfBoundsException| ElementNotInteractableException e){
            System.out.println("ALERT: INVALID INDEX OR ELEMENT NOT INTERACTABLE");
        }
    }

    public void clickSortDate(){
        driver.findElements(footableSorter).get(0).click();
    }

    public void clickSortTotalPrice(){
        driver.findElements(footableSorter).get(1).click();
    }

    public void clickSortStatus(){
        driver.findElements(footableSorter).get(2).click();
    }

    //------------------------------------------------------------------------------------

    public void clickGreenRecorderButton(){
      //  webDriver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);                                    //give time to load order details
        try {
            driver.findElement(orderReferenceBox).findElement(buttonLink).click();
        }catch (NoSuchElementException e){
            System.out.println("NO SUCH ELEMENT OR ELEMENT NO LOADED");
        }
    }

    public String getOrderReferenceTextInTableBelow(){
       // webDriver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);                                    //give time to load order details
        try {
            return driver.findElement(orderReferenceBox).findElement(darkText).getText();
        }catch (NoSuchElementException e){
            System.out.println("NO ELEMENT OR ELEMENT NO LOADED");
            return "NO SUCH ELEMENT OR ELEMENT NO LOADED";
        }
    }

    public String getCarrierFromInfoReferenceBox(){
      //  webDriver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);                                    //give time to load order details
        try {
            return driver
                    .findElement(infoOrderBox)
                    .findElements(paragraph).get(0)
                    .findElement(darkText)
                    .getText();
        }catch (NoSuchElementException e){
            System.out.println("NO ELEMENT OR ELEMENT NO LOADED");
            return "NO SUCH ELEMENT OR ELEMENT NO LOADED";
        }
    }

    public String getPaymentMethodFromInfoReferenceBox(){
      //  webDriver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);                                    //give time to load order details
        try {
            return driver
                    .findElement(infoOrderBox)
                    .findElements(paragraph).get(1)
                    .findElement(colorMyAccountText)
                    .getText();
        }catch (NoSuchElementException e){
            System.out.println("NO ELEMENT OR ELEMENT NO LOADED");
            return "NO SUCH ELEMENT OR ELEMENT NO LOADED";
        }
    }

    public void clickDownloadInvoiceFromInfoReferenceBox(){
       // webDriver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);                                    //give time to load order details
        try {
            driver
                    .findElement(infoOrderBox)
                    .findElements(paragraph).get(2)
                    .findElement(buttonLink)
                    .click();

        }catch (NoSuchElementException e){
            System.out.println("NO ELEMENT OR ELEMENT NO LOADED");
        }
    }

    public void chooseProductInAddAMessage(int index){                                                              // 0 = --choose--
        //webDriver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);                                    //give time to load order details
        try {
            driver.findElement(addMessageProductList).click();
            driver.findElement(addMessageProductList).findElements(options).get(index).click();
        }catch (IndexOutOfBoundsException e){
            System.out.println("INVALID INDEX");
        }
    }

    public void typeMessageInMessageBox(String string){                                                              // 0 = --choose--
        //webDriver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);                                    //give time to load order details
        driver.findElement(messageTextBox).sendKeys(string);
    }

    public void sendMessage(){
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        driver
                .findElement(sendOrderMessageField)
                .findElement(submitField)
                .findElement(submitFieldButton)
                .click();
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

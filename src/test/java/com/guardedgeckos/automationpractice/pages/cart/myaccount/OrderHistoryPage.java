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
    private By orderPaymentColumn = new By.ByClassName("history_method");
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

    private By orderDetailContentTable = new By.ById("order-detail-content");

    private By addressBlockField = new By.ByClassName("adresses_bloc");
    private By addressBlocks = new By.ByClassName("address");
    private By addressSubheading = new By.ByClassName("page-subheading");
    private By addressFirstname = new By.ByClassName("address_firstname");
    private By addressLastname = new By.ByClassName("address_lastname");
    private By addressCompany = new By.ByClassName("address_company");
    private By addressAddress1 = new By.ByClassName("address_address1");
    private By addressAddress2 = new By.ByClassName("address_address2");
    private By addressCity = new By.ByClassName("address_city");
    private By adddressState = new By.ByClassName("address_State:name");
    private By addressPostcode = new By.ByClassName("address_postcode");
    private By addressCountry = new By.ByClassName("address_Country:name");
    private By addressPhone = new By.ByClassName("address_phone");
    private By addressPhoneMobile = new By.ByClassName("address_phone_mobile");


    private By price = new By.ByClassName("price");
    private By priceShipping = new By.ByClassName("price-shipping");

    //General
    private By tableBlock = new By.ByClassName("table_block");
    private By tableFoot = new By.ByTagName("tfoot");
    private By tableBody = new By.ByTagName("tbody");
    private By tableRow = new By.ByTagName("tr");
    private By tableData = new By.ByTagName("td");
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

    public String getPayment(int orderIndex){
        try {
            return
                    driver.findElement(orderHistoryTable)
                            .findElement(orderHistoryList)
                            .findElements(orderTableRow)
                            .get(orderIndex)
                            .findElement(orderPaymentColumn)
                            .getAttribute("innerHTML");
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

    public String getOrderDetailContentReferenceText(int row){
        try {
            return driver
                    .findElement(orderDetailContentTable)
                    .findElement(tableBody)
                    .findElements(tableRow).get(row)
                    .findElements(tableData).get(0).getText();
        }catch (IndexOutOfBoundsException| NoSuchElementException e){
            System.out.println("INVALID INDEX OR NO SUCH ELEMENT");
            return "INVALID INDEX OR NO SUCH ELEMENT";
        }
    }

    public String getOrderDetailContentProductText(int row){
        try {
            return driver
                    .findElement(orderDetailContentTable)
                    .findElement(tableBody)
                    .findElements(tableRow).get(row)
                    .findElements(tableData).get(1).getText();
        }catch (IndexOutOfBoundsException| NoSuchElementException e){
            System.out.println("INVALID INDEX OR NO SUCH ELEMENT");
            return "INVALID INDEX OR NO SUCH ELEMENT";
        }
    }

    public String getOrderDetailContentQuantityText(int row){
        try {
            return driver
                    .findElement(orderDetailContentTable)
                    .findElement(tableBody)
                    .findElements(tableRow).get(row)
                    .findElements(tableData).get(2).getText();
        }catch (IndexOutOfBoundsException| NoSuchElementException e){
            System.out.println("INVALID INDEX OR NO SUCH ELEMENT");
            return "INVALID INDEX OR NO SUCH ELEMENT";
        }
    }


    public String getOrderDetailContentUnitPriceText(int row){
        try {
            return driver
                    .findElement(orderDetailContentTable)
                    .findElement(tableBody)
                    .findElements(tableRow).get(row)
                    .findElements(tableData).get(3).getText();
        }catch (IndexOutOfBoundsException| NoSuchElementException e){
            System.out.println("INVALID INDEX OR NO SUCH ELEMENT");
            return "INVALID INDEX OR NO SUCH ELEMENT";
        }
    }

    public String getOrderDetailContentTotalPriceText(int row){
        try {
            return driver
                    .findElement(orderDetailContentTable)
                    .findElement(tableBody)
                    .findElements(tableRow).get(row)
                    .findElements(tableData).get(4).getText();
        }catch (IndexOutOfBoundsException| NoSuchElementException e){
            System.out.println("INVALID INDEX OR NO SUCH ELEMENT");
            return "INVALID INDEX OR NO SUCH ELEMENT";
        }
    }

    public String getItemsPriceExclTax(){
        try {
            return driver
                    .findElement(orderDetailContentTable)
                    .findElement(tableFoot)
                    .findElements(tableRow).get(0)
                    .findElement(price).getText();
        }catch (ElementNotInteractableException e){
            System.out.println("NO SUCH ELEMENT");
            return "NO SUCH ELEMENT";
        }
    }
    public String getItemsPriceInclTax(){
        try {
            return driver
                    .findElement(orderDetailContentTable)
                    .findElement(tableFoot)
                    .findElements(tableRow).get(1)
                    .findElement(price).getText();
        }catch (ElementNotInteractableException e){
            System.out.println("NO SUCH ELEMENT");
            return "NO SUCH ELEMENT";
        }
    }
    public String getShippingAndHandlingPriceInclTax(){
        try {
            return driver
                    .findElement(orderDetailContentTable)
                    .findElement(tableFoot)
                    .findElements(tableRow).get(2)
                    .findElement(priceShipping).getText();
        }catch (ElementNotInteractableException e){
            System.out.println("NO SUCH ELEMENT");
            return "NO SUCH ELEMENT";
        }
    }
    public String getTotalPriceInOrderDetails(){
        try {
            return driver
                    .findElement(orderDetailContentTable)
                    .findElement(tableFoot)
                    .findElements(tableRow).get(3)
                    .findElement(price).getText();
        }catch (ElementNotInteractableException e){
            System.out.println("NO SUCH ELEMENT");
            return "NO SUCH ELEMENT";
        }
    }
    //////////////////Address Blocks//////////////////////////////
    public String getAddressBlockSubheadingText(int blockIndex){
        try {
            return driver
                    .findElement(addressBlockField)
                    .findElements(addressBlocks).get(blockIndex)
                    .findElement(addressSubheading).getText();
        }catch (IndexOutOfBoundsException| NoSuchElementException e){
            System.out.println("INVALID INDEX OR NO SUCH ELEMENT");
            return "INVALID INDEX OR NO SUCH ELEMENT";
        }
    }
    public String getAddressBlockFirstNameText(int blockIndex){
        try {
            return driver
                    .findElement(addressBlockField)
                    .findElements(addressBlocks).get(blockIndex)
                    .findElement(addressFirstname).getText();
        }catch (IndexOutOfBoundsException| NoSuchElementException e){
            System.out.println("INVALID INDEX OR NO SUCH ELEMENT");
            return "INVALID INDEX OR NO SUCH ELEMENT";
        }
    }
    public String getAddressBlockLastNameText(int blockIndex){
        try {
            return driver
                    .findElement(addressBlockField)
                    .findElements(addressBlocks).get(blockIndex)
                    .findElement(addressLastname).getText();
        }catch (IndexOutOfBoundsException| NoSuchElementException e){
            System.out.println("INVALID INDEX OR NO SUCH ELEMENT");
            return "INVALID INDEX OR NO SUCH ELEMENT";
        }
    }
    public String getAddressBlockCompanyText(int blockIndex){
        try {
            return driver
                    .findElement(addressBlockField)
                    .findElements(addressBlocks).get(blockIndex)
                    .findElement(addressCompany).getText();
        }catch (IndexOutOfBoundsException| NoSuchElementException e){
            System.out.println("INVALID INDEX OR NO SUCH ELEMENT");
            return "INVALID INDEX OR NO SUCH ELEMENT";
        }
    }
    public String getAddressBlockAddressOneText(int blockIndex){
        try {
            return driver
                    .findElement(addressBlockField)
                    .findElements(addressBlocks).get(blockIndex)
                    .findElement(addressAddress1).getText();
        }catch (IndexOutOfBoundsException| NoSuchElementException e){
            System.out.println("INVALID INDEX OR NO SUCH ELEMENT");
            return "INVALID INDEX OR NO SUCH ELEMENT";
        }
    }

    public String getAddressBlockAddressTwoText(int blockIndex){
        try {
            return driver
                    .findElement(addressBlockField)
                    .findElements(addressBlocks).get(blockIndex)
                    .findElement(addressAddress2).getText();
        }catch (IndexOutOfBoundsException| NoSuchElementException e){
            System.out.println("INVALID INDEX OR NO SUCH ELEMENT");
            return "INVALID INDEX OR NO SUCH ELEMENT";
        }
    }

    public String getAddressBlockCityText(int blockIndex){
        try {
            return driver
                    .findElement(addressBlockField)
                    .findElements(addressBlocks).get(blockIndex)
                    .findElement(addressCity).getText();
        }catch (IndexOutOfBoundsException| NoSuchElementException e){
            System.out.println("INVALID INDEX OR NO SUCH ELEMENT");
            return "INVALID INDEX OR NO SUCH ELEMENT";
        }
    }


    public String getAddressBlockStateText(int blockIndex){
        try {
            return driver
                    .findElement(addressBlockField)
                    .findElements(addressBlocks).get(blockIndex)
                    .findElement(adddressState).getText();
        }catch (IndexOutOfBoundsException| NoSuchElementException e){
            System.out.println("INVALID INDEX OR NO SUCH ELEMENT");
            return "INVALID INDEX OR NO SUCH ELEMENT";
        }
    }

    public String getAddressBlockPostCodeText(int blockIndex){
        try {
            return driver
                    .findElement(addressBlockField)
                    .findElements(addressBlocks).get(blockIndex)
                    .findElement(addressPostcode).getText();
        }catch (IndexOutOfBoundsException| NoSuchElementException e){
            System.out.println("INVALID INDEX OR NO SUCH ELEMENT");
            return "INVALID INDEX OR NO SUCH ELEMENT";
        }
    }

    public String getAddressBlockCountryText(int blockIndex){
        try {
            return driver
                    .findElement(addressBlockField)
                    .findElements(addressBlocks).get(blockIndex)
                    .findElement(addressCountry).getText();
        }catch (IndexOutOfBoundsException| NoSuchElementException e){
            System.out.println("INVALID INDEX OR NO SUCH ELEMENT");
            return "INVALID INDEX OR NO SUCH ELEMENT";
        }
    }


    public String getAddressBlockPhoneText(int blockIndex){
        try {
            return driver
                    .findElement(addressBlockField)
                    .findElements(addressBlocks).get(blockIndex)
                    .findElement(addressPhone).getText();
        }catch (IndexOutOfBoundsException| NoSuchElementException e){
            System.out.println("INVALID INDEX OR NO SUCH ELEMENT");
            return "INVALID INDEX OR NO SUCH ELEMENT";
        }
    }

    public String getAddressBlockMobilePhoneText(int blockIndex){
        try {
            return driver
                    .findElement(addressBlockField)
                    .findElements(addressBlocks).get(blockIndex)
                    .findElement(addressPhoneMobile).getText();
        }catch (IndexOutOfBoundsException| NoSuchElementException e){
            System.out.println("INVALID INDEX OR NO SUCH ELEMENT");
            return "INVALID INDEX OR NO SUCH ELEMENT";
        }
    }
////////////////////////////////////////////////////



    public String getMessageFrom(int index){
        return driver
                .findElements(tableBlock).get(2)
                .findElement(tableBody)
                .findElements(tableRow).get(index)
                .findElements(tableData).get(0).getText();
    }

    public String getMessageContent(int index) {
        return driver
                .findElements(tableBlock).get(2)
                .findElement(tableBody)
                .findElements(tableRow).get(index)
                .findElements(tableData).get(1).getText();
    }


    public void clickHomeButton(){
        driver.findElement(myAccountPageFooter).findElements(buttonLink).get(homeButton).click();
    }
    public void clickBackToYourAccountButton(){
        driver.findElement(myAccountPageFooter).findElements(buttonLink).get(backToYourAccountButton).click();
    }

}

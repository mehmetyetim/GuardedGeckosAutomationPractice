package com.guardedgeckos.automationpractice.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.ElementNotInteractableException;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;

public class OrderHistoryPage {

    private WebDriver webDriver;
    private By noOrderAlert = new By.ByClassName("alert");
    private By orderHistoryTable = new By.ById("order-list");
    private By orderHistoryList = new By.ByTagName("tbody");
    private By orderTableRow = new By.ByTagName("tr");
    private By orderReferenceColumn = new By.ByClassName("color-myaccount");
    private By orderDateColumn = new By.ByClassName("history_date");
    private By orderPriceColumn = new By.ByClassName("price");
    private By orderStatusColumn = new By.ByClassName("label");
    private By orderHistoryDetailColumn = new By.ByClassName("history_detail");
    private By plusButton = new By.ByClassName("footable-toggle");

    private By buttonLink = new By.ByTagName("a");
    private By linkButton = new By.ByClassName("link-button");
    private By button = new By.ByClassName("btn");
    private By myAccountPageFooter = new By.ByClassName("footer_links");

    //My account page footer buttons
    private final int backToYourAccountButton = 0;
    private final int homeButton = 1;

//    public OrderHistoryPage(WebDriver webDriver){
//    }


    public String getNoOrderAlertText(){                                    //This alert only shows up with no order history
        try {
            webDriver.findElement(noOrderAlert).getText();
        }catch (NoSuchElementException e){
            e.printStackTrace();
            return "No Alert";
        }
        return webDriver.findElement(noOrderAlert).getText();
    }


    public int getOrderHistorySize(int orderIndex) {                        //Get total orders in order history
        int output;
        try {
            output =
                    webDriver.findElement(orderHistoryTable)
                            .findElement(orderHistoryList)
                            .findElements(orderTableRow)
                            .size();
        }catch (NoSuchElementException e){
            output = 0;
            System.out.println("ALERT: NO ORDER HISTORY FOUND");
            return output;
        }
        return output;
    }



    public String getOrderReference(int orderIndex){
        String output;
        try {
            output =
            webDriver.findElement(orderHistoryTable)
                    .findElement(orderHistoryList)
                    .findElements(orderTableRow)
                    .get(orderIndex)
                    .findElement(orderReferenceColumn)
                    .getText();
        }catch (IndexOutOfBoundsException e){
            output = "ALERT: INVALID INDEX";
            System.out.println("ALERT: INVALID INDEX");
            return output;
        }
        return output;
    }

    public String getOrderDate(int orderIndex){
        String output;
        try {
            output =
                    webDriver.findElement(orderHistoryTable)
                            .findElement(orderHistoryList)
                            .findElements(orderTableRow)
                            .get(orderIndex)
                            .findElement(orderDateColumn)
                            .getText();
        }catch (IndexOutOfBoundsException e){
            output = "ALERT: INVALID INDEX";
            System.out.println("ALERT: INVALID INDEX");
            return output;
        }
        return output;
    }

    public String getOrderPrice(int orderIndex){
        String output;
        try {
            output =
                    webDriver.findElement(orderHistoryTable)
                            .findElement(orderHistoryList)
                            .findElements(orderTableRow)
                            .get(orderIndex)
                            .findElement(orderPriceColumn)
                            .getText();
        }catch (IndexOutOfBoundsException e){
            output = "ALERT: INVALID INDEX";
            System.out.println("ALERT: INVALID INDEX");
            return output;
        }
        return output;
    }

    public String getOrderStatus(int orderIndex){
        String output;
        try {
            output =
                    webDriver.findElement(orderHistoryTable)
                            .findElement(orderHistoryList)
                            .findElements(orderTableRow)
                            .get(orderIndex)
                            .findElement(orderStatusColumn)
                            .getText();
        }catch (IndexOutOfBoundsException e){
            output = "ALERT: INVALID INDEX";
            System.out.println("ALERT: INVALID INDEX");
            return output;
        }
        return output;
    }

    public void clickOrderInvoiceButton(int orderIndex){                                      //Can't see this web element if the browser window is too small!
        try {
                    webDriver.findElement(orderHistoryTable)
                            .findElement(orderHistoryList)
                            .findElements(orderTableRow)
                            .get(orderIndex)
                            .findElement(linkButton)
                            .click();
        }catch (IndexOutOfBoundsException e){
            System.out.println("ALERT: INVALID INDEX");
        }
    }

    public void clickOrderDetailsButton(int orderIndex){                                      //Can't see this web element if the browser window is too small!
        try {
            webDriver.findElement(orderHistoryTable)
                    .findElement(orderHistoryList)
                    .findElements(orderTableRow)
                    .get(orderIndex)
                    .findElement(orderHistoryDetailColumn)
                    .findElement(button)
                    .click();
        }catch (IndexOutOfBoundsException e){
            System.out.println("ALERT: INVALID INDEX");
        }
    }

    public void clickReorderButtonFromTable(int orderIndex){                                     //Can't see this web element if the browser window is too small!
        try {
            webDriver.findElement(orderHistoryTable)
                    .findElement(orderHistoryList)
                    .findElements(orderTableRow)
                    .get(orderIndex)
                    .findElement(orderHistoryDetailColumn)
                    .findElement(linkButton)
                    .click();
        }catch (IndexOutOfBoundsException e){
            System.out.println("ALERT: INVALID INDEX");
        }
    }

    public void clickPlusButton(int orderIndex){                                                 //Can't see this web element if the browser window is too Large
        try {
            webDriver.findElement(orderHistoryTable)
                    .findElement(orderHistoryList)
                    .findElements(orderTableRow)
                    .get(orderIndex)
                    .findElement(plusButton)
                    .click();
        }catch (IndexOutOfBoundsException| ElementNotInteractableException e){
            System.out.println("ALERT: INVALID INDEX OR ELEMENT NOT INTERACTABLE");
        }
    }

    public void clickPDFButtonInFootableBox(int orderIndex){                                                 //Can't see this web element if the browser window is too Large
        try {
            webDriver.findElement(orderHistoryTable)
                    .findElement(orderHistoryList)
                    .findElements(orderTableRow)
                    .get(orderIndex+1)
                    .findElement(plusButton)
                    .click();
        }catch (IndexOutOfBoundsException| ElementNotInteractableException e){
            System.out.println("ALERT: INVALID INDEX OR ELEMENT NOT INTERACTABLE");
        }
    }


    public void clickHomeButton(){
        webDriver.findElement(myAccountPageFooter).findElements(buttonLink).get(homeButton).click();
    }
    public void clickBackToYourAccountButton(){
        webDriver.findElement(myAccountPageFooter).findElements(buttonLink).get(backToYourAccountButton).click();
    }

}

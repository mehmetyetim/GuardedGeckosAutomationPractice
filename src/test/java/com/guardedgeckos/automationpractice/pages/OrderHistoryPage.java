package com.guardedgeckos.automationpractice.pages;

import org.openqa.selenium.By;
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



}

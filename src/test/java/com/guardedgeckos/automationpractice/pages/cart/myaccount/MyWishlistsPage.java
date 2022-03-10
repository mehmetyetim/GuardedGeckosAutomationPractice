package com.guardedgeckos.automationpractice.pages.cart.myaccount;

import com.guardedgeckos.automationpractice.pages.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;

public class MyWishlistsPage extends BasePage
{
    private By nameField = new By.ByName("name");
    private By submitWishlistButton = new By.ByName("submitWishlist");

    private By alert = new By.ByClassName("alert");

    private By wishListBlock = new By.ById("block-history");

    private By closeWishListButton = new By.ById("hideSendWishlist");

    private By hideProductsButton = new By.ById("hideBoughtProducts");
    private By showProductsButton = new By.ById("showBoughtProducts");
    private By hideProductsInfosButton = new By.ById("hideBoughtProductsInfos");
    private By showProductsInfosButton = new By.ById("showBoughtProductsInfos");

    private By sendThisWishlistButton = new By.ById("showSendWishlist");

    private By wishListURL = new By.ByClassName("wishlisturl");
    private By sendWishlistFormField = new By.ByClassName("wl_send");
    private By wishlistFormGroup = new By.ByClassName("form-group");

    private By saveLinkText = new By.ByLinkText("Save");

    private By wishList = new By.ByClassName("wlp_bought_list");
    private By productName = new By.ByClassName("product-name");
    private By productImage = new By.ByClassName("product_image");

    private By removeWishListItemButton = new By.ByClassName("lnkdel");

    //General
    private By list = new By.ByTagName("li");
    private By formControl = new By.ByClassName("form-control");
    private By tableBody = new By.ByTagName("tbody");
    private By input = new By.ByTagName("input");
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


    protected static final String DEFAULT_URL = "http://automationpractice.com/index.php?fc=module&module=blockwishlist&controller=mywishlist";

    public MyWishlistsPage(WebDriver driver)
    {
        super(driver, DEFAULT_URL);
    }

    public void inputName(String string){
        driver.findElement(nameField).sendKeys(string);
    }

    public void clickSubmitWishlistButton(){
        driver.findElement(submitWishlistButton).click();
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

    public String getWishlistName(int rowIndex){
        try{
            return driver
                    .findElement(wishListBlock)
                    .findElement(tableBody)
                    .findElements(tableRow).get(rowIndex)
                    .findElements(tableData).get(0).getText();
        }catch (IndexOutOfBoundsException e){
            System.out.println("INVALID INDEX");
            return "INVALID INDEX";
        }
    }

    public void clickWishlistName(int rowIndex){
        try{
             driver
                    .findElement(wishListBlock)
                    .findElement(tableBody)
                    .findElements(tableRow).get(rowIndex)
                    .findElements(tableData).get(0)
                     .findElement(buttonLink).click();
        }catch (IndexOutOfBoundsException e){
            System.out.println("INVALID INDEX");
        }
    }

    public String getWishlistQuantity(int rowIndex){
        try{
            return driver
                    .findElement(wishListBlock)
                    .findElement(tableBody)
                    .findElements(tableRow).get(rowIndex)
                    .findElements(tableData).get(1).getText();
        }catch (IndexOutOfBoundsException e){
            System.out.println("INVALID INDEX");
            return "INVALID INDEX";
        }
    }
    public String getWishlistViewed(int rowIndex){
        try{
            return driver
                    .findElement(wishListBlock)
                    .findElement(tableBody)
                    .findElements(tableRow).get(rowIndex)
                    .findElements(tableData).get(2).getText();
        }catch (IndexOutOfBoundsException e){
            System.out.println("INVALID INDEX");
            return "INVALID INDEX";
        }
    }

    public String getWishlistCreatedDate(int rowIndex){
        try{
            return driver
                    .findElement(wishListBlock)
                    .findElement(tableBody)
                    .findElements(tableRow).get(rowIndex)
                    .findElements(tableData).get(3).getText();
        }catch (IndexOutOfBoundsException e){
            System.out.println("INVALID INDEX");
            return "INVALID INDEX";
        }
    }

    public void clickWishlistDirectLink(int rowIndex){
        try{
            driver
                    .findElement(wishListBlock)
                    .findElement(tableBody)
                    .findElements(tableRow).get(rowIndex)
                    .findElements(tableData).get(4)
                    .findElement(buttonLink).click();
        }catch (IndexOutOfBoundsException e){
            System.out.println("INVALID INDEX");
        }
    }
    public void clickWishlistDeleteButton(int rowIndex, boolean areYouSure){
        try{
            driver
                    .findElement(wishListBlock)
                    .findElement(tableBody)
                    .findElements(tableRow).get(rowIndex)
                    .findElements(tableData).get(5)
                    .findElement(buttonLink).click();

            if(areYouSure){
                driver.switchTo().alert().accept();
            }else {
                driver.switchTo().alert().dismiss();
            }

        }catch (IndexOutOfBoundsException e){
            System.out.println("INVALID INDEX");
        }
    }

    public void clickHideBoughtProductsButton(){
        try {
            driver.findElement(hideProductsButton).click();
        }catch (NoSuchElementException e){
            System.out.println("NO ELEMENT OR ELEMENT NO LOADED");
        }
    }
    public void clickShowBoughtProductsButton(){
        try {
            driver.findElement(showProductsButton).click();
        }catch (NoSuchElementException e){
            System.out.println("NO ELEMENT OR ELEMENT NO LOADED");
        }
    }

    public void clickHideBoughtProductsInfosButton(){
        try {
            driver.findElement(hideProductsInfosButton).click();
        }catch (NoSuchElementException e){
            System.out.println("NO ELEMENT OR ELEMENT NO LOADED");
        }
    }
    public void clickShowBoughtProductsInfosButton(){
        try {
            driver.findElement(showProductsInfosButton).click();
        }catch (NoSuchElementException e){
            System.out.println("NO ELEMENT OR ELEMENT NO LOADED");
        }
    }

    public String getPermalinkText(){
           return driver
                   .findElement(wishListURL)
                   .findElement(input)
                   .getAttribute("value");
    }

    public void clickSendThisWishlistButton(){
        driver.findElement(sendThisWishlistButton).click();
    }

    public void inputTextInSendWishlistForm(int index, String email){
        try {
            driver
                    .findElement(sendWishlistFormField)
                    .findElements(wishlistFormGroup).get(index)
                    .findElement(formControl).sendKeys(email);
        }
        catch (NoSuchElementException e){
            System.out.println("NO ELEMENT OR ELEMENT NO LOADED");
        }
    }

    public void clickSendWishListButton(){
        driver
                .findElement(sendWishlistFormField)
                .findElement(submitWishlistButton).click();
    }

    public void clickCloseWishlistButton(){
        driver.findElement(closeWishListButton).click();
    }

    //---------Wish list blocks--------\/

    public String getItemNameTextInWishlist(int index){
        try{
            return driver
                    .findElement(wishList)
                    .findElements(list).get(index)
                    .findElement(productName).getText();
        }catch (IndexOutOfBoundsException e){
            System.out.println("INVALID INDEX");
            return "INVALID INDEX";
        }
    }

    public int getHowManyItemsShowsInWishList(){
        try{
            return driver
                .findElement(wishList)
                .findElements(list).size();
    }catch (IndexOutOfBoundsException e){
    System.out.println("INVALID INDEX");
    return 0;
        }
    }

    public void clickImageLinkInWishList(int index){
        driver
                .findElement(wishList)
                .findElements(list).get(index)
                .findElement(productImage)
                .findElement(buttonLink).click();
    }

    public void inputQuantityInWishList(int index, String quantity){
         driver
                 .findElement(wishList)
                 .findElements(list).get(index)
                 .findElements(formControl).get(0).clear();
        driver
                .findElement(wishList)
                .findElements(list).get(index)
                .findElements(formControl).get(0).sendKeys(quantity);
    }

    public void selectPriorityInWishList(int index, int priority){                        // 0 = high, 1 = mid, 2 = low
        driver
                .findElement(wishList)
                .findElements(list).get(index)
                .findElements(formControl).get(1).click();
        driver
                .findElement(wishList)
                .findElements(list).get(index)
                .findElements(formControl).get(1)
                .findElements(options).get(priority).click();
    }

    public void clickRemoveWishListItem(int index){
        driver
                .findElement(wishList)
                .findElements(list).get(index)
                .findElement(removeWishListItemButton).click();
    }


    public void clickSaveButtonInWishListItem(int index){
        driver
                .findElement(wishList)
                .findElements(list).get(index)
                .findElement(saveLinkText).click();
    }
    
    public void clickHomeButton(){
        driver.findElement(myAccountPageFooter).findElements(buttonLink).get(homeButton).click();
    }
    public void clickBackToYourAccountButton(){
        driver.findElement(myAccountPageFooter).findElements(buttonLink).get(backToYourAccountButton).click();
    }


}

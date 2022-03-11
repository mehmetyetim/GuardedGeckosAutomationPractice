package com.guardedgeckos.automationpractice.pages;

import com.guardedgeckos.automationpractice.utilities.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class HomePage extends BasePage
{
    public static String DEFAULT_URL = "http://automationpractice.com/index.php";


    private final By numOfItemsInCart = new By.ByClassName("ajax_cart_quantity");
    private final By itemsList = new By.ByClassName("center_column");
    private final By itemsBlock = new By.ByClassName("ajax_block_product");
    private final By homePageTabs = new By.ByClassName("home-page-tabs");
    private final By bestSeller = new By.ByClassName("blockbestsellers");
    private final By popular = new By.ByClassName("homefeatured");
    private final By itemPhoto = new By.ByClassName("replace-2x");
    private final By nextArrowOnImage = new By.ByClassName("bx-next");
    private final By prevArrowOnImage = new By.ByClassName("bx-prev");
    private final By shopNowButton = By.xpath("//button[@type='button']");
    // it locates all 7 images on home page except the biggest
    private final By allImagesOnHomePageExceptTheBiggest = By.xpath("//img[@class='item-img']");
    private final By textOnFirstMovingImage = By.xpath("//a[@title='sample-1']/following-sibling::div/p[1]");
    private final By titleOnSecondMovingImage = By.xpath("//a[@title='sample-2']/following-sibling::div/h2");
    private final By movingImagesSection = By.id("homeslider");
    private final By firstMovingImage = By.xpath("(//img[@alt='sample-1'])[2]");
    private final By secondMovingImage = By.xpath("//img[@alt='sample-2']");
    private final By thirdMovingImage = By.xpath("(//img[@alt='sample-3'])[2]");
    private final By priceOnFirstProduct = By.xpath("(//span[@itemprop='price'])[1]");
    private final By firstProduct = By.xpath("(//div[@class='product-container'])[1]");
    private final By items = new By.ByClassName("product-container");
    private final By itemName = new By.ByClassName("product-name");
    private final By itemImgName = new By.ByClassName("product-image-container");
    private final By overlay = new By.ByClassName("fancybox-item");
    private final By addToCart = new By.ByCssSelector("title='Add to cart'");
    private final By proceedToCheckoutButton = By.xpath("//span[.='Proceed to checkout']");
    private final By continueShoppingButton = By.xpath("//span[@title='Continue shopping']");
    private final By addToCartButtonUnderFirstProduct = By.xpath("(//a[@data-id-product='1'])[1]/span");
    private final By movingImages = By.xpath("//li[@class='homeslider-container']");

    private final WebDriverWait wait;
    Actions action;

    public HomePage(WebDriver driver)
    {
        super(driver, DEFAULT_URL);
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        action = new Actions(driver);
    }

    public String getCurrentUrl() {
        return driver.getCurrentUrl();
    }

    public List<WebElement> getProducts() {
        return driver.findElements(items);
    }

    private String getProductName(WebElement item) {
        return item.findElement(itemName).getText();
    }
    public Boolean isOverlay(){
        if (driver.findElement(overlay)!=null){
            return true;
        }
        return false;
    }


    public void addItemToCart(Item i) {
        try{
        //System.out.println("ITEM NAME"+i.NAME);
        List<WebElement> itemList= getProducts();
        for(WebElement item:itemList){
            //System.out.println("Item List:"+getProductName(item));
            if(getProductName(item).equals(i.NAME)){
                addItem(item);
                //System.out.println("Item added to Basket");
                break;
            }
        }
        }catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    private void clickProductImage(WebElement item) {
        item.findElement(itemImgName).click();
    }
    public void quickView(Item i) {
        //System.out.println("ITEM NAME"+i.NAME);
        List<WebElement> itemList= getProducts();
        for(WebElement item:itemList){
            //System.out.println("Item List:"+getProductName(item));
            if(getProductName(item).equals(i.NAME)){
                clickProductImage(item);
                //System.out.println("Item added to Basket");
                break;
            }
        }
    }

    private void addItem(WebElement item) throws InterruptedException {
        Actions action = new Actions(driver);
        action.moveToElement(item).perform();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        action.moveToElement(item.findElement(addToCart)).click();
    }

    public void hoverOverAddToCartButtonUnderFirstProduct(){
        action.moveToElement(driver.findElement(addToCartButtonUnderFirstProduct)).perform();
    }

    public void clickOnAddToCartButtonUnderFirstProduct(){
        driver.findElement(addToCartButtonUnderFirstProduct).click();
    }

    public void hoverOverFirstProductAndClickOnAddToCartButton(){
        hoverOverFirstProduct();
        clickOnAddToCartButtonUnderFirstProduct();
    }
    public void removeItem(Item i) {
        driver.findElement(i.BY_REMOVE).click();
    }

    public void proceedToCheckout() {
        driver.findElement(By.xpath("//a[@title='Proceed to checkout']")).click();
    }

    public void continueShopping() {
        driver.findElement(By.xpath("//span[@title='Continue shopping']")).click();
    }

    public void clickOnProceedToCheckout(){
        driver.findElement(proceedToCheckoutButton).click();
    }

    public void clickOnContinueShopping(){
        driver.findElement(continueShoppingButton).click();
    }


    public void clickBestSellers(){
        try {
            driver.findElement(itemsList)
                    .findElement(homePageTabs)
                    .findElement(bestSeller)
                    .click();
        }catch (IndexOutOfBoundsException e){
            System.out.println("Unable to click");
        }
    }
    public void clickPopular(){
        try {
            driver.findElement(itemsList)
                    .findElement(homePageTabs)
                    .findElement(popular)
                    .click();
        }catch (IndexOutOfBoundsException e){
            System.out.println("Unable to click");
        }
    }

    public void clickAddToCartForProduct(int index){
        try {
            driver.findElement(itemsList)
                    .findElement(itemsBlock)
                    .findElements(itemPhoto)
                    .get(index)
                    .click();
        }catch (IndexOutOfBoundsException e){
            System.out.println("Unable to click");
        }
    }
    ////////////////////////////////////////Mehmet

    public void goToNextImage() {
        driver.findElement(nextArrowOnImage).click();
    }

    public void goToPreviousImage() {
        driver.findElement(prevArrowOnImage).click();
    }

    public boolean goToNextImageAndCheckIfTheNextImageDisplayed() {
        goToNextImage();
        return driver.findElement(secondMovingImage).isDisplayed();
    }

    public boolean isThirdMovingImageDisplayedAfterAWhile(){
        wait.until(ExpectedConditions.elementToBeClickable(thirdMovingImage));
        return driver.findElement(thirdMovingImage).isDisplayed();
    }

    public boolean isThirdMovingImageDisplayed(){
        return driver.findElement(thirdMovingImage).isDisplayed();
    }

    public boolean isPriceOnFirstProductDisplayed(){
        return driver.findElement(priceOnFirstProduct).isDisplayed();
    }

    public void hoverOverFirstProduct(){
        action.moveToElement(driver.findElement(firstProduct)).perform();
    }

    //region small7images
    public void clickOnFirstSmallImageAbove() {
        driver.findElements(allImagesOnHomePageExceptTheBiggest).get(0).click();
    }

    public String clickOnFirstSmallImageAboveAndGetUrl() {
        driver.findElements(allImagesOnHomePageExceptTheBiggest).get(0).click();
        return driver.getCurrentUrl();
    }

    public boolean isClickedOnFirstSmallImageAbove() {
        driver.findElements(allImagesOnHomePageExceptTheBiggest).get(0).click();
        return "https://www.prestashop.com/en".equals(driver.getCurrentUrl());
    }

    public boolean isFirstSmallImageAbovePresent() {
        WebElement firstImageAbove = driver.findElements(allImagesOnHomePageExceptTheBiggest).get(0);
        return (Boolean) ((JavascriptExecutor) driver).executeScript(
                "return arguments[0].complete && typeof arguments[0].naturalWidth != \"undefined\" && arguments[0].naturalWidth > 0", firstImageAbove
        );
    }

    public void clickOnSecondSmallImageAbove() {
        driver.findElements(allImagesOnHomePageExceptTheBiggest).get(1).click();
    }

    public String clickOnSecondSmallImageAboveAndGetUrl() {
        driver.findElements(allImagesOnHomePageExceptTheBiggest).get(1).click();
        return driver.getCurrentUrl();
    }

    public boolean isClickedOnSecondSmallImageAbove() {
        driver.findElements(allImagesOnHomePageExceptTheBiggest).get(1).click();
        return "https://www.prestashop.com/en".equals(driver.getCurrentUrl());
    }

    public boolean isSecondSmallImageAbovePresent() {
        WebElement secondImageAbove = driver.findElements(allImagesOnHomePageExceptTheBiggest).get(1);
        return (Boolean) ((JavascriptExecutor) driver).executeScript(
                "return arguments[0].complete && typeof arguments[0].naturalWidth != \"undefined\" && arguments[0].naturalWidth > 0", secondImageAbove
        );
    }

    public void clickOnFirstSmallImageBelow() {
        driver.findElements(allImagesOnHomePageExceptTheBiggest).get(2).click();
    }

    public void clickOnFirstSmallImageBelowAndGetUrl() {
        driver.findElements(allImagesOnHomePageExceptTheBiggest).get(2).click();
    }

    public boolean isClickedOnFirstSmallImageBelow() {
        driver.findElements(allImagesOnHomePageExceptTheBiggest).get(2).click();
        return "https://www.prestashop.com/en".equals(driver.getCurrentUrl());
    }

    public boolean isFirstSmallImageBelowPresent() {
        WebElement firstImageBelow = driver.findElements(allImagesOnHomePageExceptTheBiggest).get(2);
        return (Boolean) ((JavascriptExecutor) driver).executeScript(
                "return arguments[0].complete && typeof arguments[0].naturalWidth != \"undefined\" && arguments[0].naturalWidth > 0", firstImageBelow
        );
    }

    public void clickOnSecondSmallImageBelow() {
        driver.findElements(allImagesOnHomePageExceptTheBiggest).get(3).click();
    }

    public void clickOnSecondSmallImageBelowAndGetUrl() {
        driver.findElements(allImagesOnHomePageExceptTheBiggest).get(3).click();
    }

    public boolean isClickedOnSecondSmallImageBelow() {
        driver.findElements(allImagesOnHomePageExceptTheBiggest).get(3).click();
        return "https://www.prestashop.com/en".equals(driver.getCurrentUrl());
    }

    public boolean isSecondSmallImageBelowPresent() {
        WebElement secondImageBelow = driver.findElements(allImagesOnHomePageExceptTheBiggest).get(3);
        return (Boolean) ((JavascriptExecutor) driver).executeScript(
                "return arguments[0].complete && typeof arguments[0].naturalWidth != \"undefined\" && arguments[0].naturalWidth > 0", secondImageBelow
        );
    }

    public void clickOnThirdSmallImageBelow() {
        driver.findElements(allImagesOnHomePageExceptTheBiggest).get(4).click();
    }

    public void clickOnThirdSmallImageBelowAndGetUrl() {
        driver.findElements(allImagesOnHomePageExceptTheBiggest).get(4).click();
    }

    public boolean isClickedOnThirdSmallImageBelow() {
        driver.findElements(allImagesOnHomePageExceptTheBiggest).get(4).click();
        return "https://www.prestashop.com/en".equals(driver.getCurrentUrl());
    }

    public boolean isThirdSmallImageBelowPresent() {
        WebElement thirdImageBelow = driver.findElements(allImagesOnHomePageExceptTheBiggest).get(4);
        return (Boolean) ((JavascriptExecutor) driver).executeScript(
                "return arguments[0].complete && typeof arguments[0].naturalWidth != \"undefined\" && arguments[0].naturalWidth > 0", thirdImageBelow
        );
    }

    public void clickOnFourthSmallImageBelow() {
        driver.findElements(allImagesOnHomePageExceptTheBiggest).get(5).click();
    }

    public void clickOnFourthSmallImageBelowAndGetUrl() {
        driver.findElements(allImagesOnHomePageExceptTheBiggest).get(5).click();
    }

    public boolean isClickedOnFourthSmallImageBelow() {
        driver.findElements(allImagesOnHomePageExceptTheBiggest).get(5).click();
        return "https://www.prestashop.com/en".equals(driver.getCurrentUrl());
    }

    public boolean isFourthSmallImageBelowPresent() {
        WebElement fourthImageBelow = driver.findElements(allImagesOnHomePageExceptTheBiggest).get(5);
        return (Boolean) ((JavascriptExecutor) driver).executeScript(
                "return arguments[0].complete && typeof arguments[0].naturalWidth != \"undefined\" && arguments[0].naturalWidth > 0", fourthImageBelow
        );
    }

    public void clickOnFifthSmallImageBelow() {
        driver.findElements(allImagesOnHomePageExceptTheBiggest).get(6).click();
    }

    public void clickOnFifthSmallImageBelowAndGetUrl() {
        driver.findElements(allImagesOnHomePageExceptTheBiggest).get(6).click();
    }

    public boolean isClickedOnFifthSmallImageBelow() {
        driver.findElements(allImagesOnHomePageExceptTheBiggest).get(6).click();
        return "https://www.prestashop.com/en".equals(driver.getCurrentUrl());
    }

    public boolean isFifthSmallImageBelowPresent() {
        WebElement fifthImageBelow = driver.findElements(allImagesOnHomePageExceptTheBiggest).get(6);
        return (Boolean) ((JavascriptExecutor) driver).executeScript(
                "return arguments[0].complete && typeof arguments[0].naturalWidth != \"undefined\" && arguments[0].naturalWidth > 0", fifthImageBelow
        );
    }

    // endregion

    public boolean areAllImagesExceptTheBiggestPresent() {
        List<WebElement> images = driver.findElements(allImagesOnHomePageExceptTheBiggest);
        Boolean imagesPresent;
        for (WebElement image : images) {
            imagesPresent = (Boolean) ((JavascriptExecutor) driver).executeScript(
                    "return arguments[0].complete && typeof arguments[0].naturalWidth != \"undefined\" && arguments[0].naturalWidth > 0", image
            );
            if (!imagesPresent) {
                return false;
            }
        }
        return true;
    }

    // imageInOrder: can be any value of 1, 2
    // it is only passing for 1 now. still in progress

    public String getTextOnImage(int imageInOrder) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//a[@title='sample-\" + imageInOrder + \"']/following-sibling::div/p[1])[1]")));
        return driver.findElement(By.xpath("(//a[@title='sample-\" + imageInOrder + \"']/following-sibling::div/p[1])[1]")).getText();
    }

    // imageInOrder: can be any value of 1, 2
    // it is only passing for 1 now. still in progress

    public boolean isTextOnImageCorrect(int imageInOrder) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//a[@title='sample-\" + imageInOrder + \"']/following-sibling::div/p[1])[1]")));
        return driver.findElement(By.xpath("(//a[@title='sample-" + imageInOrder + "']/following-sibling::div/p[1])[1]"))
                .getText().equals("Lorem ipsum dolor sit amet, consectetur adipiscing elit. Proin tristique in tortor et dignissim. Quisque non tempor leo. Maecenas egestas sem elit");
    }

    // imageInOrder: can be any value of 1, 2, 3
    // it is only passing for 1, 2 now. still in progress

    public String getTitleOnImage(int imageInOrder) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//a[@title='sample-" + imageInOrder + "']/following-sibling::div/h2)[1]")));
        return driver.findElement(By.xpath("(//a[@title='sample-" + imageInOrder + "']/following-sibling::div/h2)[1]")).getText();
    }

    // imageInOrder: can be any value of 1, 2, 3
    // it is only passing for 1, 2 now. still in progress

    public boolean isTitleOnImageCorrect(int imageInOrder) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//a[@title='sample-" + imageInOrder + "']/following-sibling::div/h2)[1]")));
        return driver.findElement(By.xpath("(//a[@title='sample-" + imageInOrder + "']/following-sibling::div/h2)[1]"))
                .getText().equals("EXCEPTEUR\nOCCAECAT");
    }

    public boolean isNumberOfSmallImages7(){
        return driver.findElements(allImagesOnHomePageExceptTheBiggest).size() == 7;
    }

    public void clickOnFirstMovingImage(){
        wait.until(ExpectedConditions.elementToBeClickable(driver.findElements(movingImages)
                .get(0)));
        driver.findElements(movingImages).get(0).click();
    }

    public String clickOnFirstMovingImageAndGetUrl(){
        wait.until(ExpectedConditions.elementToBeClickable(driver.findElements(movingImages)
                .get(0)));
        driver.findElements(movingImages).get(1).click();
        return driver.getCurrentUrl();
    }

    public void clickOnSecondMovingImage(){
        wait.until(ExpectedConditions.elementToBeClickable(driver.findElements(movingImages).get(1)));
        driver.findElements(movingImages).get(1).click();
    }

    public String clickOnSecondMovingImageAndGetUrl(){
        wait.until(ExpectedConditions.elementToBeClickable(driver.findElements(movingImages).get(1)));
        driver.findElements(movingImages).get(1).click();
        return driver.getCurrentUrl();
    }

    public void clickOnThirdMovingImage(){
        wait.until(ExpectedConditions.elementToBeClickable(driver.findElements(movingImages).get(2)));
        driver.findElements(movingImages).get(2).click();
    }

    public String clickOnThirdMovingImageAndGetUrl(){
        wait.until(ExpectedConditions.elementToBeClickable(driver.findElements(movingImages).get(2)));
        driver.findElements(movingImages).get(2).click();
        return driver.getCurrentUrl();
    }
}
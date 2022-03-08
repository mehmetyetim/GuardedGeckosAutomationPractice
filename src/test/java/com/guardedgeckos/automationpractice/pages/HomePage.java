package com.guardedgeckos.automationpractice.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class HomePage extends BasePage {

    protected static final String DEFAULT_URL = "http://automationpractice.com/";

    private final By nextArrowOnImage = By.className("bx-next");
    private final By prevArrowOnImage = By.className("bx-prev");
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

    private final WebDriverWait wait;
    Actions action;

    public HomePage(WebDriver driver) {
        super(driver, DEFAULT_URL);
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        action = new Actions(driver);
    }

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

}
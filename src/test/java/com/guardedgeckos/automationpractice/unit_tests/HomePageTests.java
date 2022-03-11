package com.guardedgeckos.automationpractice.unit_tests;

import com.guardedgeckos.automationpractice.pages.HomePage;
import com.guardedgeckos.automationpractice.pages.Item;
import com.guardedgeckos.automationpractice.utilities.DriverFactory;
import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;
import org.openqa.selenium.WebDriver;

public class HomePageTests {
    private static WebDriver driver = DriverFactory.get();
    static HomePage homePage;
    WebDriverWait wait;
    @BeforeAll
    static void setupAll(TestInfo testInfo) {
        homePage = new HomePage(driver);
        driver.get("http://automationpractice.com/");
    }
    @BeforeEach
    public void setup(){
        DriverFactory.get().manage().window().maximize();
        DriverFactory.get().get("https://automationpractice.com/");
        DriverFactory.get().manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        wait = new WebDriverWait(DriverFactory.get(), Duration.ofSeconds(30));
    }

    @Test
    @DisplayName("Check that the page defaults to the base url")
    void homePageConstructorTest()
    {
        Assertions.assertEquals(HomePage.DEFAULT_URL, driver.getCurrentUrl());
    }

    @Test
    public void clickAddToCart() {
        homePage.hoverOverFirstProductAndClickOnAddToCartButton();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("ajax_cart_quantity")));
        System.out.println("homePage.getTotalItemsQuantityCart() = " + homePage.getTotalItemsQuantityCart());
        Assertions.assertTrue(homePage.getTotalItemsQuantityCart().equals("1"));
    }

//    @Test
//    @DisplayName("Add item to Cart")
//    void AddItemToCart() {
//        homePage.addItemToCart(Item.FADED_SHORT_SLEEVE_);
//        //not clicking
//        wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("ajax_cart_quantity")));
//        System.out.println("homePage.getTotalItemsQuantityCart() = " + homePage.getTotalItemsQuantityCart());
//        Assertions.assertTrue(homePage.getTotalItemsQuantityCart().equals("1"));
//    }
    @Test
    @DisplayName("Clicks on the image view")
    void hoverImage() throws InterruptedException {
        homePage.quickView(Item.FADED_SHORT_SLEEVE_);
        Thread.sleep(5);
        Assertions.assertTrue(homePage.isOverlay());
        }


    ////////////////////////////////////////////////////////////////////////////////////////////

    @Test
    @DisplayName("Click on first image")
    public void clickOnFirstImage(){
        homePage.clickOnFirstSmallImageAbove();
        Assertions.assertEquals("https://www.prestashop.com/en", DriverFactory.get().getCurrentUrl());
    }

    @Test
    @DisplayName("Click on first image and get url")
    public void clickOnFirstImageAndGetUrl(){
        String actualUrl = homePage.clickOnFirstSmallImageAboveAndGetUrl();
        Assertions.assertEquals("https://www.prestashop.com/en",actualUrl);
    }

    @Test
    @DisplayName("Check if first image is clicked")
    public void checkIfFirstImageIsClicked(){
        Assertions.assertTrue(homePage.isClickedOnFirstSmallImageAbove());
    }

    @Test
    @DisplayName("Check if first image is present")
    public void checkIfFirstImageIsPresent(){
        Assertions.assertTrue(homePage.isFirstSmallImageAbovePresent());
    }

    @Test
    @DisplayName("Check if there are 7 images")
    public void checkIfThereAre7Images(){
        Assertions.assertTrue(homePage.isNumberOfSmallImages7());
    }

    @Test
    @DisplayName("Check if all small images are present")
    public void checkIfAllSmallImagesArePresent(){
        Assertions.assertTrue(homePage.areAllImagesExceptTheBiggestPresent());
    }

    @Test
    @DisplayName("Check text on the image 1 is correct")
    public void checkTextOnTheImage1IsCorrect(){
        Assertions.assertTrue(homePage.isTextOnImageCorrect(1));
    }

    @Test
    @DisplayName("Check text on the image 2 is correct")
    public void checkTextOnTheImage2IsCorrect(){
        Assertions.assertTrue(homePage.isTextOnImageCorrect(2));
    }

    @Test
    @DisplayName("Check title on the image 1 is correct")
    public void checkTitleOnTheImage1IsCorrect(){
        Assertions.assertTrue(homePage.isTitleOnImageCorrect(1));
    }

    @Test
    @DisplayName("Check title on the image 3 is correct")
    public void checkTitleOnTheImage3IsCorrect(){
        Assertions.assertTrue(homePage.isTitleOnImageCorrect(3));
    }

    @Test
    @DisplayName("Check title on the image 2 is correct")
    public void checkTitleOnTheImage2IsCorrect(){
        Assertions.assertTrue(homePage.isTitleOnImageCorrect(2));
    }

    @Test
    @DisplayName("Go to next image clicking on right arrow button and asserting first image not present")
    public void goToNextImageClickingOnRightArrowButtonAndAssertingFirstImageNotPresent() {
        Assertions.assertTrue(homePage.goToNextImageAndCheckIfTheNextImageDisplayed());
    }

    @Test
    @DisplayName("Check if price on first product displayed")
    public void checkIfPriceOnFirstProductDisplayed(){
        Assertions.assertFalse(homePage.isPriceOnFirstProductDisplayed());
    }

    @Test
    @DisplayName("Check if price on first product displayed when you hover over it")
    public void checkIfPriceOnFirstProductDisplayedWhenYouHoverOverIt(){
        homePage.hoverOverFirstProduct();
        Assertions.assertTrue(homePage.isPriceOnFirstProductDisplayed());
    }

    @Test
    @DisplayName("Check if third moving image is not displayed")
    public void checkIfThirdMovingImageIsNotDisplayed(){
        Assertions.assertFalse(homePage.isThirdMovingImageDisplayed());
    }

    @Test
    @DisplayName("Check images are moving and the third is displayed")
    public void checkImagesAreMovingAndTheThirdIsDisplayed(){
        Assertions.assertTrue(homePage.isThirdMovingImageDisplayedAfterAWhile());
    }

    @AfterEach
    public void tearDown() {
        //DriverFactory.closeDriver();
    }

    @AfterAll
    static void close(){
       driver.quit();
    }

}

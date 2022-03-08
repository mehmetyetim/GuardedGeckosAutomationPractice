package com.guardedgeckos.automationpractice.unit_tests;

import com.guardedgeckos.automationpractice.pages.HomePage;
import com.guardedgeckos.automationpractice.utilities.DriverFactory;
import org.junit.jupiter.api.*;

import java.time.Duration;

public class HomeTests {

    HomePage homePage = new HomePage(DriverFactory.get());

    @BeforeEach
    public void setup(){
        DriverFactory.get().manage().window().maximize();
        DriverFactory.get().get("https://automationpractice.com/");
        DriverFactory.get().manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

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

    @AfterEach
    public void tearDown() {
        DriverFactory.closeDriver();
    }
}

package com.guardedgeckos.automationpractice.unit_tests;

import com.guardedgeckos.automationpractice.pages.IHopeYouGuysAreHappy;
import com.guardedgeckos.automationpractice.pages.MyAccountPage;
import com.guardedgeckos.automationpractice.utilities.DriverFactory;
import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePageTests {
    private static WebDriver driver = DriverFactory.get();
    static IHopeYouGuysAreHappy home;

    @BeforeAll
    static void setupAll(TestInfo testInfo)
    {
        home = new IHopeYouGuysAreHappy(driver);
        driver.get("http://automationpractice.com/");
    }

    @Test
    @DisplayName("Check that the page defaults to the base url")
    void homePageConstructorTest()
    {
        Assertions.assertEquals(IHopeYouGuysAreHappy.DEFAULT_URL, driver.getCurrentUrl());
    }
    @Test
    @DisplayName("Check that the page defaults to the base url")
    void continueShopping(){
        home.continueShopping();
        Assertions.assertEquals(home.getDefaultUrl() , driver.getCurrentUrl());
        home.continueShopping();
    }
    @AfterAll
    static void close(){
        driver.quit();
    }
}

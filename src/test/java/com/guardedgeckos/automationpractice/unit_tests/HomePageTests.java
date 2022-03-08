package com.guardedgeckos.automationpractice.unit_tests;

import com.guardedgeckos.automationpractice.pages.IHopeYouGuysAreHappy;
import com.guardedgeckos.automationpractice.utilities.DriverFactory;
import org.junit.jupiter.api.*;
import org.openqa.selenium.WebDriver;

public class HomePageTests {
    private static WebDriver driver = DriverFactory.get();
    static IHopeYouGuysAreHappy home;

    @BeforeAll
    static void setupAll(TestInfo testInfo)
    {
        driver = DriverFactory.get();
        home = new IHopeYouGuysAreHappy(driver);
    }

    @Test
    @DisplayName("Check that the page defaults to the base url")
    void signInPageConstructorTest()
    {
        Assertions.assertEquals(home.getDefaultUrl(), driver.getCurrentUrl());
    }
}

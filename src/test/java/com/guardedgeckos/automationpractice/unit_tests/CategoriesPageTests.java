package com.guardedgeckos.automationpractice.unit_tests;

import com.guardedgeckos.automationpractice.pages.CategoriesPage;
import com.guardedgeckos.automationpractice.pages.SignInPage;
import com.guardedgeckos.automationpractice.utilities.DriverFactory;
import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class CategoriesPageTests {
    static WebDriver driver;
    static CategoriesPage categoriesPage;
    static WebDriverWait wait;
    @BeforeAll
    static void setupAll(TestInfo testInfo)
    {
        driver = DriverFactory.get();
        driver.manage().window().maximize();
        categoriesPage = new CategoriesPage(driver);
        wait = new WebDriverWait(driver,Duration.ofSeconds(30));
    }

    @Test
    @DisplayName("Check small size checkbox")
    public void checkSmallSizeCheckbox(){
        driver.get(categoriesPage.getDefaultUrl());
        driver.findElement(By.xpath("(//*[@id='block_top_menu']/ul/li/a)[1]")).click();
        wait.until(ExpectedConditions.urlToBe("http://automationpractice.com/index.php?id_category=3&controller=category"));
        categoriesPage.checkSmallSize();
        Assertions.assertTrue(categoriesPage.getSmallSizeCheckbox().isSelected());
    }

    @AfterAll
    static void tearDownAll()
    {
        driver.close();
        driver.quit();
    }
}

package com.guardedgeckos.automationpractice.unit_tests;

import com.guardedgeckos.automationpractice.pages.*;
import com.guardedgeckos.automationpractice.utilities.DriverFactory;
import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


public class MyAccountPageTest {

    private static WebDriver webDriver = webDriver = DriverFactory.get();
    MyAccountPage myAccountPage;
    OrderHistoryPage orderHistoryPage;
    OrderSlipPage orderSlipPage;
    AddressesPage addressesPage;
    AddressPage addressPage;
    MyWishlistsPage myWishlistsPage;
    IdentityPage identityPage;

@BeforeAll
    public static void setUp(){
        webDriver.get("http://automationpractice.com/");
        webDriver.findElement(By.className("login")).click();
        webDriver.findElement(By.id("email")).sendKeys("vzelohgcpdzokhclvd@bvhrk.com");
        webDriver.findElement(By.id("passwd")).sendKeys("password");
        webDriver.findElement(By.id("SubmitLogin")).click();
    }

    @Test
    @DisplayName("Check order history buttons in the myAccountPage")
    public void checkOrderHistoryButtonInMyAccountPage(){
        MyAccountPage myAccountPage = new MyAccountPage(webDriver);
        myAccountPage.clickOrderHistoryAndDetailsButton();
        orderHistoryPage = new OrderHistoryPage(webDriver);
        Assertions.assertEquals("http://automationpractice.com/index.php?controller=history", orderHistoryPage.getCurrentUrl());
    }

    @Test
    @DisplayName("Check credit slips buttons in the myAccountPage")
    public void checkCreditSlipsButtonInMyAccountPage(){
        MyAccountPage myAccountPage = new MyAccountPage(webDriver);
        myAccountPage.clickMyCreditSlipsButton();
        orderSlipPage = new OrderSlipPage(webDriver);
        Assertions.assertEquals("http://automationpractice.com/index.php?controller=order-slip", orderSlipPage.getCurrentUrl());
    }
    @Test
    @DisplayName("Check my addresses buttons in the myAccountPage")
    public void checkMyAddressesButtonInMyAccountPage(){
        MyAccountPage myAccountPage = new MyAccountPage(webDriver);
        myAccountPage.clickMyAddressesButton();
        addressesPage = new AddressesPage(webDriver);
        Assertions.assertEquals("http://automationpractice.com/index.php?controller=addresses", addressesPage.getCurrentUrl());
    }
    @Test
    @DisplayName("Check my personal information buttons in the myAccountPage")
    public void checkMyPersonalInformationButtonInMyAccountPage(){
        MyAccountPage myAccountPage = new MyAccountPage(webDriver);
        myAccountPage.clickMyPersonalInformationButton();
        identityPage = new IdentityPage(webDriver);
        Assertions.assertEquals("http://automationpractice.com/index.php?controller=identity", identityPage.getCurrentUrl());
    }
    @Test
    @DisplayName("Check wishlists buttons in the myAccountPage")
    public void checkWhishlistButtonInMyAccountPage(){
        MyAccountPage myAccountPage = new MyAccountPage(webDriver);
        myAccountPage.clickMyWishlistsButton();
        myWishlistsPage = new MyWishlistsPage(webDriver);
        Assertions.assertEquals("http://automationpractice.com/index.php?fc=module&module=blockwishlist&controller=mywishlist", myWishlistsPage.getCurrentUrl());
    }

}

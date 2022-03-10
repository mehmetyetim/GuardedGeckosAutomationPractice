package com.guardedgeckos.automationpractice.unit_tests;

import com.guardedgeckos.automationpractice.pages.SignInPage;
import com.guardedgeckos.automationpractice.pages.cart.myaccount.*;
import com.guardedgeckos.automationpractice.utilities.DriverFactory;
import org.junit.jupiter.api.*;
import org.openqa.selenium.WebDriver;

import java.sql.Driver;


public class MyAccountPageTest {

    private static WebDriver webDriver = DriverFactory.get();
    static MyAccountPage myAccountPage;
    static OrderHistoryPage orderHistoryPage;
    static OrderSlipPage orderSlipPage;
    static AddressesPage addressesPage;
    static AddressPage addressPage;
    static MyWishlistsPage myWishlistsPage;
    static IdentityPage identityPage;
    static SignInPage signInPage;

    @BeforeAll
    public static void setUp(){
    webDriver = DriverFactory.get();
    signInPage = new SignInPage(webDriver);
    signInPage.enterEmail("vzelohgcpdzokhclvd@bvhrk.com");
    signInPage.enterPassword("password");
    signInPage.clickSignInButton();
    }

    @Test
    @DisplayName("Check order history buttons in the myAccountPage")
    public void checkOrderHistoryButtonInMyAccountPage(){
        myAccountPage = new MyAccountPage(webDriver);
        myAccountPage.clickOrderHistoryAndDetailsButton();
        orderHistoryPage = new OrderHistoryPage(webDriver);
        Assertions.assertEquals("http://automationpractice.com/index.php?controller=history", webDriver.getCurrentUrl());
    }

    @Test
    @DisplayName("Check credit slips buttons in the myAccountPage")
    public void checkCreditSlipsButtonInMyAccountPage(){
        myAccountPage = new MyAccountPage(webDriver);
        myAccountPage.clickMyCreditSlipsButton();
        orderSlipPage = new OrderSlipPage(webDriver);
        Assertions.assertEquals("http://automationpractice.com/index.php?controller=order-slip", webDriver.getCurrentUrl());
    }
    @Test
    @DisplayName("Check my addresses buttons in the myAccountPage")
    public void checkMyAddressesButtonInMyAccountPage(){
        myAccountPage = new MyAccountPage(webDriver);
        myAccountPage.clickMyAddressesButton();
        addressesPage = new AddressesPage(webDriver);
        Assertions.assertEquals("http://automationpractice.com/index.php?controller=addresses", webDriver.getCurrentUrl());
    }
    @Test
    @DisplayName("Check my personal information buttons in the myAccountPage")
    public void checkMyPersonalInformationButtonInMyAccountPage(){
        myAccountPage = new MyAccountPage(webDriver);
        myAccountPage.clickMyPersonalInformationButton();
        identityPage = new IdentityPage(webDriver);
        Assertions.assertEquals("http://automationpractice.com/index.php?controller=identity", webDriver.getCurrentUrl());
    }
    @Test
    @DisplayName("Check wishlists buttons in the myAccountPage")
    public void checkWhishlistButtonInMyAccountPage(){
        myAccountPage = new MyAccountPage(webDriver);
        myAccountPage.clickMyWishlistsButton();
        myWishlistsPage = new MyWishlistsPage(webDriver);
        Assertions.assertEquals("http://automationpractice.com/index.php?fc=module&module=blockwishlist&controller=mywishlist", webDriver.getCurrentUrl());
    }

    @Test
    @DisplayName("Click home button back to home page")
    public void clickHomeButtonBackToHomePage(){
        myAccountPage =  new MyAccountPage(webDriver);
        myAccountPage.clickHomeButton();
        Assertions.assertEquals("http://automationpractice.com/index.php",webDriver.getCurrentUrl());
    }

    @AfterAll
    static void close(){
    webDriver.quit();
    }

}

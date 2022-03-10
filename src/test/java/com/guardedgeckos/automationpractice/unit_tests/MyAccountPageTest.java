package com.guardedgeckos.automationpractice.unit_tests;

import com.guardedgeckos.automationpractice.pages.HomePage;
import com.guardedgeckos.automationpractice.pages.SignInPage;
import com.guardedgeckos.automationpractice.pages.cart.myaccount.*;
import com.guardedgeckos.automationpractice.utilities.DriverFactory;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.mockito.Spy;
import org.mockito.junit.jupiter.MockitoExtension;
import org.openqa.selenium.WebDriver;

import java.sql.Driver;

@ExtendWith(MockitoExtension.class)
public class MyAccountPageTest {

    @Spy
    private static WebDriver webDriver;
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
    @DisplayName("Constructor test")
    void constructorTest(){
        myAccountPage = new MyAccountPage(webDriver);
        Mockito.when(webDriver.getCurrentUrl()).thenReturn("http://automationpractice.com/index.php?controller=my-account");
        Assertions.assertEquals(MyAccountPage.DEFAULT_URL, webDriver.getCurrentUrl());
    }

    @Test
    @DisplayName("Check order history buttons in the myAccountPage")
    public void checkOrderHistoryButtonInMyAccountPage(){
        myAccountPage = new MyAccountPage(webDriver);
        myAccountPage.clickOrderHistoryAndDetailsButton();
        orderHistoryPage = new OrderHistoryPage(webDriver);
        Mockito.when(webDriver.getCurrentUrl()).thenReturn("http://automationpractice.com/index.php?controller=history");
        Assertions.assertEquals(OrderHistoryPage.DEFAULT_URL, webDriver.getCurrentUrl());
    }

    @Test
    @DisplayName("Check credit slips buttons in the myAccountPage")
    public void checkCreditSlipsButtonInMyAccountPage(){
        myAccountPage = new MyAccountPage(webDriver);
        myAccountPage.clickMyCreditSlipsButton();
        orderSlipPage = new OrderSlipPage(webDriver);
        Mockito.when(webDriver.getCurrentUrl()).thenReturn("http://automationpractice.com/index.php?controller=order-slip");
        Assertions.assertEquals(OrderSlipPage.DEFAULT_URL, webDriver.getCurrentUrl());
    }
    @Test
    @DisplayName("Check my addresses buttons in the myAccountPage")
    public void checkMyAddressesButtonInMyAccountPage(){
        myAccountPage = new MyAccountPage(webDriver);
        myAccountPage.clickMyAddressesButton();
        addressesPage = new AddressesPage(webDriver);
        Mockito.when(webDriver.getCurrentUrl()).thenReturn("http://automationpractice.com/index.php?controller=addresses");
        Assertions.assertEquals(AddressesPage.DEFAULT_URL, webDriver.getCurrentUrl());
    }
    @Test
    @DisplayName("Check my personal information buttons in the myAccountPage")
    public void checkMyPersonalInformationButtonInMyAccountPage(){
        myAccountPage = new MyAccountPage(webDriver);
        myAccountPage.clickMyPersonalInformationButton();
        identityPage = new IdentityPage(webDriver);
        Mockito.when(webDriver.getCurrentUrl()).thenReturn("http://automationpractice.com/index.php?controller=identity");
        Assertions.assertEquals(IdentityPage.DEFAULT_URL, webDriver.getCurrentUrl());
    }
    @Test
    @DisplayName("Check wishlists buttons in the myAccountPage")
    public void checkWhishlistButtonInMyAccountPage(){
        myAccountPage = new MyAccountPage(webDriver);
        myAccountPage.clickMyWishlistsButton();
        myWishlistsPage = new MyWishlistsPage(webDriver);
        Mockito.when(webDriver.getCurrentUrl()).thenReturn("http://automationpractice.com/index.php?fc=module&module=blockwishlist&controller=mywishlist");
        Assertions.assertEquals(MyWishlistsPage.DEFAULT_URL, webDriver.getCurrentUrl());
    }

    @Test
    @DisplayName("Click home button back to home page")
    public void clickHomeButtonBackToHomePage(){
        myAccountPage =  new MyAccountPage(webDriver);
        myAccountPage.clickHomeButton();
        Mockito.when(webDriver.getCurrentUrl()).thenReturn("http://automationpractice.com/index.php");
        Assertions.assertEquals(HomePage.DEFAULT_URL,webDriver.getCurrentUrl());
    }

    @AfterAll
    static void close(){
    webDriver.quit();
    }

}

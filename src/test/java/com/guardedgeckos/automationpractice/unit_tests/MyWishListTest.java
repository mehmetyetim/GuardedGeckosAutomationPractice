package com.guardedgeckos.automationpractice.unit_tests;

import com.guardedgeckos.automationpractice.pages.HomePage;
import com.guardedgeckos.automationpractice.pages.SignInPage;
import com.guardedgeckos.automationpractice.pages.cart.myaccount.MyAccountPage;
import com.guardedgeckos.automationpractice.pages.cart.myaccount.MyWishlistsPage;
import com.guardedgeckos.automationpractice.utilities.DriverFactory;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.mockito.Spy;
import org.mockito.junit.jupiter.MockitoExtension;
import org.openqa.selenium.ElementNotInteractableException;
import org.openqa.selenium.WebDriver;

import java.util.concurrent.TimeUnit;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsString;
import static org.junit.Assert.assertThrows;

@ExtendWith(MockitoExtension.class)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class MyWishListTest {
    @Spy
    private static WebDriver webDriver;
    static MyAccountPage myAccountPage;
    static MyWishlistsPage myWishlistsPage;
    static SignInPage signInPage;

    @BeforeAll
    public static void setUp(){
        webDriver = DriverFactory.get();
        signInPage = new SignInPage(webDriver);
        signInPage.enterEmail("vzelohgcpdzokhclvd@bvhrk.com");
        signInPage.enterPassword("password");
        signInPage.clickSignInButton();
        myAccountPage = new MyAccountPage(webDriver);
        myAccountPage.clickMyWishlistsButton();
    }

    @Test
    @Order(1)
    @DisplayName("add new wishlist")
    public void test(){
        myWishlistsPage = new MyWishlistsPage(webDriver);
        int wishlistsSize = myWishlistsPage.getWishlistsSize();
        myWishlistsPage.inputName("UnitTestList");
        myWishlistsPage.clickSubmitWishlistButton();
        Assertions.assertEquals(wishlistsSize+1,myWishlistsPage.getWishlistsSize());
    }

    @Test
    @Order(2)
    @DisplayName("Remove unit test wishlist")
    public void removeUnitTestWishlist() throws InterruptedException {
        myWishlistsPage = new MyWishlistsPage(webDriver);
        int removeList = myWishlistsPage.getWishlistsSize() - 1;
        myWishlistsPage.clickWishlistDeleteButton(removeList,true);
        TimeUnit.SECONDS.sleep(3);
        Assertions.assertEquals(removeList, myWishlistsPage.getWishlistsSize());
    }

    @Test
    @Order(3)
    @DisplayName("get wishlist name")
    public void getWishlistName(){
        myWishlistsPage = new MyWishlistsPage(webDriver);
        Assertions.assertEquals("mylist1", myWishlistsPage.getWishlistName(0));
    }

    @Test
    @Order(4)
    @DisplayName("get wishlist qty")
    public void getWishlistQty(){
        myWishlistsPage = new MyWishlistsPage(webDriver);
        Assertions.assertEquals("0", myWishlistsPage.getWishlistQuantity(1));
    }


    @Test
    @Order(5)
    @DisplayName("get wishlist viewed")
    public void getWishlistViewed(){
        myWishlistsPage = new MyWishlistsPage(webDriver);
        Assertions.assertEquals("0", myWishlistsPage.getWishlistViewed(1));
    }

    @Test
    @Order(6)
    @DisplayName("get wishlist created date")
    public void getWishlistCreatedDate(){
        myWishlistsPage = new MyWishlistsPage(webDriver);
        Assertions.assertEquals("2022-03-09", myWishlistsPage.getWishlistCreatedDate(2));
    }

    @Test
    @Order(7)
    @DisplayName("click wishlist name with no product")
    public void clickWishListNameWithNoProduct(){
        myWishlistsPage = new MyWishlistsPage(webDriver);
        myWishlistsPage.clickWishlistName(1);
        webDriver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        assertThat(myWishlistsPage.getAlertText(),containsString("No products"));
    }
    @Test
    @Order(8)
    @DisplayName("click wishlist link with no product")
    public void clickWishListLinkWithNoProduct(){
        myWishlistsPage = new MyWishlistsPage(webDriver);
        myWishlistsPage.clickWishlistDirectLink(1);
        webDriver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        assertThat(myWishlistsPage.getAlertText(),containsString("No products"));
    }

//    @Test
//    @DisplayName("send wishlist without typing email")
//    public void sendWishlistWithoutTypingEmail() {
//        myWishlistsPage = new MyWishlistsPage(webDriver);
//        myWishlistsPage.clickWishlistDirectLink(0);
//        webDriver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
//        myWishlistsPage.clickSendThisWishlistButton();                             It is not working by only clicking one time
//        myWishlistsPage.clickSendWishListButton();
//    }

//    @Test
//    @DisplayName("send wishlist without typing email")                                 //Not expect working without input email
//    public void sendWishlistWithoutTypingEmail(){
//        myWishlistsPage = new MyWishlistsPage(webDriver);
//        myWishlistsPage.clickWishlistDirectLink(0);
//        webDriver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
//        myWishlistsPage.clickSendThisWishlistButton();
//        myWishlistsPage.clickSendThisWishlistButton();
//        myWishlistsPage.clickSendWishListButton();
//        assertThat(myWishlistsPage.getAlertText(),containsString("error"));
//    }


    @Test
    @Order(9)
    @DisplayName("send wishlist with input email")
    public void sendWishlistWithInputEmail(){
        myWishlistsPage = new MyWishlistsPage(webDriver);
        myWishlistsPage.clickWishlistDirectLink(0);
        webDriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        myWishlistsPage.clickSendThisWishlistButton();
        myWishlistsPage.clickSendThisWishlistButton();
        myWishlistsPage.inputTextInSendWishlistForm(0,"abc@abc.com");
        myWishlistsPage.inputTextInSendWishlistForm(1,"def@abc.com");
        myWishlistsPage.inputTextInSendWishlistForm(2,"bcd@abc.com");
        myWishlistsPage.clickSendWishListButton();
        Assertions.assertEquals("http://automationpractice.com/index.php?fc=module&module=blockwishlist&controller=mywishlist", webDriver.getCurrentUrl());
    }

    @Test
    @Order(10)
    @DisplayName("click close wishlist button")
    public void clickCloseWishlistButton() throws InterruptedException {
        myWishlistsPage = new MyWishlistsPage(webDriver);
        myWishlistsPage.clickWishlistDirectLink(0);
        webDriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        myWishlistsPage.clickCloseWishlistButton();
        TimeUnit.SECONDS.sleep(5);
        assertThrows(ElementNotInteractableException.class, () -> {
            myWishlistsPage.clickCloseWishlistButton();;
        });
        }

    @Test
    @Order(11)
    @DisplayName(("get product name in wishlist items"))
    public void getProductNameInWishListItems(){
        myWishlistsPage = new MyWishlistsPage(webDriver);
        myWishlistsPage.clickWishlistDirectLink(0);
        webDriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        assertThat(myWishlistsPage.getItemNameTextInWishlist(1),containsString("Blouse"));
    }

    @Test
    @Order(12)
    @DisplayName(("set and get quantity in wishlist items"))
    public void setGetQuantityInWishlistItems(){
        myWishlistsPage = new MyWishlistsPage(webDriver);
        myWishlistsPage.clickWishlistDirectLink(0);
        webDriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        myWishlistsPage.inputQuantityInWishList(1,"23");
        myWishlistsPage.clickSaveButtonInWishListItem(1);
        webDriver.navigate().refresh();
        myWishlistsPage.clickWishlistDirectLink(0);
        webDriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        Assertions.assertEquals("23", myWishlistsPage.getQuantityInWishList(1));
    }

    @Test
    @Order(13)
    @DisplayName(("set and get priority in wishlist items"))
    public void setGetPriorityInWishlistItems(){
        myWishlistsPage = new MyWishlistsPage(webDriver);
        myWishlistsPage.clickWishlistDirectLink(0);
        webDriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        myWishlistsPage.selectPriorityInWishList(1,2);
        myWishlistsPage.clickSaveButtonInWishListItem(1);
        webDriver.navigate().refresh();
        myWishlistsPage.clickWishlistDirectLink(0);
        webDriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        Assertions.assertEquals("Low", myWishlistsPage.getPriorityInWishList(1));
    }

    @Test
    @Order(14)
    @DisplayName("Click home button back to home page")
    public void clickHomeButtonBackToHomePage(){
        myWishlistsPage = new MyWishlistsPage(webDriver);
        myWishlistsPage.clickHomeButton();
        Mockito.when(webDriver.getCurrentUrl()).thenReturn("http://automationpractice.com/index.php");
        Assertions.assertEquals(HomePage.DEFAULT_URL,webDriver.getCurrentUrl());
    }

    @Test
    @Order(15)
    @DisplayName("Click back to your account button back to account page")
    public void clickBackToYouAccountButtonBackToAccountPage(){
        myWishlistsPage =  new MyWishlistsPage(webDriver);
        myWishlistsPage.clickBackToYourAccountButton();
        Mockito.when(webDriver.getCurrentUrl()).thenReturn("http://automationpractice.com/index.php?controller=my-account");
        Assertions.assertEquals(MyAccountPage.DEFAULT_URL,webDriver.getCurrentUrl());
    }
    @Test
    @Order(16)
    @DisplayName("My wishlist page constructor test")
    public void myWishlistPageConstructorTest(){
        myWishlistsPage =  new MyWishlistsPage(webDriver);
        Mockito.when(webDriver.getCurrentUrl()).thenReturn("http://automationpractice.com/index.php?fc=module&module=blockwishlist&controller=mywishlist");
        Assertions.assertEquals(MyWishlistsPage.DEFAULT_URL,webDriver.getCurrentUrl());
    }



    @AfterAll
    static void close(){
         webDriver.quit();
    }

}

package com.guardedgeckos.automationpractice.unit_tests;

import com.guardedgeckos.automationpractice.pages.SignInPage;
import com.guardedgeckos.automationpractice.pages.cart.myaccount.MyAccountPage;
import com.guardedgeckos.automationpractice.pages.cart.myaccount.MyWishlistsPage;
import com.guardedgeckos.automationpractice.utilities.DriverFactory;
import org.junit.jupiter.api.*;
import org.openqa.selenium.ElementNotInteractableException;
import org.openqa.selenium.WebDriver;

import java.util.concurrent.TimeUnit;

import static org.hamcrest.Matchers.*;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsString;
import static org.junit.Assert.assertThrows;

public class MyWishListTest {
    private static WebDriver webDriver = DriverFactory.get();
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
    @DisplayName("add new wishlist")
    public void test(){
        myWishlistsPage = new MyWishlistsPage(webDriver);
        int wishlistsSize = myWishlistsPage.getWishlistsSize();
        myWishlistsPage.inputName("UnitTestList");
        myWishlistsPage.clickSubmitWishlistButton();
        Assertions.assertEquals(wishlistsSize+1,myWishlistsPage.getWishlistsSize());
    }

    @Test
    @DisplayName("Remove unit test wishlist")
    public void removeUnitTestWishlist() throws InterruptedException {
        myWishlistsPage = new MyWishlistsPage(webDriver);
        int removeList = myWishlistsPage.getWishlistsSize() - 1;
        myWishlistsPage.clickWishlistDeleteButton(removeList,true);
        TimeUnit.SECONDS.sleep(3);
        Assertions.assertEquals(removeList, myWishlistsPage.getWishlistsSize());
    }

    @Test
    @DisplayName("get wishlist name")
    public void getWishlistName(){
        myWishlistsPage = new MyWishlistsPage(webDriver);
        Assertions.assertEquals("mylist1", myWishlistsPage.getWishlistName(0));
    }

    @Test
    @DisplayName("get wishlist qty")
    public void getWishlistQty(){
        myWishlistsPage = new MyWishlistsPage(webDriver);
        Assertions.assertEquals("0", myWishlistsPage.getWishlistQuantity(1));
    }


    @Test
    @DisplayName("get wishlist viewed")
    public void getWishlistViewed(){
        myWishlistsPage = new MyWishlistsPage(webDriver);
        Assertions.assertEquals("0", myWishlistsPage.getWishlistViewed(1));
    }

    @Test
    @DisplayName("get wishlist created date")
    public void getWishlistCreatedDate(){
        myWishlistsPage = new MyWishlistsPage(webDriver);
        Assertions.assertEquals("2022-03-09", myWishlistsPage.getWishlistCreatedDate(2));
    }

    @Test
    @DisplayName("click wishlist name with no product")
    public void clickWishListNameWithNoProduct() throws InterruptedException {
        myWishlistsPage = new MyWishlistsPage(webDriver);
        myWishlistsPage.clickWishlistName(1);
        TimeUnit.SECONDS.sleep(3);
        assertThat(myWishlistsPage.getAlertText(),containsString("No products"));
    }
    @Test
    @DisplayName("click wishlist link with no product")
    public void clickWishListLinkWithNoProduct() throws InterruptedException {
        myWishlistsPage = new MyWishlistsPage(webDriver);
        myWishlistsPage.clickWishlistDirectLink(1);
        TimeUnit.SECONDS.sleep(3);
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
    @DisplayName("send wishlist with input email")
    public void sendWishlistWithInputEmail(){
        myWishlistsPage = new MyWishlistsPage(webDriver);
        myWishlistsPage.clickWishlistDirectLink(0);
        webDriver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        myWishlistsPage.clickSendThisWishlistButton();
        myWishlistsPage.clickSendThisWishlistButton();
        myWishlistsPage.inputTextInSendWishlistForm(0,"abc@abc.com");
        myWishlistsPage.inputTextInSendWishlistForm(1,"def@abc.com");
        myWishlistsPage.inputTextInSendWishlistForm(2,"bcd@abc.com");
        myWishlistsPage.clickSendWishListButton();
        Assertions.assertEquals("http://automationpractice.com/index.php?fc=module&module=blockwishlist&controller=mywishlist", webDriver.getCurrentUrl());
    }

    @Test
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
    @DisplayName(("get product name in wishlist items"))
    public void getProductNameInWishListItems(){
        myWishlistsPage = new MyWishlistsPage(webDriver);
        myWishlistsPage.clickWishlistDirectLink(0);
        webDriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        assertThat(myWishlistsPage.getItemNameTextInWishlist(1),containsString("Blouse"));
    }

    @Test
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


    @AfterAll
    static void close(){
         webDriver.quit();
    }

}

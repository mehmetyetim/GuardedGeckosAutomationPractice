package com.guardedgeckos.automationpractice.unit_tests;

import com.guardedgeckos.automationpractice.pages.ContactUsPage;
import com.guardedgeckos.automationpractice.pages.SignInPage;
import com.guardedgeckos.automationpractice.pages.cart.*;
import com.guardedgeckos.automationpractice.pages.cart.payment.BankWirePage;
import com.guardedgeckos.automationpractice.pages.cart.payment.CheckPage;
import com.guardedgeckos.automationpractice.pages.cart.payment.FinalPaymentPage;
import com.guardedgeckos.automationpractice.utilities.DriverFactory;
import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.time.Duration;

public class CartPageTests {
     private static WebDriver driver;

     CartPage cartPage;
     CheckoutAddressPage checkoutAddress;
     PaymentPage paymentClass;
     ShippingPage shippingPage;
     BankWirePage bankWirePage;
     CheckPage checkPage;
     FinalPaymentPage finalPaymentPage;
     ContactUsPage contactUsPage;

     @BeforeEach
     void setUp(){
          driver = DriverFactory.get();
          DriverFactory.get().manage().window().maximize();
          driver.get("http://automationpractice.com/");
          driver.findElement(By.className("login")).click();
          driver.findElement(By.id("email")).sendKeys("cporteous@spartaglobal.com");
          driver.findElement(By.id("passwd")).sendKeys("password");
          driver.findElement(By.id("SubmitLogin")).click();
     }



     public void timer(){
          try {
               Thread.sleep(3000);
          } catch (InterruptedException e) {
               e.printStackTrace();
          }
     }

     @Test
     @DisplayName("Full walkthrough of the cart structure, bank wire")
     public void fullWalkthroughOfTheCartStructureBankWire() {
          driver.get("http://automationpractice.com/index.php?id_product=1&controller=product");
          driver.findElement(By.name("Submit")).click();

          //driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

          timer();

          cartPage = new CartPage(driver);
          timer();
          checkoutAddress = (CheckoutAddressPage) CartPage.Links.CHECKOUT_LOGGED_IN.getPage(driver);
          timer();
          shippingPage = (ShippingPage) CheckoutAddressPage.Links.CHECKOUT_LOGGED_IN.getPage(driver);
          shippingPage.tickTheTermsBox();
          timer();
          paymentClass = (PaymentPage) ShippingPage.Links.CHECKOUT_LOGGED_IN.getPage(driver);
          timer();
          bankWirePage = (BankWirePage) PaymentPage.Links.PAY_BY_BANK_WIRE.getPage(driver);
          timer();
          bankWirePage.confirmPayment();
          finalPaymentPage = new FinalPaymentPage(driver);
          timer();
          contactUsPage = (ContactUsPage) finalPaymentPage.getContactPage();
          timer();
          contactUsPage.contactUsForm("Customer service", "This is a rickroll, get rickrolled <3");
     }

     @Test
     @DisplayName("Full walkthrough of the cart structure, check")
     public void fullWalkthroughOfTheCartStructureCheck() {
          driver.get("http://automationpractice.com/index.php?id_product=1&controller=product");
          driver.findElement(By.name("Submit")).click();

          //driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

          timer();

          cartPage = new CartPage(driver);
          timer();
          checkoutAddress = (CheckoutAddressPage) CartPage.Links.CHECKOUT_LOGGED_IN.getPage(driver);
          timer();
          shippingPage = (ShippingPage) CheckoutAddressPage.Links.CHECKOUT_LOGGED_IN.getPage(driver);
          shippingPage.tickTheTermsBox();
          timer();
          paymentClass = (PaymentPage) ShippingPage.Links.CHECKOUT_LOGGED_IN.getPage(driver);
          timer();
          checkPage = (CheckPage) PaymentPage.Links.PAY_BY_CHECK.getPage(driver);
          timer();
          checkPage.confirmPayment();
          finalPaymentPage = new FinalPaymentPage(driver);
          timer();
          contactUsPage = (ContactUsPage) finalPaymentPage.getContactPage();
          timer();
          contactUsPage.contactUsForm("Customer service", "This is a rickroll, get rickrolled <3");
     }

     @Test
     @DisplayName("Testing the Cart Page of the website")
     public void testingTheCardPageOfTheWebsite() {
          driver.get("http://automationpractice.com/index.php?id_product=1&controller=product");
          driver.findElement(By.name("Submit")).click();

          driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

          try {
               Thread.sleep(2000);
          } catch (InterruptedException e) {
               e.printStackTrace();
          }

          cartPage = new CartPage(driver);

          if (cartPage.cartArrayListSet(driver).size() > 0){
               for (Cart c: cartPage.cartArrayListSet(driver)) {
                    System.out.println(c.toString());
               }
          }
     }

     @Test
     @DisplayName("Testing the Cart Page of the website and delete")
     public void testingTheCardPageOfTheWebsiteAndDelete() {
          driver.get("http://automationpractice.com/index.php?id_product=1&controller=product");
          driver.findElement(By.name("Submit")).click();

          driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));



          cartPage = new CartPage(driver);

          cartPage.deleteAllCartContentsOfFirstType(driver);
          try {
               Thread.sleep(2000);
          } catch (InterruptedException e) {
               e.printStackTrace();
          }
          cartPage.deleteAllCartContentsOfFirstType(driver);
     }


     @AfterEach
     void tearDown() {
          DriverFactory.closeDriver();
     }
}

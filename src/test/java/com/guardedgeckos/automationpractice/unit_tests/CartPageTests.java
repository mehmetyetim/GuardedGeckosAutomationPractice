package com.guardedgeckos.automationpractice.unit_tests;

import com.guardedgeckos.automationpractice.pages.IHopeYouGuysAreHappy;
import com.guardedgeckos.automationpractice.pages.SignInPage;
import com.guardedgeckos.automationpractice.pages.cart.*;
import com.guardedgeckos.automationpractice.utilities.ConfigurationReader;
import com.guardedgeckos.automationpractice.utilities.DriverFactory;
import org.junit.After;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;

import java.time.Duration;
import java.util.ArrayList;
import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;

public class CartPageTests {
     private static WebDriver driver = DriverFactory.get();

     CartPage cartPage;
     CheckoutAddress checkoutAddress;
     PaymentClass paymentClass;
     ShippingPage shippingPage;
     IHopeYouGuysAreHappy iHopeYouGuysAreHappy;

     SignInPage signInPage;

     @BeforeAll
     static void setUp(){
          driver.get("http://automationpractice.com/");
          driver.findElement(By.className("login")).click();
          driver.findElement(By.id("email")).sendKeys("cporteous@spartaglobal.com");
          driver.findElement(By.id("passwd")).sendKeys("password");
          driver.findElement(By.id("SubmitLogin")).click();
     }

     public void timer(){
          try {
               Thread.sleep(4000);
          } catch (InterruptedException e) {
               e.printStackTrace();
          }
     }

     @Test
     @DisplayName("Full walkthrough of the cart structure")
     public void fullWalkthroughOfTheCartStructure() {
          driver.get("http://automationpractice.com/index.php?id_product=1&controller=product");
          driver.findElement(By.name("Submit")).click();

          //driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

          timer();

          iHopeYouGuysAreHappy = new IHopeYouGuysAreHappy(driver);
          iHopeYouGuysAreHappy.proceedToCheckout();
          cartPage = new CartPage(driver);
          System.out.println(driver.getCurrentUrl());
          timer();
          checkoutAddress = (CheckoutAddress) CartPage.Links.CHECKOUT_LOGGED_IN.getPage(driver);
          System.out.println(driver.getCurrentUrl());
          timer();
          shippingPage = (ShippingPage) CheckoutAddress.Links.CHECKOUT_LOGGED_IN.getPage(driver);
          System.out.println(driver.getCurrentUrl());
          timer();
          paymentClass= (PaymentClass) ShippingPage.Links.CHECKOUT_LOGGED_IN.getPage(driver);
          System.out.println(driver.getCurrentUrl());
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

     @AfterAll
     static void tearDownAll(){
          DriverFactory.closeDriver();
     }
}

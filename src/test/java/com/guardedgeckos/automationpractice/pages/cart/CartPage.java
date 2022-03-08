package com.guardedgeckos.automationpractice.pages.cart;

import com.guardedgeckos.automationpractice.pages.BasePage;
import com.guardedgeckos.automationpractice.pages.LinksInterface;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

public class CartPage {

    public enum Links implements LinksInterface {
        CONTINUE_SHOPPING{
            @Override
            public BasePage getPage(WebDriver driver) {
                driver.findElement(BY_CONTINUE_SHOPPING).click();
                return null; // return MainPage? ProductPage? IDK
            }
        },
        CHECKOUT_LOGGED_OUT{
            @Override
            public BasePage getPage(WebDriver driver) {
                driver.findElement(BY_CHECKOUT).click();
                return null; // return CheckoutPageOne(driver)
            }
        },

        CHECKOUT_LOGGED_IN{
          @Override
          public BasePage getPage(WebDriver driver){
              driver.findElement(BY_CHECKOUT).click();
              return null; // return CheckoutPageOne(driver, user)
          }
        }
    }

    private static final By
            BY_CONTINUE_SHOPPING = new By.ByClassName("button-exclusive"),
            BY_CHECKOUT = new By.ByClassName("standard-checkout"),
            BY_CART_PRODUCTS = new By.ByClassName("cart_item");


//    public CartPage(WebDriver driver){
//        super(driver, "http://automationpractice.com/index.php?controller=order")
//    }

    public ArrayList<Cart> cartArrayListSet(WebDriver driver){
        ArrayList<Cart> cartArrayList = new ArrayList<>();
        List<WebElement> arrayList = driver.findElements(BY_CART_PRODUCTS);
        for (WebElement e : arrayList){

            String s = String.valueOf(e.findElement(By.xpath("//*[@id=\"product_2_7_0_650549\"]/td[2]/small[2]/a")));
            String[] strings = s.split(",");
            Cart c = new Cart(
                    e.findElement(By.className("product-name")).getText(),
                    strings[0],
                    strings[1],
                    e.findElement(By.className("cart_avail")).getText(),
                    Double.parseDouble(e.findElement(By.className("price")).getText()),
                    Long.parseLong(e.findElement(By.className("cart_quantity")).getText()),
                    Double.parseDouble(e.findElement(By.className("cart_total")).findElement(By.className("price")).getText()),
                    Double.parseDouble(String.valueOf(e.findElement(By.id("total_shipping")))));
            cartArrayList.add(c);
        }

        return cartArrayList;
    }



    public boolean isCartEmpty(WebDriver driver){
        if (Integer.parseInt(driver.findElement(new By.ByClassName("ajax_cart_quantity")).getText()) > 0){
            return false;
        }
        return true;
    }
}

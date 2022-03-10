package com.guardedgeckos.automationpractice.step_definitions;

import com.guardedgeckos.automationpractice.pages.HomePage;
import com.guardedgeckos.automationpractice.pages.SignInPage;
import com.guardedgeckos.automationpractice.pages.cart.CartPage;
import com.guardedgeckos.automationpractice.pages.cart.CheckoutAddressPage;
import com.guardedgeckos.automationpractice.pages.cart.PaymentPage;
import com.guardedgeckos.automationpractice.pages.cart.ShippingPage;
import com.guardedgeckos.automationpractice.pages.cart.payment.BankWirePage;
import com.guardedgeckos.automationpractice.pages.cart.payment.CheckPage;
import com.guardedgeckos.automationpractice.pages.cart.payment.FinalPaymentPage;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CartStepDefs {

    private WebDriver driver;
    private CartPage cartPage;
    private CheckoutAddressPage addressPage;
    private PaymentPage paymentPage;
    private ShippingPage shippingPage;
    private BankWirePage bankWirePage;
    private CheckPage checkPage;
    private FinalPaymentPage finalPaymentPage;
    private HomePage homePage;
    private SignInPage signInPage;


    @Before("Cart")
    public void start(){
        driver.get("http://automationpractice.com/index.php?controller=authentication&back=my-account");
        signInPage = new SignInPage(driver);
        signInPage.enterEmail("bobitob@bob.com");
        signInPage.enterPassword("bobob");
        signInPage.clickSignInButton();
    }
    @Given("I have shopping in the basket")
    public void iHaveShoppingInTheBasket() {

        homePage = new HomePage(driver);
        homePage.clickAddToCartForProduct(7);
    }

    @And("I am on the shopping cart summary page")
    public void iAmOnTheShoppingCartSummaryPage() {
        driver.navigate().to("http://automationpractice.com/index.php?id_product=1&controller=product");
        cartPage = new CartPage(driver);
    }

    @Given("my shopping cart is empty on the shopping cart summary page")
    public void myShoppingCartIsEmptyOnTheShoppingCartSummaryPage() {
        cartPage.deleteAllCartContentsOfFirstType(driver);
    }

    @Then("display your shopping cart is empty")
    public void displayYourShoppingCartIsEmpty() {
        Assertions.assertTrue(cartPage.isCartEmpty(driver));
    }

    @When("I click on the remove product button")
    public void iClickOnTheRemoveProductButton() {
        cartPage.deleteAllCartContentsOfFirstType(driver);
    }

    @Then("the product should be removed from the basket")
    public void theProductShouldBeRemovedFromTheBasket() {
        Assertions.assertTrue(cartPage.isCartEmpty(driver));
    }

    @Given("I am on the shipping page")
    public void iAmOnTheShippingPage() {
        addressPage = (CheckoutAddressPage) CartPage.Links.CHECKOUT_LOGGED_IN.getPage(driver);
        shippingPage = (ShippingPage) CheckoutAddressPage.Links.CHECKOUT_LOGGED_IN.getPage(driver);
    }

    @And("I click on the  I agree tickbox")
    public void iClickOnTheIAgreeTickbox() {
        shippingPage.tickTheTermsBox();
    }

    @When("I click on the proceed to checkout button")
    public void iClickOnTheProceedToCheckoutButton() {
        paymentPage = (PaymentPage) ShippingPage.Links.CHECKOUT_LOGGED_IN.getPage(driver);
    }

    @Then("I should be on the payment method page")
    public void iShouldBeOnThePaymentMethodPage() {
        Assertions.assertEquals("http://automationpractice.com/index.php?controller=order&multi-shipping=",driver.getCurrentUrl());
    }
//TODO: unchecked box
//    @And("the terms of service checkbox is unticked")
//    public void theTermsOfServiceCheckboxIsUnticked() {
//    }
//    @When("I click on proceed to checkout")
//    public void iClickOnProceedToCheckout() {
//    }
//    @Then("I should see an error message")
//    public void iShouldSeeAnErrorMessage() {
//    }

    @Given("I am on the payment method page")
    public void iAmOnThePaymentMethodPage() {
        addressPage = (CheckoutAddressPage) CartPage.Links.CHECKOUT_LOGGED_IN.getPage(driver);
        shippingPage = (ShippingPage) CheckoutAddressPage.Links.CHECKOUT_LOGGED_IN.getPage(driver);
        shippingPage.tickTheTermsBox();
        paymentPage = (PaymentPage) ShippingPage.Links.CHECKOUT_LOGGED_IN.getPage(driver);
    }

    @When("I click on the pay by bank wire button")
    public void iClickOnThePayByBankWireButton() {
        bankWirePage = (BankWirePage) PaymentPage.Links.PAY_BY_BANK_WIRE.getPage(driver);

    }

    @Then("I should be on the Order summary page")
    public void iShouldBeOnTheOrderSummaryPage() {
        Assertions.assertEquals("http://automationpractice.com/index.php?fc=module&module=bankwire&controller=payment", driver.getCurrentUrl());
    }

    @When("I click on the pay by check button")
    public void iClickOnThePayByCheckButton() {
        checkPage = (CheckPage) PaymentPage.Links.PAY_BY_CHECK.getPage(driver);
    }

    @Given("I am on the Order summary page")
    public void iAmOnTheOrderSummaryPage() {
        bankWirePage = (BankWirePage) PaymentPage.Links.PAY_BY_BANK_WIRE.getPage(driver);
    }

    @When("I click on confirm my order")
    public void iClickOnConfirmMyOrder() {
        finalPaymentPage = (FinalPaymentPage) bankWirePage.confirmPayment();
    }

    @Then("I should be taken to the order confirmation page")
    public void iShouldBeTakenToTheOrderConfirmationPage() {
        Assertions.assertEquals("Your order on My Store is complete.", driver.findElements(By.xpath("//*[@id=\"center_column\"]/p[1]/text()")));
    }


    @Then("I should be on the cheque Order summary page")
    public void iShouldBeOnTheChequeOrderSummaryPage() {
        Assertions.assertEquals("http://automationpractice.com/index.php?fc=module&module=cheque&controller=payment", driver.getCurrentUrl());
    }
}

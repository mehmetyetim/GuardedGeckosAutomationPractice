package com.guardedgeckos.automationpractice.unit_tests;

import com.guardedgeckos.automationpractice.pages.SignInPage;
import com.guardedgeckos.automationpractice.pages.cart.myaccount.*;
import com.guardedgeckos.automationpractice.utilities.DriverFactory;
import org.junit.jupiter.api.*;
import org.openqa.selenium.WebDriver;
import java.util.concurrent.TimeUnit;
import static org.hamcrest.Matchers.*;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsString;

public class OrderHistoryPageTest {
    private static WebDriver webDriver = DriverFactory.get();
    static MyAccountPage myAccountPage;
    static OrderHistoryPage orderHistoryPage;
    static SignInPage signInPage;

    @BeforeAll
    public static void setUp(){
        webDriver = DriverFactory.get();
        signInPage = new SignInPage(webDriver);
        signInPage.enterEmail("vzelohgcpdzokhclvd@bvhrk.com");
        signInPage.enterPassword("password");
        signInPage.clickSignInButton();
        myAccountPage = new MyAccountPage(webDriver);
        myAccountPage.clickOrderHistoryAndDetailsButton();
    }

    @Test
    @DisplayName("click order reference & shows correct order")
    void clickOrderReferenceShowsCorrectOrder()
    {
        orderHistoryPage = new OrderHistoryPage(webDriver);
        orderHistoryPage.clickOrderReference(1);
        webDriver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        assertThat(orderHistoryPage.getOrderReferenceTextInTableBelow(), containsString(orderHistoryPage.getOrderReferenceText(1)));
    }

    @Test
    @DisplayName("click order reference & shows correct date")
    void clickOrderReferenceShowsCorrectDate()
    {
        orderHistoryPage = new OrderHistoryPage(webDriver);
        orderHistoryPage.clickOrderReference(1);
        webDriver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        assertThat(orderHistoryPage.getOrderReferenceTextInTableBelow(), containsString(orderHistoryPage.getOrderDate(1)));
    }

    @Test
    @DisplayName("click details & shows correct order")
    void clickDetailsShowsCorrectOrder()
    {
        orderHistoryPage = new OrderHistoryPage(webDriver);
        webDriver.manage().window().maximize();
        orderHistoryPage.clickOrderDetailsButton(3);
        webDriver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        assertThat(orderHistoryPage.getOrderReferenceTextInTableBelow(), containsString(orderHistoryPage.getOrderReferenceText(3)));
    }

    @Test
    @DisplayName("Get order date from table")
    void getOrderDateFromTable(){
        orderHistoryPage = new OrderHistoryPage(webDriver);
        webDriver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        assertThat(orderHistoryPage.getOrderDate(2),containsString("2022"));
    }

    @Test
    @DisplayName("Get order payment from table")
    void getPaymentFromTable(){
        orderHistoryPage = new OrderHistoryPage(webDriver);
        webDriver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        Assertions.assertEquals("Bank wire", orderHistoryPage.getPayment(2));
    }

    @Test
    @DisplayName("Get state from table")
    void getStateFromTable(){
        orderHistoryPage = new OrderHistoryPage(webDriver);
        webDriver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        Assertions.assertEquals("On backorder", orderHistoryPage.getOrderStatus(2));
    }

    @Test
    @DisplayName("click reorder from table")
    void clickReorderFromTable(){
        orderHistoryPage = new OrderHistoryPage(webDriver);
        webDriver.manage().window().maximize();
        webDriver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        orderHistoryPage.clickReorderButtonFromTable(3);
        Assertions.assertEquals("http://automationpractice.com/index.php?controller=order", webDriver.getCurrentUrl());
    }

    @Test
    @DisplayName("click plus button and footable shows payment")
    void clickPlusButtonAndFootableShowsPayment(){
        orderHistoryPage = new OrderHistoryPage(webDriver);
        orderHistoryPage.clickPlusButton(2);
        webDriver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        Assertions.assertEquals("Bank wire", orderHistoryPage.getPaymentTypeFromFootableBox(2));
    }

    @Test
    @DisplayName("click plus button and click details button shows details")
    void clickPlusButtonAndClickDetailsButtonShowsDetails(){
        orderHistoryPage = new OrderHistoryPage(webDriver);
        orderHistoryPage.clickPlusButton(1);
        webDriver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        orderHistoryPage.clickDetailsButtonFromFootableBox(1);
        webDriver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        assertThat(orderHistoryPage.getOrderReferenceTextInTableBelow(), containsString(orderHistoryPage.getOrderReferenceText(1)));
    }

    @Test
    @DisplayName("click plus button and click reorder button go to reorder page")
    void clickPlusButtonAndClickReorderButtonGoToReorderPage(){
        orderHistoryPage = new OrderHistoryPage(webDriver);
        orderHistoryPage.clickPlusButton(1);
        webDriver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        orderHistoryPage.clickReorderButtonFromFootableBox(1);
        Assertions.assertEquals("http://automationpractice.com/index.php?controller=order", webDriver.getCurrentUrl());
    }

    @Test
    @DisplayName("get carrier name in order details")
    void getCarrierNameInOrderDetails()
    {
        orderHistoryPage = new OrderHistoryPage(webDriver);
        orderHistoryPage.clickOrderReference(1);
        webDriver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        Assertions.assertEquals("Carrier My carrier",orderHistoryPage.getCarrierFromInfoReferenceBox());
    }

    @Test
    @DisplayName("get payment method in order details")
    void getPaymentMethodInOrderDetails()
    {
        orderHistoryPage = new OrderHistoryPage(webDriver);
        orderHistoryPage.clickOrderReference(1);
        webDriver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        Assertions.assertEquals(orderHistoryPage.getPayment(1),orderHistoryPage.getPaymentMethodFromInfoReferenceBox());
    }

    @Test
    @DisplayName("get alert when submit empty message")
    void getAlertWhenSubmitEmptyMessage(){
        orderHistoryPage = new OrderHistoryPage(webDriver);
        orderHistoryPage.clickOrderReference(1);
        webDriver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        orderHistoryPage.chooseProductInAddAMessage(1);
        orderHistoryPage.typeMessageInMessageBox("");
        orderHistoryPage.sendMessage();
        assertThat(orderHistoryPage.getAlertText(),containsString("The message cannot be blank"));
    }

    @Test
    @DisplayName("get alert when submit valid message")
    void getAlertWhenSubmitValidMessage(){
        orderHistoryPage = new OrderHistoryPage(webDriver);
        orderHistoryPage.clickOrderReference(1);
        webDriver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        orderHistoryPage.chooseProductInAddAMessage(1);
        orderHistoryPage.typeMessageInMessageBox("test");
        orderHistoryPage.sendMessage();
        assertThat(orderHistoryPage.getAlertText(),containsString("Message successfully sent"));
    }


    @Test
    @DisplayName("new window pop-up when clicking PDF button in invoice")
    void newWindowPopUpWhenClickingPDFButtonInInvoice(){
        orderHistoryPage = new OrderHistoryPage(webDriver);
        webDriver.manage().window().maximize();
        int currentWindowSize = webDriver.getWindowHandles().size();
        orderHistoryPage.clickOrderInvoiceButton(1);
        assertThat(webDriver.getWindowHandles(), hasSize(currentWindowSize+1));
    }


    @Test
    @DisplayName("new window pop-up when clicking PDF button in footable")
    void newWindowPopUpWhenClickingPDFButtonInFootable(){
        orderHistoryPage = new OrderHistoryPage(webDriver);
        orderHistoryPage.clickPlusButton(2);
        webDriver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        int currentWindowSize = webDriver.getWindowHandles().size();
        orderHistoryPage.clickPDFButtonFromFootableBox(2);
        assertThat(webDriver.getWindowHandles(), hasSize(currentWindowSize+1));
    }

    @Test
    @DisplayName("get address subheading")
    void GetAddressSubheading(){
        orderHistoryPage = new OrderHistoryPage(webDriver);
        orderHistoryPage.clickOrderReference(1);
        webDriver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        Assumptions.assumeTrue("DELIVERY ADDRESS (HOME)".equals(orderHistoryPage.getAddressBlockSubheadingText(0)));
        Assertions.assertEquals("INVOICE ADDRESS (HOME)", orderHistoryPage.getAddressBlockSubheadingText(1));
    }

    @Test
    @DisplayName("get address company")
    void GetAddressCompany(){
        orderHistoryPage = new OrderHistoryPage(webDriver);
        orderHistoryPage.clickOrderReference(1);
        webDriver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        Assertions.assertEquals("111", orderHistoryPage.getAddressBlockCompanyText(1));
    }

    @Test
    @DisplayName("get address first name")
    void GetAddressFirstName(){
        orderHistoryPage = new OrderHistoryPage(webDriver);
        orderHistoryPage.clickOrderReference(1);
        webDriver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        Assertions.assertEquals("Firstfirstname", orderHistoryPage.getAddressBlockFirstNameText(1));
    }


    @Test
    @DisplayName("get address last name")
    void GetAddressLastName(){
        orderHistoryPage = new OrderHistoryPage(webDriver);
        orderHistoryPage.clickOrderReference(1);
        webDriver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        Assertions.assertEquals("Lastlastname", orderHistoryPage.getAddressBlockLastNameText(1));
    }

    @Test
    @DisplayName("get address address 1")
    void GetAddressAddress1(){
        orderHistoryPage = new OrderHistoryPage(webDriver);
        orderHistoryPage.clickOrderReference(1);
        webDriver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        Assertions.assertEquals("address1", orderHistoryPage.getAddressBlockAddressOneText(1));
    }

    @Test
    @DisplayName("get address address 2")
    void GetAddressAddress2(){
        orderHistoryPage = new OrderHistoryPage(webDriver);
        orderHistoryPage.clickOrderReference(1);
        webDriver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        Assertions.assertEquals("address2", orderHistoryPage.getAddressBlockAddressTwoText(1));
    }


    @Test
    @DisplayName("get address city")
    void GetAddressCity(){
        orderHistoryPage = new OrderHistoryPage(webDriver);
        orderHistoryPage.clickOrderReference(1);
        webDriver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        Assertions.assertEquals("city,", orderHistoryPage.getAddressBlockCityText(1));
    }

    @Test
    @DisplayName("get address state")
    void GetAddressState(){
        orderHistoryPage = new OrderHistoryPage(webDriver);
        orderHistoryPage.clickOrderReference(1);
        webDriver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        Assertions.assertEquals("Alaska", orderHistoryPage.getAddressBlockStateText(1));
    }

    @Test
    @DisplayName("get address postcode")
    void GetAddressPostcode(){
        orderHistoryPage = new OrderHistoryPage(webDriver);
        orderHistoryPage.clickOrderReference(1);
        webDriver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        Assertions.assertEquals("15325", orderHistoryPage.getAddressBlockPostCodeText(1));
    }

    @Test
    @DisplayName("get address country")
    void GetAddressCountry(){
        orderHistoryPage = new OrderHistoryPage(webDriver);
        orderHistoryPage.clickOrderReference(1);
        webDriver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        Assertions.assertEquals("United States", orderHistoryPage.getAddressBlockCountryText(1));
    }

    @Test
    @DisplayName("get address phone")
    void GetAddressPhone(){
        orderHistoryPage = new OrderHistoryPage(webDriver);
        orderHistoryPage.clickOrderReference(1);
        webDriver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        Assertions.assertEquals("211432235", orderHistoryPage.getAddressBlockPhoneText(1));
    }

    @Test
    @DisplayName("get address mobile phone")
    void GetAddressMobilePhone(){
        orderHistoryPage = new OrderHistoryPage(webDriver);
        orderHistoryPage.clickOrderReference(1);
        webDriver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        Assertions.assertEquals("11111111", orderHistoryPage.getAddressBlockMobilePhoneText(1));
    }

    @Test
    @DisplayName("get history order amount")
    void GetHistoryOrderAmount(){
        orderHistoryPage = new OrderHistoryPage(webDriver);
        Assertions.assertEquals(9, orderHistoryPage.getOrderHistorySize());
    }

    @Test
    @DisplayName("get order price")
    void GetOrderPrice(){
        orderHistoryPage = new OrderHistoryPage(webDriver);
        Assertions.assertEquals("$18.51", orderHistoryPage.getOrderPrice(2));
    }

    @Test
    @DisplayName("click sort order price")
    void clickSortOrderPrice(){
        orderHistoryPage = new OrderHistoryPage(webDriver);
        orderHistoryPage.clickSortTotalPrice();
        Assumptions.assumeTrue(orderHistoryPage.getOrderPrice(0).equals("$18.51"));
        Assertions.assertEquals("$112.47",orderHistoryPage.getOrderPrice(8));
    }

    @Test
    @DisplayName("click sort order date")
    void clickSortOrderDate(){
        orderHistoryPage = new OrderHistoryPage(webDriver);
        orderHistoryPage.clickSortDate();
        Assumptions.assumeTrue(orderHistoryPage.getOrderDate(0).equals("03/07/2022"));
        Assertions.assertEquals("03/08/2022",orderHistoryPage.getOrderDate(8));
    }


    @Test
    @DisplayName("click green reorder button go to reorder page")
    void clickGreenReorderButtonGoToReorderPage() {
        orderHistoryPage = new OrderHistoryPage(webDriver);
        orderHistoryPage.clickOrderReference(1);
        webDriver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        orderHistoryPage.clickGreenRecorderButton();
        Assertions.assertEquals("http://automationpractice.com/index.php?controller=order", webDriver.getCurrentUrl());
    }

    @Test
    @DisplayName("get order reference in order details box")
    void getOrderReferenceInOrderDetailsBox() {
        orderHistoryPage = new OrderHistoryPage(webDriver);
        orderHistoryPage.clickOrderReference(1);
        webDriver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        Assertions.assertEquals("demo_5", orderHistoryPage.getOrderDetailContentReferenceText(0));
    }

    @Test
    @DisplayName("get product name in order details box")
    void getProductNameInOrderDetailsBox() {
        orderHistoryPage = new OrderHistoryPage(webDriver);
        orderHistoryPage.clickOrderReference(1);
        webDriver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        Assertions.assertEquals("Printed Summer Dress - Color : Yellow, Size : S", orderHistoryPage.getOrderDetailContentProductText(0));
    }

    @Test
    @DisplayName("get product quantity in order details box")
    void getProductQuantityInOrderDetailsBox() {
        orderHistoryPage = new OrderHistoryPage(webDriver);
        orderHistoryPage.clickOrderReference(1);
        webDriver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        Assertions.assertEquals("1", orderHistoryPage.getOrderDetailContentQuantityText(0));
    }

    @Test
    @DisplayName("get product unit price in order details box")
    void getProductUnitPriceInOrderDetailsBox() {
        orderHistoryPage = new OrderHistoryPage(webDriver);
        orderHistoryPage.clickOrderReference(1);
        webDriver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        Assertions.assertEquals("$28.98", orderHistoryPage.getOrderDetailContentUnitPriceText(0));
    }

    @Test
    @DisplayName("get product total price in order details box")
    void getProductTotalPriceInOrderDetailsBox() {
        orderHistoryPage = new OrderHistoryPage(webDriver);
        orderHistoryPage.clickOrderReference(1);
        webDriver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        Assertions.assertEquals("$28.98", orderHistoryPage.getOrderDetailContentUnitPriceText(0));
    }

    @Test
    @DisplayName("get items price excl in order details box")
    void getItemsPriceExclInOrderDetailsBox() {
        orderHistoryPage = new OrderHistoryPage(webDriver);
        orderHistoryPage.clickOrderReference(1);
        webDriver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        Assertions.assertEquals("$28.98", orderHistoryPage.getItemsPriceExclTax());
    }
    @Test
    @DisplayName("get items price incl in order details box")
    void getItemsPriceInclInOrderDetailsBox() {
        orderHistoryPage = new OrderHistoryPage(webDriver);
        orderHistoryPage.clickOrderReference(1);
        webDriver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        Assertions.assertEquals("$28.98", orderHistoryPage.getItemsPriceInclTax());
    }

    @Test
    @DisplayName("get items shipping price in order details box")
    void getItemsShippingPriceInclInOrderDetailsBox() {
        orderHistoryPage = new OrderHistoryPage(webDriver);
        orderHistoryPage.clickOrderReference(1);
        webDriver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        Assertions.assertEquals("$2.00", orderHistoryPage.getShippingAndHandlingPriceInclTax());
    }
    @Test
    @DisplayName("get items total price in order details box")
    void getItemsTotalPriceInclInOrderDetailsBox() {
        orderHistoryPage = new OrderHistoryPage(webDriver);
        orderHistoryPage.clickOrderReference(1);
        webDriver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        Assertions.assertEquals("$30.98", orderHistoryPage.getTotalPriceInOrderDetails());
    }


    @AfterAll
    static void close(){
        webDriver.quit();
    }



}

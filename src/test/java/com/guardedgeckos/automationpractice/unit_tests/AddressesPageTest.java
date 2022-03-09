package com.guardedgeckos.automationpractice.unit_tests;

import com.guardedgeckos.automationpractice.pages.SignInPage;
import com.guardedgeckos.automationpractice.pages.cart.myaccount.AddressPage;
import com.guardedgeckos.automationpractice.pages.cart.myaccount.AddressesPage;
import com.guardedgeckos.automationpractice.pages.cart.myaccount.MyAccountPage;
import com.guardedgeckos.automationpractice.utilities.DriverFactory;
import org.junit.jupiter.api.*;
import org.openqa.selenium.WebDriver;
import static org.hamcrest.Matchers.*;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsString;

public class AddressesPageTest {
    private static WebDriver webDriver = DriverFactory.get();
    static MyAccountPage myAccountPage;
    static AddressesPage addressesPage;
    static AddressPage addressPage;
    static SignInPage signInPage;

    @BeforeAll
    public static void setUp(){
        webDriver = DriverFactory.get();
        signInPage = new SignInPage(webDriver);
        signInPage.enterEmail("vzelohgcpdzokhclvd@bvhrk.com");
        signInPage.enterPassword("password");
        signInPage.clickSignInButton();
        myAccountPage = new MyAccountPage(webDriver);
        myAccountPage.clickMyAddressesButton();
    }

    @Test
    @DisplayName("click add new address button go to address page")
    public void clickAddNewAddressButtonGoToAddressPage(){
        addressesPage = new AddressesPage(webDriver);
        addressesPage.clickAddANewAddressButton();
        Assertions.assertEquals("http://automationpractice.com/index.php?controller=address", webDriver.getCurrentUrl());
    }

    @Test
    @DisplayName("click update address go to address page")
    public void clickUpdateAddressGoToAddressPage(){
        addressesPage = new AddressesPage(webDriver);
        addressesPage.updateAddressBlock(0,0);
        assertThat(webDriver.getCurrentUrl(),containsString("http://automationpractice.com/index.php?controller=address&id_address="));
    }

    @Test
    @DisplayName("Create a new address and go back to addresses page")
    public void createANewAddress(){
        addressesPage = new AddressesPage(webDriver);
        addressesPage.clickAddANewAddressButton();
        addressPage = new AddressPage(webDriver);
        addressPage.inputFirstName("AutoFirstName");
        addressPage.inputLastName("AutoLastName");
        addressPage.inputCompany("AutoCompany");
        addressPage.inputAddressOne("AutoAddressOne");
        addressPage.inputAddressTwo("AutoAddressTwo");
        addressPage.inputCity("AutoCity");
        addressPage.selectState(3);
        addressPage.selectCountry(0);
        addressPage.inputPostcode("85032");
        addressPage.inputPhone("29283283");
        addressPage.inputMobilePhone("12345678");
        addressPage.inputOther("UnitTest");
        addressPage.inputAlias("UnitTest");
        addressPage.clickSaveButton();
        Assertions.assertEquals("http://automationpractice.com/index.php?controller=addresses",webDriver.getCurrentUrl());
    }

    @Test
    @DisplayName("Check correct information in address block and delete block")
    public void checkCorrectInformationInAddresBlock(){
        addressesPage = new AddressesPage(webDriver);
        int addressSize = addressesPage.getAddressBlocksSize();
        Assumptions.assumeTrue(addressesPage.getFirstName(0,1).equals("AutoFirstName"));
        Assumptions.assumeTrue(addressesPage.getLastName(0,1).equals("AutoLastName"));
        Assumptions.assumeTrue(addressesPage.getAddressCompanyName(0,1).equals("AutoCompany"));
        Assumptions.assumeTrue(addressesPage.getAddressAddressOne(0,1).equals("AutoAddressOne"));
        Assumptions.assumeTrue(addressesPage.getAddressAddressTwo(0,1).equals("AutoAddressTwo"));
        Assumptions.assumeTrue(addressesPage.getAddressPhoneNum(0,1).equals("29283283"));
        Assumptions.assumeTrue(addressesPage.getAddressMobilePhoneNum(0,1).equals("12345678"));
        Assumptions.assumeTrue(addressesPage.getAddressAlias(0,1).equals("UNITTEST"));
        Assumptions.assumeTrue(addressesPage.getStringInAddressBlock(0,1,4).equals("AutoCity, Arizona 85032"));
        Assumptions.assumeTrue(addressesPage.getStringInAddressBlock(0,1,5).equals("United States"));
        addressesPage.deleteAddressBlock(0,1,true);
        Assertions.assertEquals(addressesPage.getAddressBlocksSize(), addressSize-1);

    }



    @AfterAll
    static void close(){
        webDriver.quit();
    }


}

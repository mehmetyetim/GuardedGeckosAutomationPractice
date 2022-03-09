package com.guardedgeckos.automationpractice.step_definitions;
import com.guardedgeckos.automationpractice.pages.SignInPage;
import com.guardedgeckos.automationpractice.pages.cart.myaccount.*;
import com.guardedgeckos.automationpractice.utilities.DriverFactory;
import io.cucumber.java.Before;
import org.openqa.selenium.WebDriver;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.chrome.ChromeDriver;

public class AccountStepDefs {

    private static WebDriver webDriver;
    private MyAccountPage myAccountPage = new MyAccountPage(webDriver);
    private AddressesPage addressesPage = new AddressesPage(webDriver);
    private OrderHistoryPage myOrderHistoryPage = new OrderHistoryPage(webDriver);
    private OrderSlipPage creditSlipPage = new OrderSlipPage(webDriver);
    private IdentityPage myPersonalInfoPage = new IdentityPage(webDriver);
    private AddressPage myAddressPage = new AddressPage(webDriver);
    private SignInPage signInPage = new SignInPage(webDriver);
    private MyWishlistsPage wishListPage = new MyWishlistsPage(webDriver);

        @Before
        public void start() {
        webDriver = DriverFactory.get();
        signInPage.clickSignInButton();
        webDriver.get("http://automationpractice.com/index.php?controller=authentication&back=my-account");
        signInPage.enterEmail("1234@h.b");
        signInPage.enterPassword("12345!");
        signInPage.clickSignInButton();
        }

        @Given("i am on the account page")
        public boolean iAmOnMyAccountPage() {
            boolean myAccountPageOpen = false;
            webDriver.navigate().to("http://automationpractice.com/index.php?controller=my-account");
            if (webDriver.getCurrentUrl().equals("http://automationpractice.com/index.php?controller=my-account")) myAccountPageOpen = true;
            return myAccountPageOpen;
        }

        @When("I click the Order History and Details button")
        public void clickOrderHistory() {
            myAccountPage.clickOrderHistoryAndDetailsButton();
        }

        @Then("I should be taken to the Order History and Details page")
        public boolean amIOnOrderHistoryPage(){
            boolean onOrderHistoryPage = false;
            if(webDriver.getCurrentUrl() == myOrderHistoryPage.getDefaultUrl())
                onOrderHistoryPage = true;
            return onOrderHistoryPage;
        }

        @When("I click the Credit Slips button")
        public void clickCreditSlipButton(){
            myAccountPage.clickMyCreditSlipsButton();
        }

        @Then("I should be taken to the Credit Slips page")
        public boolean amOnCreditPage(){
            boolean onCreditPage = false;
            if(webDriver.getCurrentUrl() == creditSlipPage.getDefaultUrl())
                onCreditPage = true;
            return onCreditPage;

        }

        @When("I click the My Addresses button")
        public void clickMyAddressButton(){
            myAccountPage.clickMyAddressesButton();
        }

        @Then("I should be taken to the My Addresses page")
        public boolean amOnMyAddressesPage(){
            boolean onAddressesPage = false;
            if (webDriver.getCurrentUrl() == myAddressPage.getDefaultUrl())
                onAddressesPage = true;
            return onAddressesPage;
        }

        @When("I click the My Personal Information button")
        public void clickPersonalInfoButton(){
            myAccountPage.clickMyPersonalInformationButton();
        }

        @Then("I should be taken to the personal information page")
            public boolean amOnPersonalInfoPage(){
            boolean onPersonalInfoPage = false;
            if(webDriver.getCurrentUrl() == myPersonalInfoPage.getDefaultUrl())
                onPersonalInfoPage = true;
            return onPersonalInfoPage;
        }

        @When("I click the My Wishlists button")
        public void clickMyWishListsButton(){
            myAccountPage.clickMyWishlistsButton();
        }

        @Then("I should be taken to the Wishlists page")
        public boolean amOnWishListPage(){
            boolean onWishListPage = false;
            if(webDriver.getCurrentUrl() == wishListPage.getDefaultUrl())
                onWishListPage = true;
            return onWishListPage;
        }


        @Given("I am on the WishLists page")
        public boolean iAmOnWishListPage() {
            boolean myWishPageOpen = false;
            webDriver.navigate().to("http://automationpractice.com/index.php?fc=module&module=blockwishlist&controller=mywishlist");
            if (webDriver.getCurrentUrl().equals("http://automationpractice.com/index.php?fc=module&module=blockwishlist&controller=mywishlist"))
                myWishPageOpen = true;
            return myWishPageOpen;
        }

        @When("I give the Wishlist a name")
        public void enterWishListName(){
            wishListPage.inputName("Test");
        }

        @And("i press save")
        public void pressSaveButton(){
            wishListPage.clickSubmitWishlistButton();
        }

        @Then("I should get a new wishlist")
        public boolean isWishListPresent(){
            boolean wishListExists = false;
            if(wishListPage.getWishlistName(0) == "Test")
                wishListExists = true;
            return wishListExists;
        }

        @When("I press the \"x\" in the delete column of the wishlist and conform i am sure")
        public void pressDeleteButton(){
            wishListPage.clickWishlistDeleteButton(0, true);
        }

        @Then("the wishlist should be deleted")
        public boolean isWishListDeleted(){
            boolean wishListDoesNotExist = false;
            if(wishListPage.getWishlistName(0) != "Test")
                wishListDoesNotExist = true;
            return wishListDoesNotExist;
        }

        @Given("I am on the Addresses page")
        public boolean iAmOnAddressesPage() {
            boolean myAddressesPageOpen = false;
            webDriver.navigate().to("http://automationpractice.com/index.php?controller=addresses");
            if (webDriver.getCurrentUrl().equals("http://automationpractice.com/index.php?controller=addresses"))
                myAddressesPageOpen = true;
            return myAddressesPageOpen;
        }

        @When("I press the add new address button, enter the details")
        public void pressNewAddressButton(){
            addressesPage.clickAddANewAddressButton();
            myAddressPage.inputFirstName("Default");
            myAddressPage.inputLastName("User");
            myAddressPage.inputAddressOne("3100 Massachusetts Ave NW");
            myAddressPage.inputCity("DC");
            myAddressPage.selectState(45);
            myAddressPage.inputPostcode("20008");
            myAddressPage.selectCountry(0);
            myAddressPage.inputMobilePhone("09878965546");
        }

        @And("press save")
        public void pressSave(){
            myAddressPage.clickSaveButton();
        }

        @Then("the new address should be added")
        public boolean isAddressAdded(){
            boolean addressAdded = false;
            if (addressesPage.getAddressAddressOne(0, 0) == "3100 Massachusetts Ave NW")
                addressAdded = true;
            return addressAdded;
        }

        @When("I press the delete button and confirm i am sure")
        public void pressDelete(){
            addressesPage.deleteAddressBlock(0,0, true);
        }

        @Then("It should delete the address")
        public boolean isAddressDeleted(){
            boolean addressDeleted = false;
            if (addressesPage.getAddressAddressOne(0,0) != "3100 Massachusetts Ave NW")
                addressDeleted = true;
            return addressDeleted;
        }

        @Given("I am on the personal Information page")
        public boolean iAmOnPersonalInformationPage() {
            boolean personalInfoPageOpen = false;
            webDriver.navigate().to("http://automationpractice.com/index.php?controller=addresses");
            if (webDriver.getCurrentUrl().equals("http://automationpractice.com/index.php?controller=addresses"))
                personalInfoPageOpen = true;
            return personalInfoPageOpen;
        }

        @When("i edit my details")
        public void changePersonalDetails(){
            myPersonalInfoPage.inputFirstName("Nish");
            myPersonalInfoPage.inputLastName("Neil");
        }

        @And("enter my password correctly and press save")
        public void enterPassword(){
            myPersonalInfoPage.inputOldPassword("12345!");
            myPersonalInfoPage.clickSubmitButton();
        }

        @Then("My details should be changed")
        public boolean areDetailsChanged(){
            boolean detailsChanged = false;
            if(webDriver.getCurrentUrl() == "http://automationpractice.com/index.php?controller=identity")
                detailsChanged = true;
            return detailsChanged;
        }

    }

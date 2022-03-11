package com.guardedgeckos.automationpractice.step_definitions;
import com.guardedgeckos.automationpractice.pages.HomePage;
import com.guardedgeckos.automationpractice.pages.Item;
import com.guardedgeckos.automationpractice.pages.SignInPage;
import com.guardedgeckos.automationpractice.pages.cart.myaccount.MyAccountPage;
import com.guardedgeckos.automationpractice.utilities.DriverFactory;
import io.cucumber.java.Before;
import io.cucumber.java.en.*;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;

import java.time.Duration;

import static com.guardedgeckos.automationpractice.step_definitions.Hooks.webDriver;

public class NavigationStepDefs {
    private SignInPage signInPage;
    private MyAccountPage myAccountPage;
    private HomePage homePage;
//    private By quickView = new By.ByClassName("primary_block row");
    @Before("@navigation")
    public void iSignIn(){
        signInPage = new SignInPage(webDriver);
        signInPage.enterEmail("vzelohgcpdzokhclvd@bvhrk.com");
        signInPage.enterPassword("password");
        signInPage.clickSignInButton();
        myAccountPage = new MyAccountPage(webDriver);
    }

    @Before("@homepage")
    public void iNavigateToTheHomePage(){
        homePage = new HomePage(webDriver);
    }




    @When("I click banner")
    public void iClickBanner(){
        homePage.bannerURL();
    }
    @When("I click rotating image")
    @When("I click 3 days sale")
    public void iClick3DaysSale(){
        homePage.clickOnFirstSmallImageAbove();
    }
    @When("I click online only summer")
    public void iClickOnlineOnlySummer(){
        homePage.clickOnSecondSmallImageAbove();
    }
    @When("I click top trends")
    public void iClickTopTrends(){
        homePage.clickOnFirstSmallImageBelow();
    }
    @When("I click mens coats and jackets")
    public void iClickMensCoatsAndJackets(){
        homePage.clickOnSecondSmallImageBelow();
    }
    @When("I click womens coats and jackets")
    public void iClickWomensCoatsAndJackets(){
        homePage.clickOnThirdSmallImageBelow();
    }
    @When("I click sunglasses and eye wear")
    public void iClickSunglassesAndEyeWear(){
        homePage.clickOnFourthSmallImageBelow();
    }
    @When("I click savvy trends handbags")
    public void iClickSavvyTrendsHandbags(){
        homePage.clickOnFifthSmallImageBelow();
    }

    @Then("I am on a page of products")
    public void iAmOnAPageOfProducts(){
        Assertions.assertTrue(webDriver.getCurrentUrl().contains("category"));
    }





    @When("I click on footer women")
    public void iClickFooterWomen(){
        myAccountPage.getWomenFooter();
    }

    @Then("I am on women page")
    public void iAmOnWomenPage(){
        Assertions.assertEquals("http://automationpractice.com/index.php?id_category=3&controller=category", webDriver.getCurrentUrl());
    }

    @When("I click on footer specials")
    public void iClickFooterSpecials (){
        myAccountPage.getSpecialFooter();
    }

    @Then("I am on specials page")
    public void iAmOnSpecialsPage(){
        Assertions.assertEquals("http://automationpractice.com/index.php?controller=prices-drop", webDriver.getCurrentUrl());
    }

    @When("I click on footer new products")
    public void iClickFooterNewProducts (){
        myAccountPage.getNewProductsFooter();
    }

    @Then("I am on new products page")
    public void iAmOnNewProductsPage(){
        Assertions.assertEquals("http://automationpractice.com/index.php?controller=new-products", webDriver.getCurrentUrl());
    }

    @When("I click on footer best sellers")
    public void iClickFooterBestSellers (){
        myAccountPage.getBestSellersFooter();
    }

    @Then("I am on best sellers page")
    public void iAmOnBestSellersPage(){
        Assertions.assertEquals("http://automationpractice.com/index.php?controller=best-sales", webDriver.getCurrentUrl());
    }
    @When("I click on footer our stores")
    public void iClickFooterOurStores(){
        webDriver.manage().timeouts().implicitlyWait(Duration.ofMillis(2000));
        myAccountPage.getOurStoresFooter();

    }

    @Then("I am on our stores page")
    public void iAmOnOurStoresPage(){
        Assertions.assertEquals("http://automationpractice.com/index.php?controller=stores", webDriver.getCurrentUrl());
    }

    @When("I click on footer contact us")
    public void iClickFooterContactUs(){
        myAccountPage.getContactUsFooter();
    }

    @Then("I am on contact us page")
    public void iAmOnContactUsPage(){
        Assertions.assertEquals("http://automationpractice.com/index.php?controller=contact", webDriver.getCurrentUrl());
    }

    @When("I click on footer terms and conditions")
    public void iClickFooterTermsAndConditions(){
        myAccountPage.getTermsFooter();
    }

    @Then("I am on terms and conditions page")
    public void iAmOnTermsAndConditionPage(){
        Assertions.assertEquals("http://automationpractice.com/index.php?id_cms=3&controller=cms", webDriver.getCurrentUrl());
    }

    @When("I click on footer about us")
    public void iClickFooterAboutUs(){
        myAccountPage.getAboutUsFooter();
    }

    @Then("I am on about us page")
    public void iAmOnAboutUsPage(){
        Assertions.assertEquals("http://automationpractice.com/index.php?id_cms=4&controller=cms", webDriver.getCurrentUrl());
    }

    @When("I click on footer sitemap")
    public void iClickFooterSitemap(){
        myAccountPage.getSiteMapFooter();
    }

    @Then("I am on sitemap page")
    public void iAmOnSitemapPage(){
        Assertions.assertEquals("http://automationpractice.com/index.php?controller=sitemap", webDriver.getCurrentUrl());
    }

    @When("I click on footer my account")
    public void iClickFooterMyAccount(){
        myAccountPage.getAccount();
    }

    @Then("I am on my account page")
    public void iAmOnMyAccountPage(){
        Assertions.assertEquals("http://automationpractice.com/index.php?controller=my-account", webDriver.getCurrentUrl());
    }

    @When("I click on footer my orders")
    public void iClickFooterMyOrders(){
        myAccountPage.getMyOrdersFooter();
    }

    @Then("I am on my orders page")
    public void iAmOnMyOrdersPage(){
        Assertions.assertEquals("http://automationpractice.com/index.php?controller=history", webDriver.getCurrentUrl());
    }

    @When("I click on footer my credit slips")
    public void iClickFooterMyCreditSlips(){
        myAccountPage.getCreditSlipsFooter();
    }

    @Then("I am on my credit slips page")
    public void iAmOnMyCreditSlipsPage(){
        Assertions.assertEquals("http://automationpractice.com/index.php?controller=order-slip", webDriver.getCurrentUrl());
    }

    @When("I click on footer my addresses")
    public void iClickFooterMyAddresses(){
        myAccountPage.getAddressesFooter();
    }

    @Then("I am on my addresses page")
    public void iAmOnMyAddressesPage(){
        Assertions.assertEquals("http://automationpractice.com/index.php?controller=addresses", webDriver.getCurrentUrl());
    }

    @When("I click on footer my personal info")
    public void iClickFooterMyPersonalInfo(){
        myAccountPage.getPersonalInfoFooter();
    }

    @Then("I am on my personal info page")
    public void iAmOnMyPersonalInfoPage(){
        Assertions.assertEquals("http://automationpractice.com/index.php?controller=identity", webDriver.getCurrentUrl());
    }

    @When("I click on footer sign out")
    public void iClickFooterSignOut(){
        myAccountPage.getSignOutFooter();
    }

    @Then("I am on sign out page")
    public void iAmOnSignOutPage(){
        Assertions.assertEquals("http://automationpractice.com/index.php?controller=authentication&back=my-account", webDriver.getCurrentUrl());
    }

    @When("I click contact us")
    public void iClickContactUs(){
        homePage.getContactUs();
    }

    @When("I click on footer facebook")
    public void iClickFooterFacebookIcon(){
        myAccountPage.getFacebook();
    }
    @Then("I am on facebook page")
    public void iAmOnFacebookPage(){
        for(String winHandle : webDriver.getWindowHandles()){
            webDriver.switchTo().window(winHandle);
        }
        Assertions.assertEquals("https://www.facebook.com/groups/525066904174158/", webDriver.getCurrentUrl());
    }

    @When("I click on footer twitter")
    public void iClickFooterTwitterIcon(){
        myAccountPage.getTwitter();
    }
    @Then("I am on twitter page")
    public void iAmOnTwitterPage(){
        for(String winHandle : webDriver.getWindowHandles()){
            webDriver.switchTo().window(winHandle);
        }
        Assertions.assertEquals("https://twitter.com/seleniumfrmwrk", webDriver.getCurrentUrl());
    }

    @When("I click on footer youtube")
    public void iClickFooterYoutubeIcon(){
        myAccountPage.getYoutube();
    }
    @Then("I am on youtube page")
    public void iAmOnYoutubePage(){
        for(String winHandle : webDriver.getWindowHandles()){
            webDriver.switchTo().window(winHandle);
        }
        Assertions.assertTrue(webDriver.getCurrentUrl().contains("youtube"));
    }

    @When("I click on footer google plus")
    public void iClickFooterGooglePlusIcon(){
        myAccountPage.getGooglePlus();
    }
    @Then("I am on google plus page")
    public void iAmOnGooglePlusPage(){
        for(String winHandle : webDriver.getWindowHandles()){
            webDriver.switchTo().window(winHandle);
        }
        Assertions.assertTrue(webDriver.getCurrentUrl().contains("google"));
    }

    @When("I hover over the cart and click checkout")
    public void iHoverOverTheCartAndClickCheckout(){
        homePage.getCheckOut();
        homePage.clickOnProceedToCheckout();

    }

    @Then("I am on the summary page")
    public void iAmOnTheSummaryPage(){
        Assertions.assertEquals("http://automationpractice.com/index.php?controller=order", webDriver.getCurrentUrl());
    }

    @Given("There is a product in the cart")
    public void thereIsAProductInTheCart(){
        homePage.hoverOverFirstProductAndClickOnAddToCartButton();
        homePage.continueShopping();
    }

    @When("I mouse over a product and click quick view")
    public void iMouseOverAProduct(){
        homePage.quickView(Item.FADED_SHORT_SLEEVE_);
    }
    @Then("The quick view window pops up")
    public void theQuickViewWindowPopsUp(){
//        Assertions.assertTrue(webDriver.findElement(new By.ByClassName("primary_block row")).isDisplayed());
//        webDriver.findElement(quickView).isDisplayed();
        webDriver.manage().timeouts().implicitlyWait(Duration.ofMillis(10000));
        webDriver.findElement(new By.ById("short_description_content"));

    }

}

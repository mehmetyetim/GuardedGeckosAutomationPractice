package com.guardedgeckos.automationpractice.step_definitions;

import com.guardedgeckos.automationpractice.pages.IHopeYouGuysAreHappy;
import com.guardedgeckos.automationpractice.utilities.DriverFactory;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class CatalogStepDef {
    private static WebDriver webDriver;
    private static IHopeYouGuysAreHappy mainPage;

    @Before
    public void setup() {

    }

    @Given("I am on the home page")
    public void iAmOnTheHomePage() {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");

        webDriver = new ChromeDriver();
        webDriver.get("http://automationpractice.com/index.php");
    }
    @And("I mouse of the {string} header")
    public void iMouseOfTheHeader(String arg0) {
        WebElement l= webDriver.findElement(By.linkText(arg0));

        Actions a = new Actions(webDriver);
        a.moveToElement(l);
    }
    @Then("The {string} dropdown appears")
    public void theDropdownAppears(String arg0) {
        boolean canFind = webDriver.findElement(By.xpath("//*[@id=\"block_top_menu\"]/ul/li[1]/ul/li[1]/ul/li[1]/a")).isEnabled();
        Assertions.assertTrue(canFind);
    }

    @And("I click on the {string} header")
    public void iClickOnTheHeader(String arg0) {
        webDriver.findElement(By.linkText(arg0)).click();
    }

    @Then("Then I go to the {string} product page")
    public void thenIGoToTheProductPage(String arg0) {
        Assertions.assertTrue(webDriver.getCurrentUrl().equals("http://automationpractice.com/index.php?id_category=3&controller=category"));
    }

    @Given("I am on a category page")
    public void iAmOnACategoryPage() {


    }

    @And("I click {string} size button")
    public void iClickSizeButton(String arg0) {
        
    }

    @Then("the page only shows the relevant products")
    public void thePageOnlyShowsTheRelevantProducts() {
    }

    @And("I Hover over a product")
    public void iHoverOverAProduct() {
        
    }

    @And("I click add to basket")
    public void iClickAddToBasket() {
        
    }

    @And("I click add to wishlist")
    public void iClickAddToWishlist() {
        
    }

    @And("I click add to compare")
    public void iClickAddToCompare() {
        
    }

    @Then("the product is added to the basket")
    public void theProductIsAddedToTheBasket() {
        
    }

    @Then("the product is added to the wishlist")
    public void theProductIsAddedToTheWishlist() {
        
    }

    @Then("the product is added to the compare page")
    public void theProductIsAddedToTheComparePage() {
    }

    @Given("I am on the category page")
    public void iAmOnTheCategoryPage() {
    }

    @And("I click the quick view")
    public void iClickTheQuickView() {
    }

    @Then("I am taken to the product page")
    public void iAmTakenToTheProductPage() {
    }

    @Given("I have logged into the SwagLabs website")
    public void iHaveLoggedIntoTheSwagLabsWebsite() {
    }

    @And("I click a product name")
    public void iClickAProductName() {
    }

    @Then("I should be directed to the product page")
    public void iShouldBeDirectedToTheProductPage() {
    }
}

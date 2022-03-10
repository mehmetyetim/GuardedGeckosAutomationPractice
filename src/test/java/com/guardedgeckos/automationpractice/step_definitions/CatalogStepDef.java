package com.guardedgeckos.automationpractice.step_definitions;

import com.guardedgeckos.automationpractice.pages.HomePage;
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
    private static HomePage mainPage;

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
        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");

        webDriver = new ChromeDriver();
        webDriver.get("http://automationpractice.com/index.php?id_category=3&controller=category");
    }

    @And("I click size button")
    public void iClickSizeButton() {
        webDriver.findElement(By.xpath("//*[@id=\"layered_id_attribute_group_1\"]")).click();
    }

    @Then("the site filters by size")
    public void theSiteFiltersBySize() {
        Assertions.assertTrue(webDriver.getCurrentUrl().contains("size-s"));
    }

    @And("I Hover over a product")
    public void iHoverOverAProduct() {
        WebElement l= webDriver.findElement(By.xpath("//*[@id=\"center_column\"]/ul/li/div/div[1]/div/a[1]/img"));

        Actions a = new Actions(webDriver);
        a.moveToElement(l);
    }

    @And("I click add to basket")
    public void iClickAddToBasket() {
        //*[@id="center_column"]/ul/li[1]/div/div[2]/div[2]/a[1]
        //*[@id="center_column"]/ul/li[1]/div/div[2]/div[2]/a[1]/span
        webDriver.findElement(By.xpath("(//a[@data-id-product='1'])[1]/span")).click();
    }

    @And("I click add to compare")
    public void iClickAddToCompare() {
        webDriver.findElement(By.linkText("Add to Compare")).click();
    }

    @Then("the product is added to the basket")
    public void theProductIsAddedToTheBasket() {
        System.out.println(webDriver.findElement(By.id("header")).getText());
        Assertions.assertTrue(webDriver.findElement(By.id("header")).getText().contains("Cart (1)"));
    }

    @Then("the product is added to the compare page")
    public void theProductIsAddedToTheComparePage() {
        Assertions.assertTrue(webDriver.findElement(By.id("center_column")).getText().contains("Compare (1)"));
    }

    @And("I click the quick view")
    public void iClickTheQuickView() {
        //*[@id="center_column"]/ul/li/div/div[1]/div/a[2]
        //*[@id="center_column"]/ul/li/div/div[1]/div/a[2]/span
        webDriver.findElement(By.xpath("Add to Compare")).click();

    }


}

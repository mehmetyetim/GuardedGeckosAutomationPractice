package com.guardedgeckos.automationpractice.step_definitions;

import com.guardedgeckos.automationpractice.pages.HomePage;
import com.guardedgeckos.automationpractice.pages.HomePage;
import com.guardedgeckos.automationpractice.pages.SignInPage;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class productStepDef {

    private static WebDriver webDriver;
    private static HomePage mainPage;

    @Before
    public void setup() {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");

        webDriver = new ChromeDriver();
    }

    @Given("I am on a product page")
    public void iAmOnAProductPage() {
    }

    @And("I change the number of quantity")
    public void iChangeTheNumberOfQuantity() {
        
    }

    @Then("the correct number of product is added to the basket")
    public void theCorrectNumberOfProductIsAddedToTheBasket() {

    }

    @And("I click the size dropdown")
    public void iClickTheSizeDropdown() {
        
    }

    @And("I select a new size")
    public void iSelectANewSize() {
        
    }

    @Then("the new size is selected")
    public void theNewSizeIsSelected() {
    }
}

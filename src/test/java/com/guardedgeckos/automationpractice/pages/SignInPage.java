package com.guardedgeckos.automationpractice.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SignInPage extends BasePage
{
    //region Variables
    private WebDriver driver;

    private static final By BY_EMAIL = new By.ById("email");
    private static final By BY_PASSWORD = new By.ById("passwd");
    private static final By BY_SIGNIN_BUTTON = new By.ById("SubmitLogin");

    private static final String DEFAULT_PASSWORD = "Password";
    //endregion

    public SignInPage(WebDriver driver)
    {
        this.driver = driver;
        this.driver.get("http://automationpractice.com/index.php?controller=authentication");
    }

    //region User Input
    public void enterPassword(String password)
    {
        driver.findElement(BY_PASSWORD).sendKeys(password);
    }

    public void enterEmail(String email)
    {
        driver.findElement(BY_EMAIL).sendKeys(email);
    }

    public void login(String email)
    {
        enterEmail(email);
        enterPassword(DEFAULT_PASSWORD);
    }

    public void login(String email, String password)
    {
        enterEmail(email);
        enterPassword(password);
    }

    public void clickSignInButton()
    {
        driver.findElement(BY_SIGNIN_BUTTON).click();
    }
    //endregion
}

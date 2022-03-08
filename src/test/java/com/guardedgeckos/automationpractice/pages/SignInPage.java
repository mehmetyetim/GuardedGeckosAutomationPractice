package com.guardedgeckos.automationpractice.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class SignInPage extends BasePage
{
    //region Variables
    protected static final String DEFAULT_URL = "http://automationpractice.com/index.php?controller=authentication";
    private static final String DEFAULT_EMAIL = "JohnSmith@gmail.com";
    private static final String DEFAULT_PASSWORD = "Password";

    private static final By BY_EMAIL = new By.ById("email");
    private static final By BY_REGISTRATION_EMAIL = new By.ById("email_create");
    private static final By BY_PASSWORD = new By.ById("passwd");
    private static final By BY_SIGNIN_BUTTON = new By.ById("SubmitLogin");
    //endregion

    //region Getters
    public String getDefaultPassword()
    {
        return DEFAULT_PASSWORD;
    }

    public String getPassword()
    {
        return driver.findElement(BY_PASSWORD).getAttribute("value");
    }

    public String getDefaultEmail()
    {
        return DEFAULT_EMAIL;
    }

    public String getEmail()
    {
        return driver.findElement(BY_EMAIL).getAttribute("value");
    }

    public String getRegistrationEmail()
    {
        return driver.findElement(BY_REGISTRATION_EMAIL).getAttribute("value");
    }
    //endregion

    //region Setters
    private void resetElement(WebElement element)
    {
        element.sendKeys(Keys.chord(Keys.CONTROL, "a", Keys.DELETE));
    }

    public void resetEmail()
    {
        resetElement(driver.findElement(BY_EMAIL));
    }

    public void resetPassword()
    {
        resetElement(driver.findElement(BY_PASSWORD));
    }

    public void resetRegistrationEmail()
    {
        resetElement(driver.findElement(BY_REGISTRATION_EMAIL));
    }

    public void resetFields()
    {
        resetEmail();
        resetPassword();
        resetRegistrationEmail();
    }
    //endregion

    //region Constructor
    public SignInPage(WebDriver driver)
    {
        super(driver, DEFAULT_URL);
    }
    //endregion

    //region User Input
    public void enterPassword(String password)
    {
        if (!getPassword().equals(""))
        {
            resetPassword();
        }

        driver.findElement(BY_PASSWORD).sendKeys(password);
    }

    public void enterEmail(String email)
    {
        if (!getEmail().equals(""))
        {
            resetEmail();
        }

        driver.findElement(BY_EMAIL).sendKeys(email);
    }

    public void enterRegistrationEmail(String email)
    {
        if (!getEmail().equals(""))
        {
            resetEmail();
        }

        driver.findElement(BY_REGISTRATION_EMAIL).sendKeys(email);
    }

    public void login(String email)
    {
        login(email, DEFAULT_PASSWORD);
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

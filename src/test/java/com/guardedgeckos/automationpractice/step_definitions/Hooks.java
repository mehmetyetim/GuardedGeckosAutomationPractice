package com.guardedgeckos.automationpractice.step_definitions;

import com.guardedgeckos.automationpractice.utilities.DriverFactory;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.time.Duration;

public class Hooks {
    static WebDriver webDriver;
    @Before
    public void setUp(Scenario scenario){
        scenario.getName();
        webDriver = DriverFactory.get();
        webDriver.manage().window().maximize();
        webDriver.get("https://automationpractice.com/");
        webDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    @After
    public void tearDown(Scenario scenario){
        if(scenario.isFailed()){
            final byte[] screenshot = ((TakesScreenshot) DriverFactory.get()).getScreenshotAs(OutputType.BYTES);
            scenario.attach(screenshot, "image/png", "screenshot");
        }
        DriverFactory.closeDriver();
    }
}

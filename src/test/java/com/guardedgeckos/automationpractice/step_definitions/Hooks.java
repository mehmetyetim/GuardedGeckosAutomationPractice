package com.guardedgeckos.automationpractice.step_definitions;

import io.cucumber.java.After;
import io.cucumber.java.Before;

public class Hooks {

    @Before
    public void setUp(){
        // setup driver

    }

    @After
    public void tearDown(){
        //take a screenshot
        // close driver
    }
}

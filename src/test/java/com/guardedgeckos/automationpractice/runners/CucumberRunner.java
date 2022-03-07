package com.guardedgeckos.automationpractice.runners;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        plugin = {"pretty", "html:target/testReport.html", "json:target/jsonReport.json"},
        features = "src/test/resources/features/",
        glue = "com/guardedgeckos/automationpractice/step_definitions",
        dryRun = false,
        publish = true,
        tags = "@signin"

)
public class CucumberRunner {
}

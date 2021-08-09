package com.navfort.runners;


import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;
@RunWith(Cucumber.class)
@CucumberOptions(
        plugin = {"json:target/cucumber.json",
                "html:target/default-html-reports",
                "rerun:target/rerun.txt",
                "pretty"},
        features = "src/test/resources/features",
        glue = "com/navfort/stepdefinitions",
        strict = true,
        dryRun =false,
        tags = "@ia22"


)
public class CukesRunner {
}

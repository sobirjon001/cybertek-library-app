package com.cybertek.library.runners;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        plugin = {
                "html:Reports/cucumber-report.html",
                "json:Reports/cucumber.json",
                "rerun:Reports/return.txt",
        },
        features = "src/test/resources/features",
        glue = "com/cybertek/library/step_definitions",
        dryRun = false
)

public class SystemTestRunner {}

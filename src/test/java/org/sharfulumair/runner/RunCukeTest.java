package org.sharfulumair.runner;


import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
        features= {"src/test/resources/features"},
        glue= {"org.sharfulumair.steps"},
        //tags="@carprices",
        plugin= {"html:target/cucumber-reports/cucumber-html-report.html",
                "com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"}
)
public class RunCukeTest extends AbstractTestNGCucumberTests {

}
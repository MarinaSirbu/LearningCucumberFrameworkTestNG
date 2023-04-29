package cucumberOptions;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.testng.annotations.DataProvider;

//html, xml, json, junit, extent
@CucumberOptions(features="src/test/java/features"
                 ,glue="stepDefinitions"
                 ,monochrome = true
                 /*,dryRun = true*/
                 ,tags = "@PlaceOrder or @OffersPage"
                 ,plugin = {"html:target/cucumber.html"
                            ,"json:target/cucumber.json"
                            ,"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"
                            ,"rerun:target/failed_scenarios.txt"})
public class TestNGTestRunner extends AbstractTestNGCucumberTests {

    @DataProvider(parallel = true)
    @Override
    public Object[][] scenarios() {
        return super.scenarios();
    }
}

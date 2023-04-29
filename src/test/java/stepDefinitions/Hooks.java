package stepDefinitions;

import io.cucumber.java.After;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Scenario;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import utils.TestContextSetup;

import java.io.File;
import java.io.IOException;

public class Hooks {
    TestContextSetup testContextSetup;

    public Hooks(TestContextSetup testContextSetup) {
        this.testContextSetup=testContextSetup;
    }

    @AfterStep
    public void addScreenshot(Scenario scenario){
        WebDriver driver = testContextSetup.testBase.webDriverManager();
        if(scenario.isFailed()){
            try {
                File file = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
                byte[] fileContent = FileUtils.readFileToByteArray(file);
                scenario.attach(fileContent, "image/png", "screenshot");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    @After
    public void afterScenario(){
        testContextSetup.testBase.webDriverManager().quit();
    }
}

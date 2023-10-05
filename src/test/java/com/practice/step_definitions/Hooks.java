package com.practice.step_definitions;

/*
In this class we will be able to create "pre" and "post" condition
for ALL the SCENARIOS and even STEPS.
 */

import com.practice.utilities.ConfigurationReader;
import com.practice.utilities.Driver;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import java.time.Duration;

public class Hooks {

    // @Before will be executed automatically after EVERY scenario in the project

    @Before(order = 1)
    // For multiple @Before methods you can prioritize them using "order"
    public void setupMethod() {
        Driver.getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        Driver.getDriver().get(ConfigurationReader.getProperty("url"));
    }

    @After
    public void teardownMethod(Scenario scenario) {
        if (scenario.isFailed()) {
            byte[] screenshot = ((TakesScreenshot) Driver.getDriver()).getScreenshotAs(OutputType.BYTES);
            scenario.attach(screenshot, "image/png", scenario.getName());
            /*
            // if(scenario.isFailed())
            // If the scenario fails, this line will return "true"

            // byte[] screenshot =
            // Creates an array of bytes to be able to store our screenshot

            // ((TakesScreenshot) Driver.getDriver())
            // Casts our ChromeDriver type to TakeScreenshot

            // getScreenshotAs(OutputType.BYTES);
            // Returns the screenshot as BYTES so we can use it

            // scenario.attach(arg1, arg2, arg3)
            // This method is able to attach the provided ss to our report
            // args1 ==> screenshot as array of bytes
            // args2 ==> image type --> "image/png"
            // args3 ==> String scenarioName --> scenario.getName()

             */
        }
        Driver.closeDriver();
    }
}

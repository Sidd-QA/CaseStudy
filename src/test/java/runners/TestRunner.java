package runners;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;


@CucumberOptions(
        glue = {"stepdefs"},
        plugin = {"pretty","com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"},
        tags = "@UITestCase_1",
        features = "src/test/resources/features/"
)


public class TestRunner extends AbstractTestNGCucumberTests {
}

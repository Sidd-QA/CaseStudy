package stepdefs;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import net.bytebuddy.implementation.FieldAccessor;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeClass;
import utils.BasePage;

public class Hooks {


@BeforeClass
    public static void setUp(){
        BasePage.setUpDriver();
    }

    @After
    public void tearDown(Scenario scenario){
        WebDriver driver= BasePage.getDriver();
        if (scenario.isFailed()){
            //Take Screenshot
            final byte[] screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
            scenario.attach(screenshot,"image/png","Screenshot");
        }
        BasePage.tearDownDriver();

    }
}

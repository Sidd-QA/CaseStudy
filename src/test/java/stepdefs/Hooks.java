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
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeClass;
import utils.BasePage;

import java.util.Collection;

public class Hooks {
    public static Collection<String> myTags;
    public static WebDriver driver;

    @Before
    public static void setUp(Scenario scenario) {
        myTags = scenario.getSourceTagNames();
        if (!myTags.contains("@APITest")) {
            driver = new ChromeDriver();
            driver.manage().window().maximize();
            BasePage.setDriver(driver);
        }
    }


    @After
    public void tearDown(Scenario scenario) {
        if (scenario.isFailed()) {
            //Take Screenshot if scenario failed
            final byte[] screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
            scenario.attach(screenshot, "image/png", "Screenshot");
        }
        // This method is to tear down the driver after execution
        if (driver != null) {
            driver.close();
            driver.quit();
            driver = null;
        }
    }
}

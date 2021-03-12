package pages.actions;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.testng.Assert;
import utils.BasePage;

public class HomePageActions extends BasePage {
    private Logger logger;
    private By textSuperUser;
    private By linkRegisteredPatient;

    public HomePageActions() {
        super();
        initElement();

    }

    public void initElement() {
        logger = LogManager.getLogger(HomePageActions.class);
        textSuperUser = By.xpath("//h4[contains(text(),'Logged in as Super User')]");
        linkRegisteredPatient = By.xpath("//a[normalize-space()='Register a patient']");
    }

    //This method is to click register a patient link
    public void clickRegisterAPatientLink() {
        logger.info("Clicking Register A Patient link.");
        click(linkRegisteredPatient);
        letMeFinishLoading();
    }

    //This method is to verify user is logged in successfully
    public void verifyUserLoggedIn(String expectedString) {
        logger.info("Verifying user is logged in successfully.");
        Assert.assertTrue(verifyActualContainsExpected(getTextFromElement(textSuperUser), expectedString));
    }
}

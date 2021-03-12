package stepdefs;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.actions.HomePageActions;
import utils.ConfigFileReader;

public class HomePageSteps {
    HomePageActions homePageActions = new HomePageActions();
    private final String propertyFilePath = "CommonTestData.properties";
    ConfigFileReader configFileReader = new ConfigFileReader(propertyFilePath);

    @Then("I verify user is logged in as super user")
    public void iVerifyUserIsLoggedInAsSuperUser() {
        homePageActions.verifyUserLoggedIn(configFileReader.getProperties().getProperty(("textLoggedInAsSuperUser")));
    }

    @When("I select register patient option")
    public void iSelectRegisterPatientOption() {
        homePageActions.clickRegisterAPatientLink();
    }
}

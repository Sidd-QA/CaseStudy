package stepdefs;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import pages.actions.LoginPageActions;
import utils.ConfigFileReader;

public class LoginPageSteps  {
    LoginPageActions loginPageActions = new LoginPageActions();
    private final String propertyFilePath = "CommonTestData.properties";
    ConfigFileReader configFileReader = new ConfigFileReader(propertyFilePath);


    @Given("I am on OpenMRS applications login page")
    public void iAmOnOpenMRSApplicationsLoginPage() {
        loginPageActions.navigateToApplication(configFileReader.getProperties().getProperty("applicationURL"));
    }

    @When("I enter admin username")
    public void iEnterAdminUsername() {
        loginPageActions.enterUsername(configFileReader.getProperties().getProperty("username"));
        
    }

    @And("I enter admin password")
    public void iEnterAdminPassword() {
        loginPageActions.enterPassword(configFileReader.getProperties().getProperty("password"));
    }

    @And("I select Registration Desk as option")
    public void iSelectRegistrationDeskAsOption() {
        loginPageActions.selectRegistrationDeskOption();
    }

    @And("I click on Login button")
    public void iClickOnLoginButton() {
        loginPageActions.clickLoginButton();
    }


}

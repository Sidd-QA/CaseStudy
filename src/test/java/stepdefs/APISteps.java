package stepdefs;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.actions.GETAPIActions;
import utils.ConfigFileReader;

public class APISteps {

    GETAPIActions getapiActions = new GETAPIActions();
    private final String propertyFilePath = "CommonTestData.properties";
    ConfigFileReader configFileReader = new ConfigFileReader(propertyFilePath);
    public static String baseURL;

    @Given("I set the base API request {string}")
    public void iSetTheBaseAPIRequest(String url) {
        baseURL = getapiActions.setBaseURL(url);
    }

    @When("I send the request to get all the repositories of user")
    public void iSendTheRequestToGetAllTheRepositoriesOfUser() {
        String requestURL= baseURL+configFileReader.getProperties().getProperty("getRepos");
        getapiActions.sendRequest(requestURL);

    }

    @Then("I validate response status code is {string}")
    public void iValidateResponseStatusCodeIs(String code) {
        getapiActions.validateStatusCode(code);
        getapiActions.validateContentOfResponse(configFileReader.getProperties().getProperty("repositoryName"));
    }
}

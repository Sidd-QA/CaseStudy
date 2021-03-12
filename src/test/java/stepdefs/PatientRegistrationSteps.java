package stepdefs;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.actions.PatientRegistrationActions;
import utils.BasePage;
import utils.ConfigFileReader;

public class PatientRegistrationSteps extends BasePage {
    private final String propertyFilePath = "CommonTestData.properties";
    ConfigFileReader configFileReader = new ConfigFileReader(propertyFilePath);
    PatientRegistrationActions patientRegistrationActions = new PatientRegistrationActions();

    @When("I enter patients full name")
    public void iEnterPatientsFullName() {
        patientRegistrationActions.enterGivenName(randomStringGenerator(5));
        patientRegistrationActions.enterMiddleName(randomStringGenerator(3));
        patientRegistrationActions.enterFamilyName(randomStringGenerator(4));
    }

    @And("I click next button on patients registration form")
    public void iClickNextButtonOnPatientsRegistrationForm() {
        patientRegistrationActions.clickNextButton();
    }

    @And("I select patient's gender type")
    public void iSelectPatientSGenderType() {
        patientRegistrationActions.selectGenderOption("M");
    }

    @And("I enter patient's DOB details")
    public void iEnterPatientSDOBDetails() {
        patientRegistrationActions.enterBirthDay("1");
        patientRegistrationActions.selectBirthMonth("1");
        patientRegistrationActions.enterBirthYear("1990");
        
    }

    @And("I enter patient's address details")
    public void iEnterPatientSAddressDetails() {
        patientRegistrationActions.enterAddress1(randomStringGenerator(7));
        patientRegistrationActions.enterAddress2(randomStringGenerator(5));
        patientRegistrationActions.enterCity(randomStringGenerator(5));
        patientRegistrationActions.enterState(randomStringGenerator(2));
        patientRegistrationActions.enterCountry(randomStringGenerator(5));
        patientRegistrationActions.enterPostalCode(randomNumberGenerator(6));
        
    }

    @And("I enter patient's phone number")
    public void iEnterPatientSPhoneNumber() {
        patientRegistrationActions.enterPhoneNumber(randomNumberGenerator(10));
        
    }

    @And("I enter patient's relatives details")
    public void iEnterPatientSRelativesDetails() {
        patientRegistrationActions.selectRelationshipType(3);
        patientRegistrationActions.enterPersonName(randomStringGenerator(5));

    }

    @Then("I verify patient's details before submitting form")
    public void iVerifyPatientSDetailsBeforeSubmittingForm() {
        patientRegistrationActions.verifyPatientNameBeforeSubmittingForm();
        patientRegistrationActions.verifyPatientPhoneNumBeforeSubmittingForm();
    }

    @When("I click on submit registration form button")
    public void iClickOnSubmitRegistrationFormButton() {
        patientRegistrationActions.clickSubmitButton();

    }

    @Then("I verify patient is registered successfully")
    public void iVerifyPatientIsRegisteredSuccessfully() {
        patientRegistrationActions.verifyPatientRegisteredSuccessfully();
    }

    @Then("I verify patient registration form is displayed")
    public void iVerifyPatientRegistrationFormIsDisplayed() {
        patientRegistrationActions.verifyRegisterAPatientText("Register a patient");
    }
}

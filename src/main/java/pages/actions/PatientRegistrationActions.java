package pages.actions;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.testng.Assert;
import utils.BasePage;

public class PatientRegistrationActions extends BasePage {
    private Logger logger;
    private By textRegisterAPatient;
    private By inputGivenName;
    private By inputMiddleName;
    private By inputFamilyName;
    private By checkboxUnidentifiedPatient;
    private By buttonNext;
    private By selectGenderOption;
    private By inputBirthDay;
    private By selectBirthMonth;
    private By inputBirthYear;
    private By inputAddress1;
    private By inputAddress2;
    private By inputCity;
    private By inputState;
    private By inputCountry;
    private By inputPostalCode;
    private By inputPhoneNumber;
    private By selectRelationshipType;
    private By inputPersonName;
    private By verifyName;
    private By verifyPhoneNumber;
    private By buttonSubmit;
    private By textPersonGivenName;
    public static String givenName;
    public static String phoneNumber;


    public PatientRegistrationActions() {
        super();
        initElement();
    }

    public void initElement() {
        logger = LogManager.getLogger(PatientRegistrationActions.class);
        textRegisterAPatient = By.xpath("//div[@class='container-fluid']//h2");
        inputGivenName = By.xpath("//input[@name='givenName']");
        inputMiddleName = By.xpath("//input[@name='middleName']");
        inputFamilyName = By.xpath("//input[@name='familyName']");
        checkboxUnidentifiedPatient = By.xpath("//input[@type='checkbox']");
        buttonNext = By.xpath("//button[@class='confirm right']");
        selectGenderOption = By.xpath("//select[@id='gender-field']");
        inputBirthDay = By.xpath("//input[@id='birthdateDay-field']");
        selectBirthMonth = By.xpath("//select[@id='birthdateMonth-field']");
        inputBirthYear = By.xpath("//input[@id='birthdateYear-field']");
        inputAddress1 = By.xpath("//input[@name='address1']");
        inputAddress2 = By.xpath("//input[@name='address2']");
        inputCity = By.xpath("//input[@name='cityVillage']");
        inputState = By.xpath("//input[@name='stateProvince']");
        inputCountry = By.xpath("//input[@name='country']");
        inputPostalCode = By.xpath("//input[@name='postalCode']");
        inputPhoneNumber = By.xpath("//input[@name='phoneNumber']");
        selectRelationshipType = By.xpath("//select[@name='relationship_type']");
        inputPersonName = By.xpath("//input[@placeholder='Person Name']");
        verifyName = By.xpath("//div[@id='dataCanvas']//p[1]");
        verifyPhoneNumber = By.xpath("//div[@id='confirmation']//p[5]");
        buttonSubmit = By.xpath("//input[@id='submit']");
        textPersonGivenName = By.xpath("//span[@class='PersonName-givenName']");

    }

    // This method is to enter patient's given name on registration form
    public void enterGivenName(String name) {
        logger.info("Entering patient's given name.");
        enterText(name, inputGivenName);
        givenName = name;
    }

    // This method is to enter patient's middle name on registration form
    public void enterMiddleName(String middleName) {
        logger.info("Entering patient's middle name.");
        enterText(middleName, inputMiddleName);
    }

    // This method is to enter patient's family name on registration form
    public void enterFamilyName(String familyName) {
        logger.info("Entering patient's family name.");
        enterText(familyName, inputFamilyName);
    }

    // This method is to enter patient's birth day on registration form
    public void enterBirthDay(String birthDay) {
        logger.info("Entering patient's birth day.");
        enterText(birthDay, inputBirthDay);
    }

    // This method is to enter patient's birth year on registration form
    public void enterBirthYear(String birthYear) {
        logger.info("Entering patient's birth day.");
        enterText(birthYear, inputBirthYear);
    }

    // This method is to enter patient's address1 on registration form
    public void enterAddress1(String address1) {
        logger.info("Entering patient's address1.");
        enterText(address1, inputAddress1);
    }

    // This method is to enter patient's address2 on registration form
    public void enterAddress2(String address2) {
        logger.info("Entering patient's address2.");
        enterText(address2, inputAddress2);
    }

    // This method is to enter patient's city on registration form
    public void enterCity(String city) {
        logger.info("Entering patient's city.");
        enterText(city, inputCity);
    }

    // This method is to enter patient's state on registration form
    public void enterState(String state) {
        logger.info("Entering patient's state.");
        enterText(state, inputState);
    }

    // This method is to enter patient's country on registration form
    public void enterCountry(String country) {
        logger.info("Entering patient's country.");
        enterText(country, inputCountry);
    }

    // This method is to enter patient's postal code on registration form
    public void enterPostalCode(String postalCode) {
        logger.info("Entering patient's address2.");
        enterText(postalCode, inputPostalCode);
    }

    // This method is to enter patient's phone number on registration form
    public void enterPhoneNumber(String phNum) {
        logger.info("Entering patient's phone number.");
        phoneNumber = phNum;
        enterText(phoneNumber, inputPhoneNumber);
    }

    // This method is to enter patient's person name on registration form
    public void enterPersonName(String personName) {
        logger.info("Entering patient's phone person name.");
        enterText(personName, inputPersonName);
    }

    // This method is to select birth month on registration form
    public void selectBirthMonth(String value) {
        logger.info("Selecting patient's birth month.");
        selectByValueInDropdown(selectBirthMonth, value);
    }

    //selectRelationshipType
    // This method is to select relationship type on registration form
    public void selectRelationshipType(int value) {
        logger.info("Selecting relationship with patient type.");
        selectByIndexInDropDown(selectRelationshipType, value);
    }

    //selectGenderOption
    // This method is to select relationship type on registration form
    public void selectGenderOption(String value) {
        logger.info("Selecting patient's gender type.");
        selectByValueInDropdown(selectGenderOption, value);
    }

    // This method is to select unidentified checkbox on patient registration form
    public void selectUnidentifiedCheckbox() {
        logger.info("Selecting unidentified checkbox on patient registration form.");
        click(checkboxUnidentifiedPatient);
    }

    // This method is to click on next button on patient registration form
    public void clickNextButton() {
        logger.info("Clicking on next button on patient registration form.");
        click(buttonNext);
    }

    // This method is to click on submit button on patient registration form
    public void clickSubmitButton() {
        logger.info("Clicking on submit button on patient registration form.");
        click(buttonSubmit);
        letMeFinishLoading();
    }

    // This method is to verify 'Register A Patient' text on page
    public void verifyRegisterAPatientText(String expectedText) {
        logger.info("Verifying text: Register A Patient");
        Assert.assertTrue(verifyActualContainsExpected(getTextFromElement(textRegisterAPatient), expectedText), "Register A Patient Text");
    }

    // This method is to verify patient's name before submitting form
    public void verifyPatientNameBeforeSubmittingForm() {
        logger.info("Verifying patient's name before submitting form");
        Assert.assertTrue(verifyActualContainsExpected(getTextFromElement(verifyName), givenName), "Patient's Name");
    }

    // This method is to verify patient's phone number before submitting form
    public void verifyPatientPhoneNumBeforeSubmittingForm() {
        logger.info("Verifying patient's phone number before submitting form");
        Assert.assertTrue(verifyActualContainsExpected(getTextFromElement(verifyPhoneNumber), phoneNumber), "Patient's Phone Number");
    }

    // This method is to verify patient registered successfully
    public void verifyPatientRegisteredSuccessfully() {
        logger.info("Verifying patient registered successfully");
        Assert.assertTrue(verifyActualContainsExpected(getTextFromElement(textPersonGivenName), givenName), "Patient Registration Success");
    }
}

@UITestCase_1
  Feature: This feature is POC for UI automation test cases
    Scenario: This scenario is for sample UI automation to submit a patient registration form
      Given I am on OpenMRS applications login page
      When I enter admin username
      And I enter admin password
      And I select Registration Desk as option
      And I click on Login button
      Then I verify user is logged in as super user
      When I select register patient option
      Then I verify patient registration form is displayed
      When I enter patients full name
      And I click next button on patients registration form
      And I select patient's gender type
      And I click next button on patients registration form
      And I enter patient's DOB details
      And I click next button on patients registration form
      And I enter patient's address details
      And I click next button on patients registration form
      And I enter patient's phone number
      And I click next button on patients registration form
      And I enter patient's relatives details
      And I click next button on patients registration form
      Then I verify patient's details before submitting form
      When I click on submit registration form button
      Then I verify patient is registered successfully
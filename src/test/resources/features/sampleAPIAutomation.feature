@APITest
Feature: This feature is to test a sample GITHUB API
  Scenario Outline: This scenario is to test sample GET call to retrieve all public repositories of a user
    Given I set the base API request "<URL>"
    When I send the request to get all the repositories of user
    Then I validate response status code is "<StatusCode>"

    Examples:
    |URL                             |StatusCode|
    |  https://api.github.com/users/ |200       |


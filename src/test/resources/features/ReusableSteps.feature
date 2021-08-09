Feature: This is not a scenario, created to hold reusable steps
  @smoke
  Scenario:
    Given the user clicks on "anyButton"
    And the user fills in the blanks with data below
    |key  |value|
    And the user navigates to "module" "submodule"
    And the user logs in using "username" and "password"
    And click on the manage filters button and select "columnName"

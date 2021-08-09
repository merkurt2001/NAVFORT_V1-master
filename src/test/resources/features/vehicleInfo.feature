@ia22
Feature: Vehicle Info


  Scenario:US008 TC1 The user will see Vehicle info
    Given the user logged in as "sales manager"
    Then the user verify the title "Dashboard"
    And the user navigates to "Fleet" "Vehicles"
    Then the title contains "Car - Entities"
    When the user clicks "Plate value"
    Then the title will be "General Information"

  Scenario:US008-TC2-change page number
    Given the user logged in as "sales manager"
    And the user navigates to "Fleet" "Vehicles"
    Then the title contains "Car - Entities"
    When the user clicks "Plate value"
    Then the title will be "General Information"
    When the user clicks on the top right "arrow" button
    Then the user will see value "2"

# TEST CASE 3 WILL BE CREATED IN JIRA****IMPORTANT *******
  Scenario Outline:US008 TC3 the user should be able to change entity number
    Given the user logged in as "sales manager"
    And the user navigates to "Fleet" "Vehicles"
    Then the title contains "Car - Entities"
    When the  the user clicks  "<View Per Page>" dropdown button

    Examples:
      | View Per Page |
      | 10            |
      | 25            |
      | 50            |
      | 100           |


  Scenario:US-008 TC4 the user should get info of cars to his email by using Export Grid
    Given the user logged in as "sales manager"
    And the user navigates to "Fleet" "Vehicles"
    Then the title contains "Car - Entities"
    When the user should navigate "Export Grid" "CVS"
    Then the user should see the message contains "successfully"
    And the user should click the "XLSX" button
    Then the user should see the message contains "successfully"

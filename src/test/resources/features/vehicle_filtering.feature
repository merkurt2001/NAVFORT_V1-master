@NAV-174
Feature:


  @NAV-162 @NAV-175 @http://qa.navfort.com/
  Scenario: US26_TC1_Truck driver can use Grid Settings button
    Given the user logged in as "driver"
    When the user navigates to "Fleet" "Vehicle Costs"
    Then the title contains "Car - Entities"
    When the user clicks on the "Grid Settings" button
    And the user selects the "License Plate" option
    Then the table contains "License Plate"


  @NAV-163 @NAV-175 @http://qa.navfort.com/
  Scenario: US26_TC2_Checking all filtering options for "Type"

    Given the user logged in as "driver"
    When the user navigates to "Fleet" "Vehicle Costs"
    And the user clicks on the "Filters" button
    And click on the Manage filters button and select "Type"
    And click on "Type" and verify below options
      | Total Price |
      | Date        |


  @NAV-164 @NAV-175 @http://qa.navfort.com/
  Scenario: US26_TC3_Truck driver can refresh the page by using Refresh button
    Given the user is on the login page
    When the user logs in using "user1" and "UserUser123"
    And the user navigates to "Fleet" "Vehicle Costs"
    And the user clicks on the "Refresh" button


  @NAV-165 @NAV-175 @http://qa.navfort.com/
  Scenario: US26_TC4_Truck driver can reset the filtering settings by using Reset button"
    Given the user is on the login page
    When the user logs in using "user1" and "UserUser123"
    And the user navigates to "Fleet" "Vehicle Costs"
    And the user clicks on the "Reset" button
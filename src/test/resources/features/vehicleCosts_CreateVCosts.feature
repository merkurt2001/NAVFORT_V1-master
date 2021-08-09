Feature:

  @NAV-186 @hww
  Scenario: Creating vehicle cost as a truck driver
    Given the user logged in as "driver"
    When the user navigates to "Fleet" "Vehicle Costs"
    And the user clicks on "Create Vehicle Costs" button
    And the user selects the "Snow tires" option
    And the user sent keys to "Total Price" field as "1000"
    And the user choose date as "Today"
    And click save and close button
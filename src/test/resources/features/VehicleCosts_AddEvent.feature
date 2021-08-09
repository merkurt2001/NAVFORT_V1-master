Feature: Vehicle Costs Add Event

  @NAV-166 @NAV-185
  Scenario: US31 TC1 As a Driver I should be able to add event
    Given the user is on the login page
    And the user enters the driver information
    When the user navigates to "Fleet" "Vehicle Costs"
    And the user selects the "Tax Roll" row
    Then the user should see "Add an event to this record" button

  @NAV-183 @NAV-185
  Scenario: US31 TC2 Driver can add new event
    Given the user is on the login page
    And the user enters the driver information
    When the user navigates to "Fleet" "Vehicle Costs"
    And the user selects the "Road Assistance" row
    When the user clicks on Add Event button
    And the user fills in the blanks with data below
      | Title                  | Breakdown Rescue                                   |
      | Organizer display name | Nergz Company                                      |
      | Organizer email        | nergz.groups@org.com                               |
    Then the user clicks on save button
    And verify "Breakdown Rescue" is displayed

    


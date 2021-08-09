Feature: Vehicle Add Event

  @vae
  Scenario Outline:
    Given the user is on the login page
    When the user logs in using "<username>" and "<password>"
    And the user navigates to "Fleet" "Vehicles"
    And the user selects the vehicle with licence plate "<plateNumber>"
    And the user clicks on Add Event button
    Then the user verifies add event page
    When  the user fills title as "<title>" and description as "<description>"
    And the user clicks on save button
    Then the user should see "Calendar event saved" message

    Examples:
      | username       | password    | title  | description  | plateNumber |
      | storemanager61 | UserUser123 | title1 | description1 | VA12345     |
      | salesmanager101   | UserUser123 | title2 | description2 | VA12345     |
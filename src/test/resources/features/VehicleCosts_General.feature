Feature: Generral

  Scenario: Driver can see general information of specific cost with ... button
    Given the user is on the login page
    When the user logs in using "user1" and "UserUser123"
    And the user navigates to "Fleet" "Vehicle Costs"
    Then the user should verify subtitle as "Vehicle Costs"
    When the user clicks on ...
    And the user selects "eye" sign
    Then the user should verify subtitle as "Item #1"


  Scenario: Driver can not delete vehicle cost in ... button
    Given the user is on the login page
    When the user logs in using "user1" and "UserUser123"
    And the user navigates to "Fleet" "Vehicle Costs"
    Then the user should verify subtitle as "Vehicle Costs"
    When the user clicks on ...
    And the user selects "bin" sign
    And the user accept the pop up
    Then the user verifies "You do not have permission to perform this action." message

  Scenario: Driver can not edit vehicle cost in ... button
    Given the user is on the login page
    When the user logs in using "user1" and "UserUser123"
    And the user navigates to "Fleet" "Vehicle Costs"
    Then the user should verify subtitle as "Vehicle Costs"
    When the user clicks on ...
    And the user selects "pencil" sign
    Then the user verifies "You do not have permission to perform this action." message





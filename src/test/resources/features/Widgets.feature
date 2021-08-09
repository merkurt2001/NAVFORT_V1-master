@ia22
Feature: use sidebar widget, pins and favourite pages


  Scenario Outline:US-35 TC001 Using plus sign to add widgets
    Given the user logged in as "sales manager"
    Then the user verify the title "Dashboard"
    When the user navigates to "Fleet" "Vehicles"
    Then the title contains "Car - Entities"
    When the user clicks on the plus button
    Then the value of "<sideBarWidgets>" is increased by one when the user clicks on the add button near "<sideBarWidgets>"
    Examples:
      | sideBarWidgets |
      | Recent emails  |
      | Sticky Note    |
      | Task List      |
#dsdsdsgfj

  Scenario:US35 TC002 The User Can pin the page
    Given the user logged in as "sales manager"
    When the user navigates to "Fleet" "Vehicles"
    Then the title contains "Car - Entities"
    When the user clicks on the top "Pin" button
    Then the pin holder is the same as the page title



  Scenario:US35 TC003 The User can make the page favourite by using favourite sign
    Given the user logged in as "sales manager"
    When the user navigates to "Fleet" "Vehicles"
    Then the title contains "Car - Entities"
    When the user clicks on the "Favorites" button
    Then the title is the same as the page title





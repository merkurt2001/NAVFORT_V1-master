Feature:    Authorised users should be able to create new car

  @NewCar
  Scenario: Create car as a storemanager
    Given   the user is on the login page
    When  the user logs in using "storemanager61" and "UserUser123"
    And the user navigates to "Fleet" "Vehicles"
    And  the user clicks on create car button


    When the user fills in the blank with data below
      | License Plate | 19189       |
      | Tags          | Junior      |
      | Driver        | Hersh Zrari |
      | Location      | Kurdistan   |
      | Model Year    | 2011        |
      | Last Odometer | 20290       |
      | Seats Number  | 5           |
      | Doors Number  | 4           |
      | Color         | Red         |
      | Transmission  | Automatic   |
      | Fuel Type     | Diesel      |
#
#    When click the +Add button of the Vehicle Model
#    And the user should see following model options
#
#      | Rouge   |
#      | Mazda   |
#      | Enzo    |
#      | Model S |

    Then click save and close button
#    And the user navigates to "Fleet", "Vehicles"
#    And  the title contains "Dashboard "
#    Then verify the car with license number " 19189 " is displayed









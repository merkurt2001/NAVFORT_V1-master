@NAV-194
Feature: 

	#{color:#00875a}*User Story :* {color}
	#
	#As a Truck Driver I should be able to use all filtering functions
	#
	# 
	#
	#{color:#de350b}*_Acceptance Criterias:_*{color}
	#
	#1-Truck driver can use Grid Settings button for arranging demanded columns.
	# 2-Truck driver can use Filters sign with opening Manage Filters button for filtering informations
	# 3-Truck driver can refresh the page by using Refresh button
	# 4-Truck driver can reset the filtering settings by using Reset button"
	@NAV-162 @NAV-193 @NAV-175 @http://qa.navfort.com/
	Scenario: US26_TC1_Truck driver can use Grid Settings button
		Given the user logged in as "driver"
		When the user navigates to "Fleet" "Vehicle Costs"
		When the user clicks on the "Grid Settings" button
		And the user selects the "Total Price" option
		Then the table contains "Total Price"	

	#{color:#00875a}*User Story :* {color}
	#
	#As a Truck Driver I should be able to use all filtering functions
	#
	# 
	#
	#{color:#de350b}*_Acceptance Criterias:_*{color}
	#
	#"1-Truck driver can use Grid Settings button for arranging demanded columns.
	#2-Truck driver can use Filters sign with opening Manage Filters button for filtering informations
	#3-Truck driver can refresh the page by using Refresh button
	#4-Truck driver can reset the filtering settings by using Reset button"
	@NAV-163 @NAV-193 @NAV-175 @http://qa.navfort.com/
	Scenario: US26_TC2_Checking all filtering options for "Type"
		
		Given the user logged in as "driver"
		When the user navigates to "Fleet" "Vehicle Costs"
		And the user clicks on the "Filters" button
		And click on the Manage filters button and select "Type"
		And click on "Type" and verify below options
		| Total Price      |
		| Date             |
			

	#* 
	#"1-Truck Driver can add event by using Add Event button
	#2-Truck Driver should see the update in both general information page and Activity tab related
	#add event."
	# 
	@NAV-183 @NAV-193 @NAV-185
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

	
	@NAV-186 @NAV-193 @NAV-191
	Scenario: US-029_TC1 Creating vehicle cost as a truck driver
		Given the user logged in as "driver"
		When the user navigates to "Fleet" "Vehicle Costs"
		And the user clicks on "Create Vehicle Costs" button
		And the user selects the "Snow tires" option
		And the user sent keys to "Total Price" field as "1000"
		And the user choose date as "Today"
		And click save and close button	

	#{color:#00875a}*User Story :* {color}
	#
	#As a Truck Driver I should be able to use all filtering functions
	#
	# 
	#
	#{color:#de350b}*_Acceptance Criterias:_*{color}
	#
	#1-Truck driver can use Grid Settings button for arranging demanded columns.
	#2-Truck driver can use Filters sign with opening Manage Filters button for filtering informations
	#3-Truck driver can refresh the page by using Refresh button
	#4-Truck driver can reset the filtering settings by using Reset button
	@NAV-157 @NAV-193 @VYT43-175 @NAV-144
	Scenario Outline: US106_TC? Checking all filtering options for "Tags"
		Given the user logged in as "<usertype>"
		When the user navigates to "Fleet" "Vehicles"
		And select the filtering button
		And click on the manage filters button and select "Tags"
		And click on "Tags" and verify below options
		| Is any of        |
		| Is not any of    |
		Examples:
		| usertype      |
		| sales manager |
		| store manager |

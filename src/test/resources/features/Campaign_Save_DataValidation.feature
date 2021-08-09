@NAV-170
Feature: Campaign Create Data validation

	@NAV-167 @NAV-169
	Scenario: US-44 TC1 Name field accept valid data (positive scenario)
		Given the user is on the login page
		When the user logs in using "storemanager52" and "UserUser123"
		And the user navigates to "Marketing" "Campaigns"
		When the user clicks on "Create Campaign" button
		Then the subtitle changes to "Create Campaign"
		And the user sent keys to "Name" field as "IBM"
		When the user clicks on "Save" button
		Then there should be NO warning message under "Name" field	


	@NAV-171 @NAV-169
	Scenario: US-44 TC2 Budged field accept valid data(positive scenario)
		Given the user is on the login page
		When the user logs in using "storemanager52" and "UserUser123"
		And the user navigates to "Marketing" "Campaigns"
		When the user clicks on "Create Campaign" button
		And the subtitle changes to "Create Campaign"
		And the user sent keys to "Budged" field as "123"
		When the user clicks on "Save" button
		Then there should be NO warning message under "Budged" field


	@NAV-172 @NAV-169
	Scenario Outline: US-44 TC3 Code field accepts valid data (positive scenario)
		Given the user is on the login page
		When the user logs in using "storemanager52" and "UserUser123"
		And the user navigates to "Marketing" "Campaigns"
		When the user clicks on "Create Campaign" button
		And the subtitle changes to "Create Campaign"
		And the user sent keys to "Code" field as "<value>"
		When the user clicks on "Save" button
		Then there should be NO warning message under "Code" field
		Examples:
		| value  |
		| 123    |
		| abc    |
		| abc123 |	


	@NAV-173 @NAV-169
	Scenario Outline: US-44 TC4 Name field accept invalid data (negative scenario)
		Given the user is on the login page
		When the user logs in using "storemanager52" and "UserUser123"
		And the user navigates to "Marketing" "Campaigns"
		When the user clicks on "Create Campaign" button
		And the subtitle changes to "Create Campaign"
		And the user sent keys to "<fieldName>" field as "<value>"
		When the user clicks on "Save" button
		Then the user verifies the message as "<message>" under "<fieldName>"
		Examples:
		| fieldName | value                   | message                                                        |
		| Name      | more than 100 character | This value is too long. It should have 100 characters or less. |
		| Name      |                         | This value should not be blank.                                |
		| Name      | 123                     | This value should not be numeric.                              |
		| Code      | more than 20 character  | This value is too long. It should have 20 characters or less.  |
		| Code      |                         | This value should not be blank.                                |
		| Budged    | asds                    | This value should be a valid number.                           |
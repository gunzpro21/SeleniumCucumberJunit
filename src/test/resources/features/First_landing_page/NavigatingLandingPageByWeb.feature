Feature: “Choose your university” Tests
Description: The purpose of this feature is to test “Choose your university” by clicking an university icon.

 Background: User is HomePage
	Given user goes to Home Page
	
Scenario: navigating landing page
	When 	user have clicked “Choose your university” on Main page
	Then 	the First landing page is loaded
	And 	the searching textbox is blank

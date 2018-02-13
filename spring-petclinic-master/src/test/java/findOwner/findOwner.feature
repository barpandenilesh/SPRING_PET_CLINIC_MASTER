Feature: findOwner
#This is how background can be used to eliminate duplicate steps
Background:
User navigates to ownerlink
Given I am on petclinic find owner page
#Scenario with AND
Scenario:
When I enter owner Last name as "Pence"
And I click on FindOwner button
Then message Owner Information display 
#Scenario with BUT
Scenario:
When I enter owner Last name as "Y"
And I click on FindOwner button
Then message has not been found display
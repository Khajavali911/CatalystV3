#Author: your.email@your.domain.com
#Keywords Summary :
#Feature: List of scenarios.
#Scenario: Business rule through list of steps with arguments.
#Given: Some precondition step
#When: Some key actions
#Then: To observe outcomes or validation
#And,But: To enumerate more Given,When,Then steps
#Scenario Outline: List of steps for data-driven as an Examples and <placeholder>
#Examples: Container for s table
#Background: List of steps run before each of the scenarios
#""" (Doc Strings)
#| (Data Tables)
#@ (Tags/Labels):To group Scenarios
#<> (placeholder)
#""
## (Comments)
#Sample Feature Definition Template
@tag
Feature: ericbank andriod sample 
  I want to use this template for my feature file

   @ericbank
  Scenario Outline: Ericbank Make Payment
    Given I want to launch ericbank app
    And I enter  <usernane> and <password>
    And I click loginbutton       
    And I click on make payment
    And I entered phnumber
    And I entered candidtename <name> 
    And Select country <cntry>
    And I click on  send payment button
    Then Verify for successful payment

    Examples: 
      | usernane  | password |name|cntry|
      | company   |   company|Khaja|India|

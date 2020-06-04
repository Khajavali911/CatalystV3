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
@smoke
Feature: Pet related operations
  I want to use this template for my feature file
  @availablepetlist
  Scenario: Get the list of availble pets list
    Given I perform GET operation for "/pet/findByStatus?status=available"
    Then I should get availble pet list
  
  @Deletepet 
  Scenario: Verify DELETE operation after POST
    Given I ensure to Perform POST operation for "/pet" with body as
     | id |  name|status|
     | 9199424981609320000 | rabit |Available|
    And  I Perform DELETE operation for "/pet/{id}/"
     | id | 
     | 9199424981609320000 | 
    And I perform GET operation with path parameter for "/pet/{id}"
     | id | 
     | 9199424981609320000 | 
  #  Then I "should not" see the body with title as "API Testing course"
  
  @verifypet
  Scenario: verify for pet in
     Given I perform GET operation for "/pet/9194"
    # Then I should see the pet name as "doggy9194"
     
  @Updatepet
  Scenario: update the pet details
    
     Given I ensure to Perform POST operation for "/pet" with body as
      | id |  name|status|
      | 9199424981609320000 | rabit |Available|
     #Then I should see the pet name as "rabit"
     
      
   

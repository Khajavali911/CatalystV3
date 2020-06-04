@Elsevier
Feature: Elsevier Search Book
	
	Scenario Outline: Elsevier add product to cart
	Given Open chrome browser and enter url
	 And I enter  <usernane> and <password>
#	When Click on the signin button
	And Enter the User credentials	
	And Click on the Shop and Discover tab in the menu bar
	Then Click on the  Books and Journals	 
	And Search the java books
	And Get the result products list 
	Then Click on the first item in the serach result
	Examples: 
      | usernane  | password |name|cntry|
      | company   |   company|Khaja|India|
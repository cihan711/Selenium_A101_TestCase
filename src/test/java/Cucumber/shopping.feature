Feature: Find product and add basket



Scenario Outline: Search and Find product
Given Initialize the browser with chrome
When user enter homepage without regsiter and user click woman black sock
Then Verify black sock



Scenario Outline: Add procduct to Basket page
Given Contiune from product page 
When user add basket this product and user look basket page and aprove basket and user contiunue and enter <email> adress
Then user direct address area

Examples:
|email                            |       
|test140@gmail.com   |


Scenario Outline: Save users Address
Given Contiunue from basket page
When user write address information 
Then user direct payment area


Scenario Outline: Check payment page
When user check payment page title
Then user complete shopping



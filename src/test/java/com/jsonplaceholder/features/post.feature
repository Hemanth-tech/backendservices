Feature: Validate Post 

Background:
Given the JsonPlaceHolder Post API is available

Scenario: Create a new post successfully
		Given user has "Valid" payload to create POST
		When user make a POST request
		Then the "Createsponse" should contain posted data
		
Scenario: Retrieve newly created post
		When user retrievs post
		Then the "retrivedResponse" should contain posted data
    
 Scenario: Update existing post
    Given user update the "title" as "JsonPlaceHolder test title"
    When user retrievs post
    Then the response should contain updated "title" as "JsonPlaceHolder test title"
     
Scenario: Updated deleted post
Given user deleted post with below deatils
  | PostID | 3      | 
When user tries to update the deleted post
Then user should receive error message for "updating deleted post"

Scenario: Retrieve Deleted  post
    When user tries to retrieve the deleted post
    Then user should receive error message for "Retrieving deleted  posts"

Scenario Outline: Retrieve posts of deleted users
Given user delets the account with id <userId>
When user retrive post of user with id <userId>
Then user should receive error message for "Retrieving deleted user posts"
Examples:
  | userId | 
  | 3      | 
  | 4      | 

Scenario: Create a new post with invalid paylaod
		Given user has "InValid" payload to create POST
		When user make a POST request
		Then user should receive error message for "Invalid Paylaod"





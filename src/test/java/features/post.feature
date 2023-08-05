Feature: Validate Post 


Scenario: Create a new post successfully
Given user has valid payload to create POST
When user make a POST request
Then the API should respond with 201 status code
And the response should contain posted data
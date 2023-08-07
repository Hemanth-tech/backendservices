Feature: Validate Post 


Scenario: Create a new post successfully
Given user has "Valid" payload to create POST
When user make a POST request
Then the API should respond with "Created" status message
And the response should contain posted data



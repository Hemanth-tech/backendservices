Feature: Validate Post 


Scenario: Create a new post successfully
Given the JSONPlaceholder API is up and running
When I make a POST request to the endpoint '/posts' with the following data:
  | Field      | Value                                   |
  | userId     | 1                                       |
  | title      | BDD Test Case - Create a New Post        |
  | body       | This is a test case for BDD API testing. |
Then the API should respond with 201 status code
And the response should contain the following data:
  | Field      | Value                                   |
  | userId     | 1                                       |
  | id         | [a dynamically generated value]          |
  | title      | BDD Test Case - Create a New Post        |
  | body       | This is a test case for BDD API testing. |
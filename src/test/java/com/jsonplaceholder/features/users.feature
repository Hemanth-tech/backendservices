Feature: Validate Users 

Background:
Given the user API is available

Scenario: Add User
Given A new user with name "test" and email "test@example.com" is added
When user details are retrievd 
Then user name "test" and email "test@example.com" should "present" in response

Scenario: Retrive list of users
When complete list of user details are retrievd
Then user name "test" and email "test@example.com" should "present" in response

Scenario: Update user
Given there is user with name "test" and email "test@example.com"
When user name  is updated to "testUpdate" and email is updated to "testUpdate@example.com" should be present in response 
Then user name "test" and email "test@example.com" should "present" in response

Scenario: Retrive all posts made by the user
Given user created a post 
When "posts" created by user retrived
Then Created "post" should be present in the response

Scenario: Retrive all comments made by the user
Given user "adds" comment to the post
When "comments" created by user retrived
Then Created "comment" should be present in the response

Scenario: Delete user
Given there is user with name "test" and email "test@example.com"
When user details are deleted 
And complete list of user details are retrievd
Then user name "test" and email "test@example.com" should "notPresent" in response



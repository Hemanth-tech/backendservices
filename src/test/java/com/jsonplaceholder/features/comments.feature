Feature: Validate Comment 

Background:
Given the user is authenticated
And the JsonPlaceHolder Comment API is available

Scenario: Add Comment
Given user created a post 
When user "adds" comment to the post
Then comment should be retrieved 

Scenario: Update Comment
When user "update" comment to the post
Then comment should be retrieved

Scenario: Delete Comment
When user "delete" comment to the post
Then user should receive error message for "Retrieving deleted comments"

Scenario Outline: Retrieve Comments for deleted Posts
Given user delete the post with ID <postId>
When user retrive comments of <postId>
Then user should receive comment realted error message for "Retrieving deleted post comments"
Examples:
  | postId | 
  | 1      | 
  | 2      | 
  
Scenario Outline: Retrieve Comments for deleted users
Given user delets the account with id <userId>
When user retrive comments of <userId>
Then user should receive comment realted error message for "Retrieving deleted user comments"
Examples:
  | userId | 
  #| 1      | 
  #| 2      | 

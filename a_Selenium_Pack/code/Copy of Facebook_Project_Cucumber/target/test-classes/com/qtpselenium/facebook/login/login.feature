Feature:Logging in Facebook
In order to see my account
As a user
I want to login

Scenario: Good user
Given I go to facebook on "Mozilla"
And I enter "username" as "its.thakur@gmail.com"
And I enter "password" as "whoareyou"
And I click on "LoginButton"
Then login should be "success"
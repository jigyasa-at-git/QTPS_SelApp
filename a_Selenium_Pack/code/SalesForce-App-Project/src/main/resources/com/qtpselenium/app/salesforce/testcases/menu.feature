Feature: Testing the top Menu

In to work perform all operations after logging in
As a sales person
I want to check menu items
@menu
Scenario Outline: Testing Top Menu
Given I am logged in "<BrowserType>"
Then All tabs on menu should be present
| hometab		 |
| leadtab	     |
And I click on "<HeaderLink>"
Then "<VerificationObject>" element should be present

 Examples:
 |	BrowserType		|	HeaderLink  |	VerificationObject|
 |   Mozilla        |   hometab     |  	whatareyoudoing   |
 |   Mozilla 		|   leadtab		|   recentleads		  |

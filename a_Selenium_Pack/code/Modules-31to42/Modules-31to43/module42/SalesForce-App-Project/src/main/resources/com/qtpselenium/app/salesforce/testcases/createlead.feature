Feature: Creating lead

In to get more revenue
As a sales person
I want to create leads

Background:
Given I am logged in salesforce in Mozilla
Given I am logged in salesforce in Chrome


@createlead
Scenario Outline:Creating leads
Given Browser is "<Browser>"
And "leadtab" should be present
And I click on "leadtab"
And I click on "newLeadButton"

Examples:
|Browser|
|Mozilla|
|Chrome |


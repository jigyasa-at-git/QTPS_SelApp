Feature: Life of IT Tester

In order to get good salary
As a IT guy
I want to keep my boss happy

@tester
Scenario Outline: I am a tester 

Given I am a "<TesterType>" tester
| industry   | country |
|  IT        | India   |
| Automobile | Germany  |
When I go to work
Then I "<Work_Output>" it
And My boss "<Boss_Action>" me
| country |
| India   |
| Germany |
But The developer "<Developer_Reaction>" me

 Examples:
 |  TesterType  |  Work_Output | Boss_Action | Developer_Reaction |
 |   Good       |   Complete   |  Salutes    |   hates            |
 |   Bad        |   Mess       |  Fires      |   Likes            |
 |   avg        |   sufficient |  congrats   |   respects            |




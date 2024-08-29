Feature: Internal Company Creation and Edit

Background: 
Given The user is already logged into the application
          |              username                |   password   |
          | adactindev.tester6@dispostable.com   |   Password   |

Scenario Outline: Create Internal Company

Given The user is on the User Dashboard Page
Then the user gets the title of the page
When the User clicks on the Internal Companies
Then the user gets the title of the page
And the user clicks on the Create New button
When the user enters the "<Company Color>", "<Status>","<Internal Company Name>","<Internal Company Email>" and "<Category Type>"
And the user clicks on the Create Company button

Examples: 
| Company Color  |  Status   |     Internal Company Name   |    Internal Company Email  |     Category Type    |
| #dc2ecd        |  Active   |     Test Int Cmpny          |    Test@dispostable.com    |     GP               |




Scenario: User Edits the Internal Company

Given The user is on the User Dashboard Page
Then the user gets the title of the page
When the User clicks on the Internal Companies
Then the user gets the title of the page
And the user clicks on the "AA"

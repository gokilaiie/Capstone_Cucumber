Feature: Login Feature 

Scenario Outline: User Logins into the application

Given the user is on the Login page
When the user gets the title of the page 
Then the title of the page should be "Capstone"
When the user logins using the "<username>" and "<password>"
And the user clicks on the Login button
When the user gets the title of the page

Examples:
          |              username                |   password   |
          | adactindev.tester6@dispostable.com   |   Password   |
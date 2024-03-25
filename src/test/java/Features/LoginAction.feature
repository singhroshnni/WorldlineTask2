Feature: Login Action
    Description: This feature will test the Login and Logout functionality

Background:
    Given User is on Home Page
    When User navigate to Login Page

@Login @Valid
Scenario Outline: Login with valid credentials
    Given User is on Home Page
    When User navigate to Login Page
    Then User enters "<username>" and "<password>" keeping case as Valid
    Then User should get logged in
    And Message displayed Login Successfully

Examples: 
    | username                | password | 
    | jyotisingh01@gmail.com  | asdfgh    |

@Login @Invalid
Scenario Outline: Login with invalid credentials
    Given User is on Home Page
    When User navigate to Login Page
    Then User enters "<username>" and "<password>" keeping case as Invalid
    Then user will be asked to go back to login page
    And Provide correct credentials

Examples:
    | username         | password | 
    | abc1@gmail.com   | dfsd2    |

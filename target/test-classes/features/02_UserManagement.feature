#Author: your.email@your.domain.com

Feature: Display user profile details

  Scenario: Display user details
  	Given User has username and password
  	When User tries to login with valid credentials
  	Then User should be able to login
    Given User has login credentials
    When User navigates to user management
    Then User profile details are displayed successfully

    Scenario: User updates password
    Given User has logged into account
    When User updated password from user management
    Then Password is updated successfully
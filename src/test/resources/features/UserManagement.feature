#Author: your.email@your.domain.com

Feature: Display user profile details

  Scenario: Display user details
    Given User has login credentials
    When User navigates to user management
    Then User profile details are displayed successfully

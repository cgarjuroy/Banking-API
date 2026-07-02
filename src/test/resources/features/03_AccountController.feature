#Author: arjun.roy@capgemini.com
Feature: Display user account details

  Scenario: Display account details
    Given user has already logged in
    When User navigated to account tab
    Then Account details displayed successfully
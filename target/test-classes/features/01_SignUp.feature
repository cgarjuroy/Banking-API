#Author: arjun.roy@capgemini.com
Feature: Sign-Up a new User

  Scenario: Sign-up new user
    Given User has sign up details
    When User created new account
    Then Account is created successfully
    
  Scenario: User login
  	Given User has username and password
  	When User tries to login with valid credentials
  	Then User should be able to login
  	
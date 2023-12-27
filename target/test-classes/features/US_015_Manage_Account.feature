
Feature: go to Registration Page
  Background: User go to GMI Bank homepage
    Given user got to GMI Bank homepage
    And user click to dropdown button
    Then user click to Sign in button
    And user click User name button
    And user type Username "team21customer"
    And user click to Password
    And user type Password "team21Customer"
    Then user click Sign in
    Then user click My Operation button
    Then user click Manage Accounts button

    Scenario:TC_0001 User should see all account types and balace populated
      Then check all account types
      Then check all balance

  Scenario:TC_0002 User can view transaction
     Then user view transaction




















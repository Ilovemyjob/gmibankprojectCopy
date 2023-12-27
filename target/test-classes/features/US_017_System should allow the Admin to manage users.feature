@registrationpage
Feature:go to Registration page

  Background:User go to GMI Bank homepage
    Given user got to GMI Bank homepage
    And user click to dropdown button
    Then user click to Sign in button
    And user click User name button
    And user type Username "teamadmin21"
    And user click to Password
    And user type Password "teamAdmin21"
    Then user click Sign in
    And Click on Administration button
    And Click on User Management button

    Scenario: Admin can activate a role as user
      And Click on deactivated button as user

  Scenario: Admin can activate a role as employee
    And Click on deactivated button as employee

  Scenario: Admin can activate a role as manager
    And Click on deactivated button as manager

  Scenario: Admin can activate a role as admin
    And Click on deactivated button as admin

  Scenario: Admin can view all user info (admin, manager, employee and user)
    And Admin should see all View button

  Scenario: Admin can edit all user info (admin, manager, employee and user)
    And Admin should see all Edit button

  Scenario: Admin can delete all user info (admin, manager, employee and user)
    And Admin should see all Delete button















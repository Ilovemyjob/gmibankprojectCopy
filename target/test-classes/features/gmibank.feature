
Feature: Go to homepage
    Background: User go to GMI Bank homepage
        Given user got to GMI Bank homepage

        Scenario: TC_0001 User type to SSN number
            Given user clik to dropdown button
            Then user clik to register button
            And user clik to SSn number box and send SSN number

        Scenario: TC_0002 User type own name
            Given user click to first name box
            Then user send a valid name

        Scenario: TC_0003 User type own last name
            Given user click to last name box
            Then user send a valid last name




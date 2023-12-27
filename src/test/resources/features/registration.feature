
Feature: Go to homepage
    Background: User go to GMI Bank homepage
        Given user got to GMI Bank homepage

        Scenario: TC_001-007 User type several informations
            And user clik to register box
            And user clik to register button
            And user clik to SSn number box and send "454-42-1223"
            And user click to first name box and send "Hans"
            And user click to last name box and send "Kern"
            And user click to address box and send "Ernst Straße 2, 17299 Hamburg"
            And user click to mobile phone number box and send "404-421-2236"
            And user click to username box and send "hanskern1234"
            Then user click to email box and send "hanskern@fakemail.com"





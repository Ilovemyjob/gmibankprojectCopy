 @registrationpage

Feature: Read all customer data

  Background: Api end point being set in response
    Given user provides the api end point to set response using "https://www.gmibank.com/api/tp-customers"

    Scenario: read all data coming as JSON with api and validate from data set
      Given user is desirlializing all data to Java
      And use set all CUstomer information to related files
      And validate them from data set


    Scenario: read all data coming as JSON with api and validate one by one
     Given user is desirlializing all data to Java
      And validate them one by one
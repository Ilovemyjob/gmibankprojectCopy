Feature:
  Scenario: System should allow to create new countries using api end point
    Given User set country endPoint with valid token
    And User can Just create each country 1 by 1
    Then User validate country which is created
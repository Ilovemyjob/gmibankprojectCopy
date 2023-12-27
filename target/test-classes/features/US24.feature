Feature:
  Scenario: create state
    Given user read data from endpoint with valid token
    Given status code should be 200 and content type json
    Given Create anew state
    Then validate new state is created
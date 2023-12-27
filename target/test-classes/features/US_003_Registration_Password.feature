

Feature: Go to Registration Page

  Background: User go to GMI Bank homepage
    Given user got to GMI Bank homepage


  Scenario Outline: TC_0001 User type to New Password_There should be at least 1 uppercase char
    Given user click to dropdown button
    Then user click to register button
    And user click to New Password button
    Then user type New <Password>
    Then check the bar level
    Then verify level
    Examples:
      | Password    |
      | "<Aaaaaaa>" |
#      | "<Aaaa..aa12>" |
      | "<Aaaa>"    |

  Scenario Outline: TC_0002 User type to New Password_There should be at least 1 lowercase char
    Given user click to dropdown button
    Then user click to register button
    And  user click to New Password button
    Then user type New <Password>
    Then check the bar level
    Then verify level
    Examples:
      | Password    |
      | "<aAAAAAA>" |
#      | "<aAAAA111>"  |
#      | "<aaaa>" |


  Scenario Outline: TC_0003 User type to New Password_There should be at least 1 digit
    Given user click to dropdown button
    Then user click to register button
    And  user click to New Password button
    Then user type New <Password>
    Then check the bar level
    Then verify level
    Examples:
      | Password    |
      | "<1aaaaaa>" |
#      | "<Aaaaaaa12>"  |
#      | "<Aaaa..aa12>" |
#      | "<Aadd>"       |

  Scenario Outline: TC_0004 User type to New Password_There should be  at least 1 special char
    Given user click to dropdown button
    Then user click to register button
    And  user click to New Password button
    Then user type New <Password>
    Then check the bar level
    Then verify level
    Examples:
      | Password    |
      | "<.aaaaaa>" |
#      | "<Aaaaaaa12>"  |
#      | "<Aaaa..aa12>" |
#      | "<Aadd>"       |

  Scenario Outline: TC_0005 User type to New Password_There should be at least 7 chars
    Given user click to dropdown button
    Then user click to register button
    And  user click to New Password button
    Then user type New "<Password>"
    Then check the bar level
    Then verify level
    Examples:
      | Password |
      | Aaaaaaa  |
      | Aaaa12   |
#      | "<Aaaa..aa12>" |
#      | "<Aadd>"       |
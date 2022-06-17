Feature:
  Verify different POST operations using REST-assured

  Scenario: Create a menu
    Given I set POST menu service api for "/menu"
    When I perform POST menu
    Then I get a 200 status from menu service

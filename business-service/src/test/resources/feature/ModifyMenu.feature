Feature:
  Verify different PUT operations using REST-assured

  Scenario: Verify update menu
    Given I set PUT menu service api for "/menu"
    And I perform PUT for the menu number "4"
    Then I get a 200 status from modify menu service
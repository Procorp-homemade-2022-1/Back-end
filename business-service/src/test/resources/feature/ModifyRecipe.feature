Feature:
  Verify different PUT operations using REST-assured

  Scenario: Verify update recipe
    Given I set PUT recipe service api for "/menu"
    And I perform PUT for the recipe number "4"
    Then I get a 200 status from modify recipe service

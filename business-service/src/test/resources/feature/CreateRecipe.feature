Feature:
  Verify different POST operations using REST-assured

  Scenario: Create a recipe
    Given I set POST recipe service api for "/recipes"
    When I perform POST recipe
    Then I get a 200 status from recipe service

Feature:
  Verify different Delete operations using REST-assured

  Scenario: Delete a Recipe
    Given I set DELETE recipe service api for "/recipes"
    When I perform DELETE operation for the recipe number "4"
    Then  I get a 200 status from delete recipe service
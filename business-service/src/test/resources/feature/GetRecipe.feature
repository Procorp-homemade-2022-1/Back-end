Feature:
  Verify different GET operations using REST-assured

  Scenario: Get Recipe
    Given I set GET recipe service api endpoint
    When I get a recipe by performing GET operation for the recipe number "4"
    Then I should see the recipe name as "papa a la huancaina"
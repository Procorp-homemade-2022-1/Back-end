Feature:
  Verify different GET all operations using REST-assured

  Scenario: Verify one author of the get all
    Given I get all publications with GET operation for the "/publication"
    And I perform GET all publications
    Then I get "4" publications as a result
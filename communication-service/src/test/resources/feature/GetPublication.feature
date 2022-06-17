Feature:
  Verify different GET operations using REST-assured

  Scenario: Verify one author of the post
    Given I set GET publication service api endpoint
    And I perform GET for the publication number "1"
    Then I should see the publication name as "Nueva Aventura!"
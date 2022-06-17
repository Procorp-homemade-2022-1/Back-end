Feature:
  Verify different GET operations using REST-assured

Scenario: Post a Publication
    Given I perform POST operation for "/publication"
    And I perform POST publication
    Then  I get a 200 status from publication service
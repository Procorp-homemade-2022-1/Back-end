Feature:
  Verify different GET operations using REST-assured

Scenario: Post a Publication
    Given I set POST message service api for "/message"
    And I perform POST message
    Then  I get a 200 status from the message service
Feature:
  Verify different GET all operations using REST-assured

  Scenario: Verify one author of the get all
    Given I get all menus with GET operation for the "/menus"
    When I perform GET all menus
    Then I get "4" menus as a result
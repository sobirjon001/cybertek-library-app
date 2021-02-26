@all
Feature: 9. user group category features

  Scenario: verify user categories

    Given User is on Library login "qa3_url" page
    And User login as a "librarian"
    When User is on "Users" module
    And User clicks "User Group" dropdown
    Then User should see the following dropdown options:
      | ALL       |
      | Librarian |
      | Students  |
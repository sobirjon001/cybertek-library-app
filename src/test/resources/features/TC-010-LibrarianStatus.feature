@all
Feature: 10. user status feature

  Scenario: verify user status

    Given User is on Library login "qa3_url" page
    And User login as a "librarian"
    When User is on "Users" module
    And User clicks "Status" dropdown
    Then User should see the following dropdown options:
      | ACTIVE   |
      | INACTIVE |
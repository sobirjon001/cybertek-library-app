@all
Feature: 11. user management table feature

  Scenario: user management table columns names

    Given User is on Library login "qa3_url" page
    And User login as a "librarian"
    When User is on "Users" module
    Then User should see the following table column names:
      | Actions   |
      | User ID   |
      | Full Name |
      | Email     |
      | Group     |
      | Status    |
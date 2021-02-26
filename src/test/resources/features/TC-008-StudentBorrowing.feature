@all
Feature: 8. As a user, I should able to see my borrowing books.

  Scenario: borrowing books table columns names

    Given User is on Library login "qa3_url" page
    And User login as a "student"
    When User is on "Borrowing Books" module
    Then User should see the following table column names:
      | Action              |
      | Book Name           |
      | Borrowed Date       |
      | Planned Return Date |
      | Return Date         |
      | Is Returned ?       |
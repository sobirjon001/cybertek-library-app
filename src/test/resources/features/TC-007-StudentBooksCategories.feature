@all
Feature: 7. As a students, I should be able to search
  books with different categories.

  Scenario Outline:
    Given User is on Library login "qa3_url" page
    And User login as a "student"
    When User selects a "<category>" from search by category dropdown
    Then Books table should show books by "<category>"
    Examples: some books categories to try our search:
      | category                |
      | Anthology               |
      | Action and Adventure    |
      | Classic                 |
      | Biography/Autobiography |
      | Poetry                  |
      | Historical Fiction      |
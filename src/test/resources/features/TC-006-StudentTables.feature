@all
Feature: 6. As a students, I should be able to see tables with default info

  Scenario: Table columns names
    Given User is on Library login "qa3_url" page
    And User login as a "student"
    Then User should see the following table column names:
      | Actions     |
      | ISBN        |
      | Name        |
      | Author      |
      | Category    |
      | Year        |
      | Borrowed By |
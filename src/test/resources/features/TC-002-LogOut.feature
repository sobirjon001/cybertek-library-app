@all
Feature: 2. As a user, I should be able to logout from the library app.

  Scenario Outline: User is able to log out
    Given User is on Library login "qa3_url" page
    Given User login as a "<role>"
    When User loges out from app
    Then User is on Login page
    Examples:
      | role      |
      | student   |
      | librarian |
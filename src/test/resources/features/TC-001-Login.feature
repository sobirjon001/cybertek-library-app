@all @login
Feature: 1. As a user, I should be able to login to the library app.
  As a User, I should be able to login

  Scenario Outline: verify both Students and librarians  login
    Given User is on Library login "qa3_url" page
    And User login as a "<role>"
    Then User is on "<page>" page
    Examples:
      | role      | page      |
      | student   | #books     |
      | librarian | #dashboard |
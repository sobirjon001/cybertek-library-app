@all
Feature: 4. As a librarian, I should be able to add users from users page.
  1. add users with all valid info.
  2. Librarians able to close the add user window with "close" button
  3. Librarians able to edit user info.

  Background: User is already on Library login page
    Given User is on Library login "qa3_url" page
    Given User login as a "librarian"
    When User is on "Users" module

  @now
  Scenario: Librarian is able to add users with all valid info.
    And User opened add new user form
    And User adds new User with valid info
    Then New User is added or updated to records table

  Scenario: Librarians able to close the add user window with "close" button
    And User opened add new user form
    And User cancels adding new user
    Then Add new User form is closed

  Scenario: Librarians able to edit user info.
    And User tries to edit User info
    Then New User is added or updated to records table
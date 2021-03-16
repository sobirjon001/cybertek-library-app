Feature: 4. As a librarian, I should be able to add users from users page.
  1. add users with all valid info.
  2. compare UI and DB number of users are same -- end to end testing

  Background: User is already on Library login page
    Given User is on Library login "qa1_url" page
    Given User login as a "librarian1"
    When User is on "Users" module

  @dbggg
  Scenario: Librarian is able to add users with all valid info.
    And User opened add new user form
    And User adds new User with valid info
    When User is on "Dashboard" module
    Then Database updated

  Scenario: Librarian is able to edit user
    And User finds
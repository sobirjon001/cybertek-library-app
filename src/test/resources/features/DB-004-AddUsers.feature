Feature: 4. As a librarian, I should be able to add users from users page.
  1. add users with all valid info.
  2. compare UI and DB number of users are same -- end to end testing

  Background: User is already on Library login page
    Given User is on Library login "qa1_url" page
    And User login as a "librarian1"
    And User is on "Users" module

  @db @wip
  Scenario: Librarian is able to add users with all valid info.
    And User opened add new user form
    When User adds new User with valid info
    And User is on "Dashboard" module
    Then Database updated

  @db
  Scenario Outline: Librarian is able to edit user
    When User finds student id "<studentID>"
    And User change name to "<studentName>"
    Then Database of student id "<studentID>" name is "<studentName>"
    Examples: these table will hold same data for all steps:
      | studentID | studentName      |
      | 700       | Daniel |
      | 701       | Stephanie |

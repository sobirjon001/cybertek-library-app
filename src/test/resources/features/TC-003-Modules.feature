@all
Feature: 3. As a user, I should be able to  see several modules once I login.

  Background: User is already on Library login page
    Given User is on Library login "qa3_url" page

  @student
  Scenario Outline: Students should have access to 2 modules
    Given User login with credentials "<user name>" and "<password>":
    Then User should see following modules:
      | Books           |
      | Borrowing Books |
    Examples: user name and passwords examples:
      | user name         | password |
      | student17@library | wVIHb1Hu |
      | student18@library | W8qVceWE |
      | student19@library | gc3mseeR |

  @librarian
  Scenario Outline: Librarians  should have access to 3 modules
    Given User login with credentials "<user name>" and "<password>":
    Then User should see following modules:
      | Dashboard |
      | Users     |
      | Books     |
    Examples: user name and passwords examples:
      | user name           | password |
      | librarian13@library | pY8YOLfy |
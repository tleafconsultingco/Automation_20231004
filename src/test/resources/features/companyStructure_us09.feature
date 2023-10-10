Feature: Functions on Company Structure under Employee menu
  US09. As a user, I should be able to use functions on Company Structure under Employee menu (TL demo)

  AC.
  1. All user types should be able to display company structure.
  2. Hr user should be able to add a department from the company structure.
  3. There is no “ADD DEPARTMENT” option for Helpdesk and Marketing users.

  @companyStructure
  Scenario Outline: US09_TC01. All user types should be able to display company structure (AC01).
    When user logs in as "<userType>"
    And user locates "Employees" menu and clicks
    Then user sees "Company Structure" is displayed
    Examples:
      | userType  |
      | hr        |
      | helpdesk  |
      | marketing |
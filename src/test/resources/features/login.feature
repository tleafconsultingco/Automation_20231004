@B29G26-315 @login
Feature: US01. User should be able to login
  US:
  As a user, I should be able to login (TL demo)

  AC:
  1. Users should successfully log in with valid credentials and redirected to the home page. (3 types of users: HR, Marketing, Helpdesk).
  2. "Incorrect login or password" error message should be displayed for invalid (valid username-invalid password and invalid username-valid password) credentials
  3. "Please fill out this field" error message should be displayed if the password or username is empty
  4. User can see "Remember Me" checkbox exists and it is clickable
  5. User should see the password masked (in bullet signs) by default

  @B29G26-316 @passed
  Scenario Outline:  US01-TC01. Verify login as different users with different VALID credentials (AC01)
    When user logs in as "<userType>"
    Then user is on Home page with "Portal" in title
    Examples:
      | userType  |
      | hr        |
      | helpdesk  |
      | marketing |

  @B29G26-317 @passed
  Scenario Outline: US01-TC02. Verify login as different users with different INVALID credentials (AC02)
    When user logs in as "<username>","<password>"
    Then user sees error message "Incorrect login or password"
    Examples:
      | username                   | password |
      | hr1@cybertekschool.com     | invalid  |
      | invalid@cybertekschool.com | UserUser |

  @B29G26-318 @failed
  Scenario Outline: US01-TC03. Verify login with one empty field (AC03)
    When user logs in with one empty text field "<username>","<password>"
    Then user sees error message "Please fill out this field"
    Examples:
      | username               | password |
      | hr1@cybertekschool.com |          |
      |                        | UserUser |

  @B29G26-319 @passed
  Scenario: US01-TC04. Verify "Remember me" box exists and is clickable (US04)
    When user is on login page
    Then user sees "Remember Me" box
    And user can click Remember Me checkbox

  @B29G26-320 @passed
  Scenario: US01-TC05. Verify password is masked by default (AC05)
    When user is on login page
    Then password should be masked
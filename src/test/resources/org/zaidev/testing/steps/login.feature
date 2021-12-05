Feature: Store login

  Background:
    Given The home page is opened
    And the Login button is clicked


  Scenario Outline: Invalid Login Credentials
    Given the email is filled with '<e-mail>'
    And the password is filled with '<password>'
    When the user clicks on sign-in
    Then this '<errormsg>' is shown

    Examples:
      | e-mail              | password | errormsg                   |
      | test@hotmail.com    |          | Password is required.      |
      |                     | passwd   | An email address required. |
      | asdasd@hotmail.com  | 123123   | Authentication failed.     |
      | "email"@example.com | 0        | Invalid email address.     |

  Scenario: Valid Login Credentials
    Given the email is filled with 'zscasc@hotmail.com'
    And the password is filled with 'asd12345'
    When the user clicks on sign-in
    Then the user should be logged in
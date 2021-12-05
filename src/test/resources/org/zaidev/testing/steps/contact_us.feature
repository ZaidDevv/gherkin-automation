Feature: Contact Us Form

  Background:
    Given The home page is opened
    And the Contact Us form link is clicked

  Scenario Outline: Invalid Contact-us form data
    Given the Subject heading is filled with '<Subject Heading>'
    And the email is filled with '<e-mail>'
    And the message is filled with '<message>'
    When the form is submitted
    Then this '<errormsg>' is shown
    Examples:
      | Subject Heading  | e-mail                  | message | errormsg                                        |
      | Webmaster        | test@hotmail.com        |         | The message cannot be blank.                    |
      | Webmaster        | invalid.email.com       | test    | Invalid email address.                          |
      | invalid          | automaiontest@gmail.com | test123 | Please select a subject from the list provided. |
      | Customer service | .email@example.com      | test    | Invalid email address.                          |

  Scenario Outline: Valid Contact-us form data
    Given the Subject heading is filled with '<Subject Heading>'
    And the email is filled with '<e-mail>'
    And the message is filled with '<message>'
    When the form is submitted
    Then the output message '<outputMessage>' is shown
    Examples:
      | Subject Heading  | e-mail                  | message | outputMessage                                        |
      | Webmaster        | test@hotmail.com        | !@#$%   | Your message has been successfully sent to our team. |
      | Webmaster        | valid@email.com         | مرحبا   | Your message has been successfully sent to our team. |
      | Customer service | automaiontest@gmail.com | test123 | Your message has been successfully sent to our team. |
      | Customer service | email@111.222.333.44444 | 0       | Your message has been successfully sent to our team. |
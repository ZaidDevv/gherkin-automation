Feature: Contact Us Form

  Background:
    Given The home page is opened
    And the Contact Us form link is clicked


  Scenario: Valid Contact-us form data
    Given the Subject heading is filled with 'Webmaster'
    And the email is filled with 'test@hotmail.com'
    And the message is filled with 'test123'
    When the form is submitted
    Then the output message 'Your message has been successfully sent to our team.' is shown

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
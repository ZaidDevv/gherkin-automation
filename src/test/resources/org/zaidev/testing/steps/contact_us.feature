Feature: Contact Us Form

  Background:
    Given The home page is opened
    And the Contact Us form link is clicked

  Scenario Outline:
    Given '<Subject Heading>' is filled
    And the '<e-mail>' is filled
    And the '<message>' is also filled
    When the form is submitted
    Then this '<errormsg>' is shown
    Examples:
      | Subject Heading | e-mail                  | message | errormsg                                        |
      | Webmaster       | test@hotmail.com        |         | The message cannot be blank.                    |
      | Webmaster       | invalid.email.com       | test    | Invalid email address.                          |
      | invalid         | automaiontest@gmail.com | test123 | Please select a subject from the list provided. |
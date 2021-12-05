@ProductSearch
Feature: Contact Us Form

  Background:
    Given The home page is opened

  Scenario: Special case product search
    Given the user inputs "% sign in" in the search bar
    When the search button is clicked
    Then the search page should be displayed


  Scenario Outline: Valid product search
    Given the user inputs '<product>' in the search bar
    When the search button is clicked
    Then the '<product>' is in the search results
    Examples:
      | product                     |
      | Blouse                      |
      | Faded Short Sleeve T-shirts |
      | Printed Summer Dress        |
      | Printed Chiffon Dress       |


  Scenario Outline: Invalid product search
    Given the user inputs '<Product>' in the search bar
    When the search button is clicked
    Then the output message '<Output Message>' is shown
    Examples:
      | Product                                                                                                       | Output Message                        |
      | 0                                                                                                             | Please enter a search keyword         |
      |                                                                                                               | Please enter a search keyword         |
      | ababababababababababababababababaababababababababababababababababababababababbabababababababababababababababa | No results were found for your search |
      | Non-english شاورما                                                                                            | No results were found for your search |


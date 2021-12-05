Feature: Shopping Cart

  Background:
    Given The home page is opened

  Scenario Outline: Add product to shopping cart
    Given the user is on the '<product>' product page
    And inputs the products '<quantity>'
    And selects the '<size>' size
    And picks the '<color>' color
    When the user adds the item to the cart
    Then the '<product>' should be added to the cart
    Examples:
      | product                     | quantity | size | color  |
      | Printed Dress               | 3        | M    | Orange |
      | Faded Short Sleeve T-shirts | 2        | L    | Blue   |
      | Printed Summer Dress        | 1        | S    | Yellow |
      | Printed Chiffon Dress       | 4        | L    | Green  |

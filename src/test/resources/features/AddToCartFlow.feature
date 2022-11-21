@Regression
Feature: Add to cart flow

  Scenario Outline: Verify the login flow
    Given User logs in to SWAGLABS with '<Username>' and '<Password>'
    Then Verify user is navigated to SWAGLABS Home page

    Examples:
      | Username | Password |
      | username | password |

  Scenario Outline: Verify the products added to cart
    Given User logs in to SWAGLABS with '<Username>' and '<Password>'
    Then Verify user is navigated to SWAGLABS Home page
    When User adds product '<ProductName>' to the cart
    And User goes to YOUR CART Page
    Then Verify product '<ProductName>' is added to the cart
    When User clicks on Checkout button
    Then Verify user is redirected to Checkout page
    When User goes back to YOUR CART Page
    And User removes the product '<ProductName>' from cart

    Examples:
      | Username | Password | ProductName                       |
      | username | password | Sauce Labs Backpack               |
      | username | password | Sauce Labs Bike Light             |
      | username | password | Sauce Labs Bolt T-Shirt           |
      | username | password | Sauce Labs Fleece Jacket          |
      | username | password | Sauce Labs Onesie                 |
      | username | password | Test.allTheThings() T-Shirt (Red) |
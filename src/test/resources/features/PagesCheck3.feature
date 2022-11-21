@Regression
Feature: 3. Checking all the pages of SWAGLABS Website

  Scenario Outline: Verify the login flow
    Given User logs in to SWAGLABS with '<Username>' and '<Password>'
    Then Verify user is navigated to SWAGLABS Home page

    Examples:
      | Username | Password |
      | username | password |

  Scenario Outline: Verify the YOUR CART Page
    Given User logs in to SWAGLABS with '<Username>' and '<Password>'
    Then Verify user is navigated to SWAGLABS Home page
    And User goes to YOUR CART Page
    When User clicks on Checkout button
    Then Verify user is redirected to Checkout page

    Examples:
      | Username | Password |
      | username | password |

  Scenario Outline: Verify the products added to cart
    Given User logs in to SWAGLABS with '<Username>' and '<Password>'
    Then Verify user is navigated to SWAGLABS Home page
    And User goes to YOUR CART Page
    When User clicks on Checkout button
    Then Verify user is redirected to Checkout page
    When User goes back to YOUR CART Page

    Examples:
      | Username | Password |
      | username | password |
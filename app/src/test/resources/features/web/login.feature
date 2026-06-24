@web
Feature: Login SauceDemo

Scenario: Login with valid credentials

    Given user open SauceDemo login page
    When user input username "standard_user"
    And user input password "secret_sauce"
    And click login button
    Then user should be redirected to products page

Scenario: Add product to cart

    Given user already login to SauceDemo
    When user click Add to Cart button
    Then cart badge should display "1"


Scenario: Checkout product successfully

  Given user already login to SauceDemo
  And user click Add to Cart button
  And user open shopping cart
  When user checkout product
  Then order should be completed successfully
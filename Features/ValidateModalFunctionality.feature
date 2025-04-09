Feature: Validation of Modal Page
  #Practice automation for Popup Links

@sanity @regression
  Scenario: Validation of Simple Modal Form
    Given I click on "modal" link
    When I click on a modal "Simple Modal" link
    And I verify modal text "Hi, I’m a simple modal."
    Then I close the simple modal

  @sanity @regression
    Scenario Outline: Validation of Form Modal Page
      Given I click on "modal" link
      When I click on a modal "Form Modal" link
      When I enter first name email and message
        | firstname | "<name>"    |
        | email     | "<email>"   |
        | message   | "<message>" |
      Then I submit the form modal




      Examples:
        | name  | email            | message           |
        | John  | john@example.com | Hello, I'm John!  |
        | Terry | terry@gmail.com  | Hello, I'm Terry  |
        | Sarah | sarah@yahoo.com  | Hello, I'm Sarah! |





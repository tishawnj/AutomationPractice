Feature: Validation of Form Fields Page
  #Practice automation for Popup Links


  Scenario: Validating Form Fields Form
    Given I click on "formFields" link
    Then I enter name as "Tishawn"
    When I enter password as "Test1234"
    And I enter email as "test1234@gmail.com"
    And I select drink as "Coffee"
    And I select color as "Blue"
    And I select answer as "Yes"
    And I enter message as "Hi my name is Tishawn!"
    Then I click submit button
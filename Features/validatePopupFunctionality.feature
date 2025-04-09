Feature: Validation of Popup Links
  #Practice automation for Popup Links

  Background:
    Given I click on "popup" link


  @sanity @regression
  Scenario: Validation of Alert Popup
    When I click on "Alert" Popup link
    And I verify text "Hi there, pal!" on alert popup
    Then I click ok on alert popup

  @sanity @regression
  Scenario: Validation of Confirm Popup Cancel
    When I click on "Confirm" Popup link
    Then I click cancel on alert popup
    Then I verify text "Cancel it is!" on confirm popup

  @sanity @regression
  Scenario: Validation of Confirm Popup Ok
    When I click on "Confirm" Popup link
    Then I click ok on alert popup
    Then I verify text "OK it is!" on confirm popup

  @sanity @regression
  Scenario:  Validation of Prompt Popup Cancel
    When I click on "Prompt" Popup link
    Then I verify "cancel" on prompt popup

  @sanity @regression
  Scenario:  Validation of Prompt Popup oK
    When I click on "Prompt" Popup link
    And I enter "Josh" in alert prompt
    Then I verify "ok" on prompt popup

  @sanity @regression
  Scenario:  Validation of Prompt Popup click Ok without entering text
    When I click on "Prompt" Popup link
    Then I verify "ok" on prompt popup








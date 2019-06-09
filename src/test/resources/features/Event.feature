Feature: Event Feature
  This feature deals with event operations like search-join and exit event

  @smoke
  Scenario: Login to the app successfully
    Given Launch the app
    When Click on Log-in button
    Then Type email
    Then Click Next button
    Then Type password
    Then Click Next button
    And See Search button

  @smoke
  Scenario: Search event to open home page
    Given Click on Search button
    When Type event name as "APPIUM_TEST" and press enter
    Then Click on the event Home text
    And See welcome message as "Welcome to APPIUM_TEST!"

  @smoke
  Scenario: Leave from the event
    Given Click on Exit Event button
    When See Switch Event pop-up as "Switch event"
    Then Click on Yes button
    Then See Search button
    And Quit the app

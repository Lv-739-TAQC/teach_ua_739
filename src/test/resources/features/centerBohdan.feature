Feature: Center component scenario

  Background: Login as admin
    Given User logins as admin

  Scenario: Verify that error messages is displayed after user leaves
    When User open add center page
    And User clicks on 'Наступний крок' button
    Then Error message "Некоректна назва центру" is displayed

Feature: Advanced search scenarios

  Background: User opens the site
    Given User opens the main page of the site

  Scenario: Verify “Advanced search” button opens “Розширений пошук” section and closes it
    When User opens advanced search club component
    Then Advanced search modal is displayed
    And User clicks on advanced search icon
    Then Advanced search modal is hidden

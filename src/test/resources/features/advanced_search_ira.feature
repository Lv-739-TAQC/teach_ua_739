Feature: Advanced search scenarios

  Background: User opens the site
    Given User opens the main page of the site

  Scenario: Verify “Advanced search” button opens “Розширений пошук” section and closes it
    When User opens advanced search modal
    Then Advanced search modal is displayed
    And User clicks on advanced search icon
    Then Advanced search modal is hidden

  Scenario Outline: Verify that input field 'Вік дитини' accepts only positive integers from 2 to 18
    When User opens advanced search modal and clears Age field
    And User sets "<age>" into Age field
    Then User compares actual age with "<expectedAge>"

    Examples:
      | age | expectedAge |
      | 1   | 2           |
      | 2   | 2           |
      | 18  | 18          |
      | 19  | 18          |

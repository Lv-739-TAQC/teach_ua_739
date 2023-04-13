Feature: TUA-146 scenario

  Background: Open website speak-ukrainian.org.ua/dev/
    Given User open website home page

  Scenario: Verify that 'Новини' blocks are in descending order
    When User open news page
    And User get all dates from news cards and add them to list
    And User sort all this dates by desc order and add them to new list
    Then First list equal to second list
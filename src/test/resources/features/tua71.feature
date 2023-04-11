Feature: TUA-71 scenario

  Background: Open website speak-ukrainian.org.ua/dev/
    Given User open website with baseUrl

  Scenario: Verify that user can open 'Челендж' page from any other pages of the site.
    When User open challenge page
    And User get the current url of challenge page
    And User click the 'Челендж' button in the header and get the url of challenge in dropdown you opened early
    Then Url of challenge page equal to url of challenge in dropdown
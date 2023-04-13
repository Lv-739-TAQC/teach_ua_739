Feature: Edit profile scenario

  Background: Login as admin
    Given User login as admin

  Scenario Outline: Verify that error messages is displayed while entering invalid data into 'Ім`я' field
    When User open edit profile page
    And User enters "<inputData>" into profile name field
    Then Error message "<expectedErrorMsg>" is shown
    And User enters "" into profile name field
    Then Error message "Введіть ім'я" is shown

    Examples:
      | inputData                    | expectedErrorMsg                                 |
      | AfBbCcDdEeFfGgHhIiJjKkLlMmNn | Ім'я не може містити більше, ніж 25 символів     |
      | !@#$%^&,                     | Ім’я не може містити спеціальні символи          |
      | 1234                         | Ім’я не може містити цифри                       |
      | -Name                        | Ім’я повинно починатися та закінчуватися літерою |
      | 'Name                        | Ім’я повинно починатися та закінчуватися літерою |
      | Name-                        | Ім’я повинно починатися та закінчуватися літерою |
      | Name'                        | Ім’я повинно починатися та закінчуватися літерою |
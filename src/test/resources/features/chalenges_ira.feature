Feature: Challenges scenarios

  Background: Login as admin
    Given User open the main page of the site and login as admin

  Scenario Outline: Verify that admin cannot create challenge with invalid data in 'Назва' field
    When User open add challenge page
    And User enters sort number into 'Порядковий номер' field
    And User enters "Заголовок Челенджу" into challenge 'Заголовок' field
    And User enters "Lorem Ipsum is simply dummy text of the printing and typesetting industry." into challenge 'Опис' field
    And User upload the image into challenge 'Photo' field
    And User enters "<name>" into challenge 'Назва' field
    And User click 'Save' button
    Then Error message "<expectedErrorMsg>" appeared

    Examples:
      | name                               | expectedErrorMsg                                                                         |
      | писатель эссеист                   | Це поле може містити тільки українські та англійські літери, цифри та спеціальні символи |
      |                                    | Поле ‘Назва Челенджу’ не може бути порожнім                                              |
      | Історично сформовані є особливості | Назва Челенджу задовга                                                                   |



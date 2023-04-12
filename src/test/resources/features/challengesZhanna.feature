Feature: Challenges scenarios

  Background: Login as admin
    Given User open the main page of the site and login as admin

  Scenario: Verify that admin can add a photo with invalid parameters into the ‘Баннер’ file picker
    When User open add challenge page
    And User upload the image into challenge 'Photo' field
    Then Photo is appeared on the add challenge page

  Scenario Outline: Verify the error messages of ‘Назва Челенджу’ field on ‘Основна інформація’ tab of 'Додати челендж' pop-up
    When User open add challenge page
    And User enters "546789" into challenge 'Порядковий номер' field
    And User enters "testMarch2023" into challenge 'Заголовок' field
    And User enters "Lorem Ipsum is simply dummy text of the printing and typesetting industry." into challenge 'Опис' field
    And User upload the image into challenge 'Photo' field
    And User enters "<inputData>" into challenge 'Назва' field
    And User click 'Save' button
    Then Error message "<expectedErrorMsg>" appeared and 'Назва' field is bordered in red color

    Examples:
      | inputData                                                                  | expectedErrorMsg                                                                         |
      | Дыผð*.:                                                                    | Це поле може містити тільки українські та англійські літери, цифри та спеціальні символи |
      | 2                                                                          | Назва Челенджу закоротка                                                                 |
      | Lorem Ipsum is simply dummy text of the printing and typesetting industry. | Назва Челенджу задовга                                                                   |
      | null                                                                       | Поле не повинно бути пустим                                                              |
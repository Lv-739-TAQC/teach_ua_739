Feature: Task scenarios

  Background: Login as admin
    Given User logins with admin credentials

  Scenario: Verify that admin can create a task with valid data
    When User open add task page
    And User selects start date with day 21, month 3 and next year
    And User downloads the image into 'Фото' field
    And User enters "Test task 123456789" into 'Назва' field
    And User enters "Test task title 12345678912345678901234567890" into 'Заголовок' field
    And User enters "Test task Description 12345678912345678901234567890" into 'Опис' field
    And User choose the challenge with name "Ukrainian" in dropdown list on the 'Челендж' field
    And User clicks on the 'Зберегти' button
    Then User is on the task page with name "Test task 123456789"
    And Task with name "Test task 123456789" is present in database
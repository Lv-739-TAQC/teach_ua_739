Feature: Task scenarios

  Background: Login as admin
    Given User logins with admin credentials

  Scenario: Verify that admin can't create a task with invalid date
    When User open add task page
    And User selects start date with day 1, month 4 and year 2023
    And User downloads the image into 'Фото' field
    And User enters "Task Ukraine" into 'Назва' field
    And User enters "Task Ukraine winner 2023  Task Ukraine winner 2023" into 'Заголовок' field
    And User enters "Ukraine winner 2023!, Ukraine winner 2023!, Ukraine winner 2023!, Ukraine winner 2023!" into 'Опис' field
    And User choose the challenge with name "99999" in dropdown list on the 'Челендж' field
    And User clicks on the 'Зберегти' button after selected invalid start date
    Then The error message appears: "Дата початку має бути в майбутньому"
    And Task with name "Task Ukraine" is not added to the DB
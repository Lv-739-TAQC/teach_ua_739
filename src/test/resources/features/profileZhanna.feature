Feature: Profile scenarios

  Background: Login as admin
    Given User open the main page of the site and login as administrator

  Scenario: Verify that error message is shown while leaving empty 'Підтвердіть новий пароль' field in the 'Change password' pop-up
    When User open profile page
    And User click to 'Редагувати профіль' button and click 'Save'
    Then The 'Підтвердіть новий пароль' field is bordered in red colour and error message "Будь ласка, підтвердіть новий пароль" appeared

  Scenario: Verify that error message is shown while leaving empty 'Введіть новий пароль' field in the 'Change password' pop-up
    When User open profile page
    And User click to 'Редагувати профіль' button and click 'Save'
    And The 'Введіть новий пароль' field is bordered in red colour and the error message "Будь ласка, введіть новий пароль" appeared

  Scenario: Verify that error message is shown while leaving empty 'Введіть діючий пароль' field in the 'Change password' pop-up
    When User open profile page
    And User click to 'Редагувати профіль' button and click 'Save'
    And The 'Введіть діючий пароль' field is bordered in red colour and the error message "Будь ласка, введіть діючий пароль" appeared

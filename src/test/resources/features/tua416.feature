Feature: TUA-416 The user or manager can change their role

  Background: Login as admin api
    Given Sign in use email: "admin@gmail.com" and password: "admin" and get access token

  Scenario Outline: Test than admin changes user role
    When Update next user profile id: 847, firstName: "Illia", lastName: "Kapustin", email: "k.ilya.v@gmail.com", phone: "0675673309", roleName: "<role>"
    Then Check user role, value: "<role>"
    Examples:
      | role     |
      | ROLE_USER    |
      | ROLE_MANAGER |

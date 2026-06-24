@api
Feature: User API Testing

Scenario: Get user by id

  Given user set GET user endpoint
  When user send GET user request
  Then status code should be 200

Scenario: Create user

  Given user set CREATE user endpoint
  When user send CREATE user request
  Then create user status code should be 200

Scenario: Update user

  Given user set UPDATE user endpoint
  When user send UPDATE user request
  Then update user status code should be 200

Scenario: Delete user

  Given user set DELETE user endpoint
  When user send DELETE user request
  Then delete user status code should be 200
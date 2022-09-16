#this automation script created by shady ahmed
@SmokeScnario
Feature: Feature to test create user endpoint

  @SmokeTest
  Scenario: Add New User with Valid Parameters
    Given having endpoint to ceate new user
    When  Send valid data in request body using post method
    Then  Status code of response should be 201

  @SmokeTest
  Scenario: Get Created User by user id
    Given Create request user and have user id
    When  Send request with user id using get method
    Then  Status code of response should be 200

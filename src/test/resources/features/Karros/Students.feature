#Author: xuantruong.phan

@Karros
Feature: Karros Techonology
  I want to test Karros
  Background:
      Given I am logged in the system
  @tag1
  Scenario: Filter a Student
    When I want to search id as "Kar001" of a student
    Then I can see "Kar001" in grid view

  @tag2
  Scenario: Add a Student
    When I add new a student
    Then I can filter a created student

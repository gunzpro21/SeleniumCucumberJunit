@SmokeTest
Feature: Degree Finder Tests
  Description: The purpose of this feature is to test Degree Finder by clicking Degree Finder on Study with us menu.

  Background: User is HomePage
    Given User goes to Kaplan Home Page

  Scenario: navigating Degree Finder Page
    When User chooses Degree Finder on submenu
    Then Degree Finder Page displays

  Scenario: view an University in Degree Finder Page
    When User wants to searches some degrees of Arizona State University
    Then degrees belong to "Arizona State University" displays

  Scenario: search data degree of an University in Degree Finder Page
    When User searches "data" degrees of Arizona State University
    Then the following related results are shown
      | degree name                           | university                             | university country |
      | MACCDA Accountancy and Data Analytics | Arizona State University, Tempe Campus | USA                |
      | MS Biological Data Science            | Arizona State University, West Campus  | USA                |

Feature: Website Login
  @login
  Scenario: User login by successfully
    Given a web browser is at the iddiaa login page "https://test/giris-yap"
    When close pop-up
    And user enters phone number "0534"
    And user enters password "qwerty1"
    And user click login button
    And user go to Homepage "https://test.com/"
    Then driver close
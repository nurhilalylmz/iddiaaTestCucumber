Feature: Website Login
  @login
  Scenario: User login by successfully
    Given a web browser is at the iddiaa login page "https://test.iddaa.com/giris-yap"
    When close pop-up
    And user enters phone number "05349199918"
    And user enters password "qwerty1"
    And user click login button
    And user go to Homepage "https://test.iddaa.com/"
    Then driver close
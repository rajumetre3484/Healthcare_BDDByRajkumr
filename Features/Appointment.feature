Feature: Appointment Feature

  Scenario: Validating the appointment functionality
    Given User enter the url as "https://katalon-demo-cura.herokuapp.com/profile.php#login"
    When User enter the username as "John Doe"
    And User enter the password as "ThisIsNotAPassword"
    And User click on the login button
    Then User should navigate to the make appointment page
    When User enters the all the field
    And Click on the book appointment button
    Then Appointment confirmation message should be displayed.

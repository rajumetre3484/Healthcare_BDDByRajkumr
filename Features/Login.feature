Feature: Login Feature

  Scenario: Validate the Login credential
    Given User enter the url as "https://katalon-demo-cura.herokuapp.com/profile.php#login"
    When User enter the username as "John Doe"
    And User enter the password as "ThisIsNotAPassword"
    And User click on the login button
    Then User should navigate to the make appointment page

  Scenario Outline: Validate the application by entering the invalid credentials
    Given User enter the url as "https://katalon-demo-cura.herokuapp.com/profile.php#login"
    When User enter the username as "<username>"
    And User enter the password as "<password>"
    And User click on the login button
    Then Proper error message should displayed

    Examples: 
      | username | password           |
      | John Doe | ThisIsNotAPass     |
      | John D   | ThisIsNotAPassword |
      | John D   | ThisIsNotAPass     |
      |          |                    |
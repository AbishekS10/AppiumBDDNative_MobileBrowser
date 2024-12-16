Feature: User to test OrangeHR website in mobile browser


  Scenario Outline: Successfull login

    Given user to launch egde browser
    And user to open OrangeHR web Application
    When User login into application With "<Username>" and password "<password>" and check login
    Then user to validate successfully login


    Examples:
      |Username|password|
      |Admin|admin123|


  Scenario Outline: Unsuccessfull login negative scn

    Given user to launch egde browser
    And user to open OrangeHR web Application
    When User login into application With "<Username>" and password "<password>" and check login
    Then user to validate error

    Examples:
      |Username|password|
      |Admin|admin369|



  Scenario Outline: Admin user to login and able to add user in web Application

      Given user to launch egde browser
      And user to open OrangeHR web Application
      When User login into application With "<Username>" and password "<password>" and check login
      And User to check admin menu and add menu
      And user to enter mandatory fields
      And user to check save
      Then user to able to see created username in the record

    Examples:
      |Username|password|
      |Admin|admin123|


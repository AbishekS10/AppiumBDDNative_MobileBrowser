Feature: User to launch and work on calculator APK

  Scenario: User to launch a app and perform sum and sub action
    Given user to launch calculator app
    When user perform addition with value "2" and "9"
    And user to check equals
    Then user should get Addition output as "11"


  @test
  Scenario: User to launch a store app and perform success login
    Given user to launch store app
    When User to enter login details name
    And User to select genderbox
    And User to select country dropdown
    And User to check save button
    Then User successfully into store App.

 @test1
  Scenario: User to launch a store app and perform unsuccess login(Without name)
    Given user to launch store app

    When User to select genderbox
    And User to select country dropdown
    And User to check save button
    Then User to check vaidate unsuccess login error






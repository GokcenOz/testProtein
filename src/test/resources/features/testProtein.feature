@proteintech_test
Feature:HomePage_Functionality_With_Right_Credentials

  Background:
    Given user navigates to web page
    And verify the web page is opened


  Scenario:User should see main tabs,clicks Our Technologies and verify IOS Developer position' position is right
  then verify the new tab is opened

    And user should see 4 main tab section on the homepage
    And user clicks "Our Technologies" tab
    Then verify the relevant section is opened
    When user scroll down
    Then verify Open Roles section is present
    Then User verify that "iOS Developer" position is under the Software Development section.
    And User clicks to "iOS Developer" position
    Then verify the new tab is opened.




Feature: Feature for Transaction

  @SmokeTest
  Scenario: Do Transaction
    Given user is in login page
    When user input username and password
    And click button login
    And user will be success login and navigate to homepage
 		Then user will be choose one product  
 		And user do checkout
 		And confirm payment
 
    
    
  #@negative
  #Scenario Outline: Check login validation is working properly
    #Given I want to write a step with <name>
    #When I check for the <value> in step
    #Then I verify the <status> in step
#
    #Examples: 
      #| name  | value | status  |
      #| name1 |     5 | success |
      #| name2 |     7 | Fail    |
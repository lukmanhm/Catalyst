
Feature: Soal No 2
    
  
  Scenario Outline: Check login validation is working properly
    Given User is in login page
    When User input username and password with <name> and <password>
    Then I verify the <status> in login

    Examples: 
      | name  | password | status  |
      | name1 |     5 | success |
      | name2 |     7 | Fail    |
    
   
 Scenario: As an user i want to see order history
   Given User already login
   When User go to account page
   Then user will be see order history
   And user could be validate order history
   
 Scenario: As an user i want to see Account detail
   Given User already login
   When User go to account page
   Then user will be see Account detail
   And user could be validate Account detail
   
 Scenario: As an user i want to change address
   Given User already login
   When User go to account page
   And User click button lihat alamat
   And user will be see in address page
   Then user click button Ubah
   And User would be change the data
   And success change data
   
 Scenario: As an user i want to change address with negative condition
   Given User already login
   When User go to account page
   And User click button lihat alamat
   And user will be see in address page
   Then user click button Ubah
   And User keep it blank
   And user click button simpan
   And display wrong condition
   
 Scenario: As an user i want to add address
   Given User already login
   When User go to account page
   And User click button lihat alamat
   And user will be see in address page
   Then user click button tambah
   And User would be add the data
   And success add data
   
 Scenario: As an user i want to add address with negative condition
   Given User already login
   When User go to account page
   And User click button lihat alamat
   And user will be see in address page
   Then user click button tambah
   And User keep it blank
   And user click button simpan
   And display wrong condition
   
 Scenario: As an user i want to delete address
   Given User already login
   When User go to account page
   And User click button lihat alamat
   And user will be see in address page
   Then user click button hapus
   And success delete data
   
 Scenario: As an user i want to search
   Given User already login
   When User click button search
   And modal search will be displayed
   And user trying input some wording
   Then display data with contains and equal wording
   
 Scenario: As an user i want to search with negative condition
   Given User already login
   When User click button search
   And modal search will be displayed
   And user trying input some wrong wording
   Then display data not found
   
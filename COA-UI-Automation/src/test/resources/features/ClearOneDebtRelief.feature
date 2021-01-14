#Author: dhossain@clearoneadvantage.com
#Keywords Summary : Test Automation



@debtRelif
Feature: Automate Clear One Advantage Using BDD Framework

  Scenario: Clear One Advantage Debt Relief
    Given User nevigate to COA Debt Relief form using Chrome Browser
    And User Select Credit Debt Button
    And User Select Debt Amount
    When User click See Your Savings In Minutes Button
    And User Fill Up and submit the Form
    When User Enter First Name
    And User Enter Last Name
    And User Enter Phone Number
    Then User Click on GetFreeSavingsEstimate Button
    When user Enter Street Address
    And User Enter City
    And User Enter Zip Code
    And user Select Date Of Birth
    Then user Click On GetfreeEstBtn
    
    
    Scenario: Take Screen Shot
    Given User launch and nevigate to new web
    
     
    
    
    
    
    
    
    
    
    
    
#
  #Scenario: Nevigate to Clear one page
    #Given The Google search list 
    #When I click Clear One website button
    #Then I Found clear One wesite Home Page
    

    
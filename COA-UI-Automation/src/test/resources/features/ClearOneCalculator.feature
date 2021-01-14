#Author: dhossain@clearoneadvantage.com
#Keywords Summary : Test Automation
@calculator
Feature: Automate Negotition Calculator

  #
  #Scenario: LogIn to QuickBase
  #Given User nevigate to QuickBase SignIn Page
  #And User Provide Email Or Username
  #And User provide Password
  #Then User Click On SignIn button
  #
  #Scenario: Nevigate To Negotition Calculator
  #Given User Click On Clear One Debt button
  #And User Nevigate To Client
  #And User Search For Client
  #And User Click On Client Record
  #Then User Click On New Calculator
  #
  #
  #Scenario: LogIn to Advantagae Point
  #When User Move To Advantage point Window
  #Given User Enter Credential
  #Then User Click on Log In Now Btn
  #
  #
  #Scenario: Nevigate to Negotition Calculator
  #Given User Click On To Calculator 3
  #And User Move To Negotition Calculator window
  
  
  #-----------------------------------------------------
  # Access to negotiation calculator#
  
  Scenario: Direct Open Negotition Calculator
    Given User Provide appropriate Calculator URL
    And LogIn To Advantage Point
    
    
#
  #Scenario: Validate Select Options Debt Field On Negotition Calculator
   #Given User Click On Select Option 1
   #Then Validate Debt Amount for "Select Option #1"
   #Then Validate Debt Amount for "Select Option #2"
   #Then Validate Debt Amount for "Select Option #3"
   #Then Validate Debt Amount for "Select Option #4"
   #
    #Then Validate Debt Amount for "Creditor Info"
#	Scenario:  Validate Select Options Settelement Field On Negotition Calculator
   #Given Validate Settlement Amount With "Creditor Info"
    #Given Validate Settlement Amount With "Select Option #2"
   
   
   
   Scenario: Validate select options Settlement amount
   When User click on select option one
   And Get settlement amount from payments field
   And Get Settlement Amount from Select option One
   Then Validate settlement Amount With Payment total Amount
   
   
   When User Click On Select Option Two
   And Get Settlement Amount Totall From Payments Table
   And Get Settlement Amount From Select Option Two
   Then Validate Settlement Amount
   
   
   
   
   
   
   
   
   
   
   
   #Given User run a valid query for "MY SQL"
   
   
    #Then Validate Values for "Select Option #2"
    #Then Validate Values for "Select Option #3"
    #Then Validate Values for "Select Option #4"
    
    
    
    
    
    
    

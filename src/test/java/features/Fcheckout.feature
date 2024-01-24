@login
Feature: Checkout In Chilternoak
  I want to Examin Checkout Functionality Of Chilternoak

  Scenario Outline: Checkout Functionality Of Chilternoak
    Given User is on login page and add item to cart
   When User is able Proceed With Valid Checkout Details with<F_Name>and<L_Name>and<Address>and<City>and<Code>and<Phn>
    When User is Not able Proceed With All Null Checkout Details
    And User is Not able Proceed With Only One Null Checkout Details
    Then User is Not able To Enter With Invalid Phone Credentials
    And User is Able To Enter With Invalid Credentials
    
     Examples: 
      | F_Name | L_Name   | Address             | City    | Code     | Phn            |
      | Pankaj | Tripathi | Dstl Portsdown West | Fareham | PO17 6AD | +44 7777447731 |

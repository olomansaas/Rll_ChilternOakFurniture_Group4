@login
Feature: SignUp fuctionality

  Scenario Outline: To test the SigUp functionality of Chiltern Oak page
    Given user navigates to the signup page
    When the user enters their first name as '<fname>'
    And the user enters their last name as '<lname>'
    And the user enters their email as '<email>'
    And the user enters their password as '<password>'
    And the user click on create botton
    Then the user should see the status as '<status>'

    Examples: 
      | fname | lname | email                 | password     | status                                          |
      | User  | A     | dfdhgfa7997@gmail.com | Qserafrr     | Password is too short (minimum is 5 characters) |
      | User  | A     |                       | Qseasfrr@123 | Please enter the valid data                     |
      | User  |       | wsfagfhgra@gmail.com  | Qsesafrr     | Please enter the valid data                     |
      |       |       |                       |              | Emil and Password cant be bla                   |
      | User  | A     | wsgjhfa012@gmail.com  | Qasfserr@123 | robot                                           |

@carprices
Feature: Searching New Cars
  
  In order to search new cars
  As a User
  I have to naviagate to carwale.com

  Scenario Outline: Finding new cars
    Given user navigates to carwale website
    When user mouseover to newcars
    Then user clicks on Findnewcars link
    And user clicks on "<carBrand>" car
    And user validates carTitle as "<carTitle>"
    And user find the car names and prices

    Examples: 
      | carBrand | carTitle    |
      | Toyota   | Toyota Cars |
      | Kia      | Kia Cars    |
 

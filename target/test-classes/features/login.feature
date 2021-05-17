Feature: Login into Application
   
Scenario Outline: Positive test validating login
    Given Initialize the browser with chrome
    And Navigate to "http://qaclickacademy.com" site
    And Click on Login Link in Home Page to land on Secure Sign in Page
    When User enters <username> and <password> and logsin 
    And close browsers
    
   
Examples:
|username               |password |
|test99@gmail.com       |123456   |
|test123@gmail.com      |12345    |

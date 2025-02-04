Feature: Login

@sanity
Scenario: Successful login with valid credentials
Given User launch chrome browser 
When user opens url "https://tutorialsninja.com/demo/index.php?route=account/login"
And user enters email as "peter786@gmail.com" and password as "7867867860"
And Click on Login
Then user click on MyAccount link
And user click on logout link
And close browser

@regression
Scenario Outline: Successful login with valid credentials DDT
Given User launch chrome browser 
When user opens url "https://tutorialsninja.com/demo/index.php?route=account/login"
And user enters email as "<email>" and password as "<password>"
And Click on Login
Then user click on MyAccount link
And user click on logout link
And close browser

Examples:
|email|password|
|peter786@gmail.com|7867867860|
|peter@gmail.com|7867867860|
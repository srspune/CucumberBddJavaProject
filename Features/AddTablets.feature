Feature: AddTablets

Background:
Given User launch chrome browser 
When user opens url "https://tutorialsninja.com/demo/index.php?route=account/login"
And user enters email as "peter786@gmail.com" and password as "7867867860"
And Click on Login
And close browser

@smoke
Scenario: Add Tablet to Cart

When user click on Tablet link
Then click on add to cart


@regression @Sanity
Scenario: Search for Cameras option in SearchBar

When user search for "Cameras"
And click on search button
Then verify title

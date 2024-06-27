Feature: Search and Place the order for Products

Scenario: Search Experience for Products in both home and offeres page

Given User is on GreenCart landing page
When user searched with Shortname "Tom" and extracted actual name of product
Then user searched for same "Tom" in offers page 
And validate product name in offers page matches with landing page


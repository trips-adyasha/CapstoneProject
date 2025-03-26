Feature: Demo Shopping App testing

Background:
Given user launch Demo Shop Home Page


@login
Scenario Outline: Login Functionality
When user enters Email<email>
And user enters Password<password>
And user clicks on Login button 
Then validate log in
Examples:
|email                      |password      |
|trips.siya@gmail.com       |Demo2siya     |
|invalid@invalid.com        |invalid       |


@registration
Scenario Outline: Registration functionality
When user enters First Name<firstname>
And user enters Last Name<lastname>
And user enters the Email<Email>
And user enters the Password<Password>
And user confirms password<confirm>
And user clicks on registration button
Then validate successful registration
Examples:
|firstname   |lastname   |Email                |Password  |confirm   | 
|Wipro4      |Testing4   |wipro4@testing.com   |testing4  |testing4  |
|Java        |batch      |                     |javaworld |javaworld |
 
 
@logout
Scenario: Logout Functionality
When user goes to login page
And user enters credentials
Then user clicks logout        
 
 
@search
Scenario Outline: Search Functionality
When user searches a product<product>
And user clicks on product
And user adds product to cart 
Then user validates if product is added
Examples:
|product |
|laptop  |


@multipleProducts
Scenario: Adding Multiple Products Functionality
When user searches and adds multiple product
Then validate the products and their total


@coupon
Scenario: Adding a Coupon Functionality
When user adds any product to cart
And user adds any coupon"xyz123"
Then validate the message


@checkoutvalid
Scenario: Checkout valid Functionality
When user logs in, searches, adds a product to cart, and clicks checkout
And user fills all the details like country,city,address,zip,phone and continues
|India  |
|xyz    |
|abc    |
|123456 |
|9988776655|
Then validate the process


@checkoutinvalid
Scenario: Checkout invalid Functionality
When user performs logs in, searches, adds a product to cart, and clicks checkout
And user fills all the details and continues
|India  |
|xyz    |
|abc    |
|123456 |
Then validate the entire process



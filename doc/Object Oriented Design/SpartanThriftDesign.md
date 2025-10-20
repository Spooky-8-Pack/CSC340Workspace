# Spartan Thrift - Software Design 

Version 1  
Prepared by Adrian Aldridge & Gloria Sukidi\
Spartan Thrift\
Oct 21, 2025

Table of Contents
=================
* [Revision History](#revision-history)
* 1 [Product Overview](#1-product-overview)
* 2 [Use Cases](#2-use-cases)
  * 2.1 [Use Case Model](#21-use-case-model)
  * 2.2 [Use Case Descriptions](#22-use-case-descriptions)
    * 2.2.1 [Actor: Farmer](#221-actor-farmer)
    * 2.2.2 [Actor: Customer](#222-actor-customer) 
* 3 [UML Class Diagram](#3-uml-class-diagram)
* 4 [Database Schema](#4-database-schema)

## Revision History
| Name | Date    | Reason For Changes  | Version   |
| ---- | ------- | ------------------- | --------- |
|  Ad  |10/21    | Initial Design      |    1      |
|      |         |                     |           |
|      |         |                     |           |

## 1. Product Overview
Spartan Thrift is a web application to ease the buying and selling of clothing between students on UNCG campus. Sellers will list clothing for sale and ship to potential customers. Customers will be able to browse available clothing, and order from the sellers shops. This is useful for both clearing out an old wardrobe, and expanding a new one. 

## 2. Use Cases
### 2.1 Use Case Model
![Use Case Model](https://github.com/Spooky-8-Pack/CSC340Workspace/blob/aaldridge-milestone4/doc/Object%20Oriented%20Design/Use-Case-Model.png)

### 2.2 Use Case Descriptions

#### 2.2.1 Actor: Seller
##### 2.2.1.1 Sign Up

##### 2.2.1.2 Log In

##### 2.2.1.3 Update Profile

##### 2.2.1.4 List Clothing

##### 2.2.1.4 View Customer Stats


#### 2.2.2 Actor: Customer
##### 2.2.2.1 Sign Up
A customer can sign up to create their profile with their name, email, password, and address. Emails must be unique.
##### 2.2.2.2 Log In
A customer shall be able to sign in using their registred email and password. After logging in, the customer shall be directed their dashboard where they see recommended products and categories to shop by.
##### 2.2.2.3 Browse Clothing
A customer shall be able to view available clothing. They can do this from the home page or using the search function. They can filter clothing by style, size, or seller. They will also be able to select a specific item to view more details.
##### 2.2.1.4 Add Clothing to Cart
Upon selecting an item, a customer shall be able to purchase the item by adding to their cart and checking out through their cart. Or save for later by adding to a wishlist.
##### 2.2.1.5 Review Produce Box
A customer may write a review for an item they purchased. They can rate the delivery and quality of the item.

## 3. UML Class Diagram
![UML Class Diagram](https://github.com/Spooky-8-Pack/CSC340Workspace/blob/aaldridge-milestone4/doc/Object%20Oriented%20Design/UML-Diagram.png)
## 4. Database Schema
![UML Class Diagram]()
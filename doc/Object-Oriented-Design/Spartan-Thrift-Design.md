# LocalHarvest Hub - Software Design 

Version 1  
Prepared by Gloria Sukidi\
Spartan Thrift\
Oct 19, 2025

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
|  Gl  |10/19    | Initial Design      |    1      |
|      |         |                     |           |
|      |         |                     |           |

## 1. Product Overview
Spartan Thrift is an online commerce website where students can buy and sell used closed. Sellers create shop profiles and list items to sell. Customers purchase items from shops.

## 2. Use Cases
### 2.1 Use Case Model
![Use Case Model](https://github.com/csc340-uncg/f25-team0/blob/main/doc/Object-Oriented-Design/Use-Case-Model.png)

### 2.2 Use Case Descriptions

#### 2.2.1 Actor: Provider
##### 2.2.1.1 Sign Up
A provider shall create a profile using their first and last name, email, and password. They shall provide a shop name, description, location and an optional shop image.
##### 2.2.1.2 Log In
A provider shall sign in using their registered email and password. After logging in, the provider shall be directed to their dashboard where they see an overview of their shop and stats.

##### 2.2.1.3 Update Profile
A provider shall modify their profile by going to their profile page. They can change their email, password, and shop.
##### 2.2.1.4 Create Produce Boxes
A provider shall be able to create new clothing listings. They shall provide a item name, description, and price. The added item shall be associated to the provider and their shop.
##### 2.2.1.4 View Customer Stats
A provider shall be able to view statistics such as total revenue, most visited item, and average ratings.

#### 2.2.2 Actor: Customer
##### 2.2.2.1 Sign Up
A customer can sign up to create their profile with their name, email, password, and address. Emails must be unique.
##### 2.2.2.2 Log In
A customer shall be able to sign in using their registred email and password. After logging in, the customer shall be directed their dashboard where they see an overview of their subscriptions.
##### 2.2.2.3 Browse Produce Boxes
A customer shall be able to view available produce boxes. They can do this from the home page or using a search function. They can also filter boxes by name, descriptions, or farm. They will also be able to select one box and view more details.
##### 2.2.1.4 Subscribe to Produce Box
Upon selecting a box, a customer shall be able to subscribe for the box using a one-click action. This box will then appear on their dashboard, and they will be able to ammend the subscription.
##### 2.2.1.5 Review Produce Box
A customer may write a review for a box they subscribed to. They will be able to rate the box based on freshness and delivery.

## 3. UML Class Diagram
![UML Class Diagram](https://github.com/csc340-uncg/f25-team0/blob/main/doc/Object-Oriented-Design/class-diagram.png)
## 4. Database Schema
![UML Class Diagram](https://github.com/csc340-uncg/f25-team0/blob/main/doc/Object-Oriented-Design/schema.png)
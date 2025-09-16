# Software Requirements Specification
## For Spartan Thrift

Version 0.1  
Prepared by Gloria Sukidi & Adrian Aldridge
CSC 340
September 16, 2025

Table of Contents
=================
* [Revision History](#revision-history)
* 1 [Introduction](#1-introduction)
  * 1.1 [Document Purpose](#11-document-purpose)
  * 1.2 [Product Scope](#12-product-scope)
  * 1.3 [Definitions, Acronyms and Abbreviations](#13-definitions-acronyms-and-abbreviations)
  * 1.4 [References](#14-references)
  * 1.5 [Document Overview](#15-document-overview)
* 2 [Product Overview](#2-product-overview)
  * 2.1 [Product Functions](#21-product-functions)
  * 2.2 [Product Constraints](#22-product-constraints)
  * 2.3 [User Characteristics](#23-user-characteristics)
  * 2.4 [Assumptions and Dependencies](#24-assumptions-and-dependencies)
* 3 [Requirements](#3-requirements)
  * 3.1 [Functional Requirements](#31-functional-requirements)
    * 3.1.1 [User Interfaces](#311-user-interfaces)
    * 3.1.2 [Hardware Interfaces](#312-hardware-interfaces)
    * 3.1.3 [Software Interfaces](#313-software-interfaces)
  * 3.2 [Non-Functional Requirements](#32-non-functional-requirements)
    * 3.2.1 [Performance](#321-performance)
    * 3.2.2 [Security](#322-security)
    * 3.2.3 [Reliability](#323-reliability)
    * 3.2.4 [Availability](#324-availability)
    * 3.2.5 [Compliance](#325-compliance)
    * 3.2.6 [Cost](#326-cost)
    * 3.2.7 [Deadline](#327-deadline)

## Revision History
| Name | Date    | Reason For Changes  | Version   |
| ---- | ------- | ------------------- | --------- |
|Gloria|   9/16  |  Initial SRS        |   1.0     |
|Adrian|   9/16  |  Changed SRS        |   1.0     |
|      |         |                     |           |

## 1. Introduction

### 1.1 Document Purpose
The purpose of the Software Requirements Specification (SRS) is to describe the client-view and developer-view requirements for the Spartan Thrift application. 

### 1.2 Product Scope
The purpose of Spartan Thrift is to provide a convenient online platform for students to buy and sell clothing. We will connect sellers to customers using a web-based application where sellers can list and manage their stock and customers can view and buy clothing they want. We hope to provide a comfortable user experience and offer the best service possible.

### 1.3 Definitions, Acronyms and Abbreviations 

- Java: Programming language used for the backend of Spartan Thrift
- API: Application Programming Interface. Used to Interface with the backend and frontend of application.
- HTML: Hypertext Markup Language. Used to design frontend of Spartan thrift
- CSS: Cascading Style Sheets. Used to add style and appearance to web app.
- JavaScript: A computer programiming language commonly used to create interactive effects within web browsers. Used   in conjunction with JAVA and HTML. 

### 1.4 References

### 1.5 Document Overview
Section 1 is a general introduction to the document, it is intended for general readers. Section 2 focuses on the product and it's function, this section is intended for potential customers and stakeholders. Section 3 specifies requirments and constraints for the product and development process. It is intended for stakeholders and the development team. 

## 2. Product Overview
Spartan Thrift is a web-based application designed to connect students looking to buy or sell clothing. Customers can browse listed clothing, purchase items, and leave reviews based on quality of clothing and delivery. Sellers can manage listings, track customer orders, and respond to customer reviews. The system supports both customers and sellers. Each tailor-made to provide the best experience to the end user. 

### 2.1 Product Functions
- Customer Functions
  - Search listed clothing items
  - Add/remove items to/from a cart to purchase
  - Add/remove items to/from a wishlist to save for later
  - Write reviews on purchased items
- Seller Functions
  - List clothing items for sale
  - Manage listed items
  - View customer statistics and active orders
  - Respond to reviews on their products

### 2.2 Product Constraints
The current plan is to use Java for the backend and HTML/CSS and JavaSript for the frontend, this would limit the program to only running on computers with Java JDK 21 or higher installed. It would also present problems for scaling up. With a short deadline on the team, this may be the largest scope the project can acheive. 
  
### 2.3 User Characteristics
Our application should be usable by most anyone who can use a web browser. As long as users have basic knowledge on how to use most websites and know what kind of clothing they would wish to buy/sell they should be an expert on our application. 

### 2.4 Assumptions and Dependencies
We will use Java, with HTML/CSS and JavaScript. Our project will be dependent on an external currency conversion API to allow customers to view prices for items in their local currency. 

## 3. Requirements

### 3.1 Functional Requirements 
- FR0: The system shall allow users to create accounts as a customer or provider using a username and password.
- - There shall be two separate sign-in pages for providers and customers to access respective dashboards.
- FR1: The system shall allow providers to add product listings with images, a description, prices, clothing type, size, and quantity.
- - The clothing type shall have a search and filter option.
- FR2: The system shall allow customers to view products by viewing a specific provider's store or a total list of products from all providers.
- FR3: The user shall be able to add items to a cart.
- FR4: The user shall be able to add items to a wishlist.
- FR5: The user shall be able to rate and review purchased products.
- - The review shall include a comment and overall rating.
- FR6: The system shall allow a provider to respond to a review.
- FR7: The system shall allow users to modify their profiles at any time.

#### 3.1.1 User interfaces
Web pages using HTML, CSS, and JavaScript. Back-end development will utilize Java.

#### 3.1.2 Hardware interfaces
Devices with web browser capabilities. 

#### 3.1.3 Software interfaces
- Java jdk 24

### 3.2 Non Functional Requirements 

#### 3.2.1 Performance
- NFR0: Spartan Thrift will consume less than 100MB of memory.
- NFR1: Novice users shall be able to add and purchase products in less than 5 minutes.
- NFR2: Expert users shall be able to add and purchase products in less than 2 minutes.
#### 3.2.2 Security
- NFR3: The system shall be available only to authorized users with a username and password.

#### 3.2.3 Reliability

#### 3.2.4 Availability
- NFR4: Spartan Thrift shall be available 24/7. Scheduled maintenance shall be initialized at night during low activity hours.

#### 3.2.5 Compliance

#### 3.2.6 Cost
- NFR5: We expect to spend zero dollars developing Spartan Thrift.

#### 3.2.7 Deadline
- NFR6: The final product must be delivered by December 2025.
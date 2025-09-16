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

### 1.3 Definitions, Acronyms and Abbreviations                                                                                                                                                                          |
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
This section specifies the software product's requirements. Specify all of the software requirements to a level of detail sufficient to enable designers to design a software system to satisfy those requirements, and to enable testers to test that the software system satisfies those requirements.

The specific requirements should:
* Be uniquely identifiable.
* State the subject of the requirement (e.g., system, software, etc.) and what shall be done.
* Optionally state the conditions and constraints, if any.
* Describe every input (stimulus) into the software system, every output (response) from the software system, and all functions performed by the software system in response to an input or in support of an output.
* Be verifiable (e.g., the requirement realization can be proven to the customer's satisfaction)
* Conform to agreed upon syntax, keywords, and terms.

#### 3.1.1 User interfaces
Define the software components for which a user interface is needed. Describe the logical characteristics of each interface between the software product and the users. This may include sample screen images, any GUI standards or product family style guides that are to be followed, screen layout constraints, standard buttons and functions (e.g., help) that will appear on every screen, keyboard shortcuts, error message display standards, and so on. Details of the user interface design should be documented in a separate user interface specification.

Could be further divided into Usability and Convenience requirements.

#### 3.1.2 Hardware interfaces
Describe the logical and physical characteristics of each interface between the software product and the hardware components of the system. This may include the supported device types, the nature of the data and control interactions between the software and the hardware, and communication protocols to be used.

#### 3.1.3 Software interfaces
Describe the connections between this product and other specific software components (name and version), including databases, operating systems, tools, libraries, and integrated commercial components. Identify the data items or messages coming into the system and going out and describe the purpose of each. Describe the services needed and the nature of communications. Refer to documents that describe detailed application programming interface protocols. Identify data that will be shared across software components. If the data sharing mechanism must be implemented in a specific way (for example, use of a global data area in a multitasking operating system), specify this as an implementation constraint.

### 3.2 Non Functional Requirements 

#### 3.2.1 Performance
If there are performance requirements for the product under various circumstances, state them here and explain their rationale, to help the developers understand the intent and make suitable design choices. Specify the timing relationships for real time systems. Make such requirements as specific as possible. You may need to state performance requirements for individual functional requirements or features.

#### 3.2.2 Security
Specify any requirements regarding security or privacy issues surrounding use of the product or protection of the data used or created by the product. Define any user identity authentication requirements. Refer to any external policies or regulations containing security issues that affect the product. Define any security or privacy certifications that must be satisfied.

#### 3.2.3 Reliability
Specify the factors required to establish the required reliability of the software system at time of delivery.

#### 3.2.4 Availability
Specify the factors required to guarantee a defined availability level for the entire system such as checkpoint, recovery, and restart.

#### 3.2.5 Compliance
Specify the requirements derived from existing standards or regulations

#### 3.2.6 Cost
Specify monetary cost of the software product.

#### 3.2.7 Deadline
Specify schedule for delivery of the software product.

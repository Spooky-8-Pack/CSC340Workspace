# Spartan Thrift Requirements Testing
## Actors
- Provider
- Customer

### Use Cases
#### 1. Provider: Create provider profile use case:
1. Provider P1 creates a profile and logs in for the first time.
2. P1 creates new products S1 and S2 (categorized by item type) 
3. P1 logs out.

#### 2. Customer: Create customer profile:
1. Customer C1 creates a profile and logs in for the first time.

#### 3. Customer:  View and purchase products:
2. C2 views available products S1 and S2
3. C2 purchases product S1.

#### 4. Customer: Write review
1. C2 log in and views their purchases.
2. C2 writes a review of service S1. C2 exits.

#### 5. Customer: Modify profile
1. C1 logs in and modifies their profile.
2. C1 views purchase S1 and the  review.
3. C1 exits.

#### 6. Provider:  Reply to Review, View Customer Statistics, & Modify Profile use cases
1. Provider P1 logs in and reads their review and replies. 
2. P1 views customer statistics.  
3. P1 modifies his profile or shop.
4. P1 exits.
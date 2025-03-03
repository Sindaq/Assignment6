# Assignment6
[Final GitHub actions workflow](https://github.com/Sindaq/Assignment6/actions/runs/13622546526/job/38074373458)\
Github actions successfully executed and passed all tests, disabled\
test that found a bug. Workflow generated checkstyle-result.xml and\
jacoco coverage report.
## Part 1.
### Specification-Based Testing
**Single Input:**\
_ISBN:_
1. Null
2. Empty
3. ISBN Not found
4. ISBN Found

_quantity:_
1. Quantity > Book quantity
2. Quantity <= Book quantity

**Combination Input**
1. Null ISBN | Any quantity
2. Empty ISBN | Any quantity
3. ISBN Length Not found | (Quantity > Book quantity | Quantity <= Book quantity)
4. ISBN Length Found | (Quantity > Book quantity | Quantity <= Book quantity)

### Structural-Based Testing
100% coverage of BarnesAndNoble accomplished during specification-based testing

## Part 3.
### Description:
This will calculate the 'rule' like promotions and deals, for each item in the cart
and will return the final price.

### Specification-Based testing
**Unit testing**\
**Rules:**
1. rules is empty
2. rules is not empty

**Cart:**
1. cart is empty
2. cart is not empty

**Integration testing**\
**Rules and Cart:**
1. not empty rule && (not empty cart || empty cart)
2. empty rule && (not empty cart || empty cart)
> Bug in 2, empty rule and non-empty cart should still
> return the price of the cart. It doesn't calculate anything
> since it doesn't make it in the for loop.
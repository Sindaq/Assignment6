# Assignment6
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

_Combination Input_
1. Null ISBN | Any quantity
2. Empty ISBN | Any quantity
3. ISBN Length Not found | (Quantity > Book quantity | Quantity <= Book quantity)
4. ISBN Length Found | (Quantity > Book quantity | Quantity <= Book quantity)

## Structural-Based Testing
100% coverage of BarnesAndNoble accomplished during specification-based testing


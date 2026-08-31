# Service Implementation Practice Guide

Implement the ServiceImpl methods in this order:

1. EASY
   - findAll / findById
   - DTO mapping
   - String comparison
   - simple filtering

2. EASY -> MEDIUM
   - BigDecimal.compareTo()
   - LocalDate calculations
   - Optional handling
   - nested entity relationships

3. MEDIUM
   - nested loops
   - boolean flags
   - break / continue
   - counters
   - accumulators
   - compound conditions

4. MEDIUM -> HARD
   - totals across related tables
   - percentages
   - date ranges
   - boundary conditions
   - null handling

5. HARD
   - multiple conditions together
   - derived business classifications
   - risk/severity categories
   - several calculations in one loop
   - avoid duplicate results
   - validate input and edge cases

## Rule for this project

Do NOT change the controllers, repositories, entities or DTOs initially.
Only implement the methods inside `service/impl`.

Use Core Java first:
- for loops
- enhanced for loops
- if / else-if / else
- boolean flags
- break / continue
- counters
- accumulators
- String methods
- LocalDate
- BigDecimal

After completing the basic version, you can refactor the same solution using streams and repository queries.

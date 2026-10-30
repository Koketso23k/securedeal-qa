# SecureDeal – Manual Test Sheet

Manual testing (means: a person runs the program by hand and checks the result).
Each test below was run by typing the inputs into `Main` and writing down what happened.

**Tester:** Koketso Tlouamma
**Date run:** 29 October 2026
**Build tested:** commit "Add simple text menu" and later

| ID | What we are testing | Steps (inputs typed in) | Expected result | Actual result | Pass / Fail |
|----|---------------------|-------------------------|-----------------|---------------|-------------|
| M1 | Create a valid transaction and set status to RECEIVED | Buyer `Thabo`, Item `Laptop`, Price `4500`, Status `RECEIVED` | Transaction created as PENDING, then updated to RECEIVED | Created as PENDING, updated to RECEIVED | Pass |
| M2 | Empty item name is rejected | Buyer `Thabo`, Item (press Enter, leave empty), Price `100` | Error: item name cannot be empty | `Error: Item name cannot be empty` | Pass |
| M3 | Negative price is rejected | Buyer `Thabo`, Item `Laptop`, Price `-50` | Error: price must be more than zero | `Error: Price must be more than zero` | Pass |
| M4 | Zero price is rejected | Buyer `Thabo`, Item `Laptop`, Price `0` | Error: price must be more than zero | `Error: Price must be more than zero` | Pass |
| M5 | Empty buyer name is rejected | Buyer (leave empty), Item `Laptop`, Price `100` | Error: buyer name cannot be empty | `Error: Buyer name cannot be empty` | Pass |
| M6 | Price that is not a number is rejected | Buyer `Thabo`, Item `Laptop`, Price `abc` | Error: price must be a number | `Error: price must be a number` | Pass |
| M7 | Status that does not exist is rejected clearly | Buyer `Thabo`, Item `Laptop`, Price `100`, Status `LOST` | A clear message listing the allowed statuses | `Error: No enum constant securedeal.TransactionStatus.LOST` | **Fail** (see BUG-1) |

## Bugs found

| Bug ID | Found in | Description | Severity | Status |
|--------|----------|-------------|----------|--------|
| BUG-1 | M7 | When the user types a status that does not exist, the error message is a confusing technical one (`No enum constant ...`). It should say something like "Status must be PENDING, SHIPPED or RECEIVED". The program does reject the bad status, so nothing breaks, but the message is not user friendly. | Low | Open |

## Summary

- Tests run: 7
- Passed: 6
- Failed: 1 (BUG-1)

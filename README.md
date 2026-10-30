# SecureDeal – QA

A small Java app that records a **buyer name**, an **item name**, a **price** and a
**status** (`PENDING`, `SHIPPED` or `RECEIVED`) for a deal.

The app is deliberately small. **The focus of this project is testing it properly.**

## What is being tested

| Rule | Expected behaviour |
|------|--------------------|
| Valid buyer, item and price | Transaction is created and starts as `PENDING` |
| Empty, blank or missing item name | Rejected with an error |
| Empty buyer name | Rejected with an error |
| Negative or zero price | Rejected with an error |
| Status changed to `SHIPPED` or `RECEIVED` | Status updates correctly |
| Missing status | Rejected with an error |

## Manual testing and automated testing

- **Manual testing** (means: a person runs the program and checks the result by hand).
  See [`manual-test-sheet.md`](manual-test-sheet.md): 7 test cases, with the steps,
  expected result, actual result, and any bugs found.
- **Automated testing** (means: code runs the checks for us, in seconds, every time).
  Done with JUnit (a Java tool for writing automatic tests) in `src/test/java`.

Manual tests are good for exploring and spotting things that feel wrong. Automated tests are
good for re hecking the same rules quickly after every change.

## Test Automation Pyramid

The pyramid says: have **many small, fast tests at the bottom**, fewer medium tests in the
middle, and only a **few big tests at the top**, because big tests are slower and cost more
to keep running.

```
        /  UI / end-to-end  \      few   – the manual walk-through of the menu (Main)
       /---------------------\
      /    Integration tests   \   some  – (planned) checking parts work together
     /---------------------------\
    /        Unit tests            \ many – TransactionTest (one small rule per test)
```

In this project:
- **Unit tests** (means: each test checks one small piece of code): `TransactionTest`.
- **Performance test** (a non-functional test: it checks how fast, not just whether it is
  correct): `PerformanceTest` creates 10,000 transactions and checks it takes under 1 second.
- **Manual end-to-end checks** run through the real menu: see the manual test sheet.

## Test coverage

Coverage (means: the percentage of the code that the tests actually run) is measured with
JaCoCo. After running the tests, open `target/site/jacoco/index.html` in a browser.

**Coverage result:** _fill in after you run it (for example: `Transaction` 100%)._

## Bugs found

| ID | Description | Status |
|----|-------------|--------|
| BUG-1 | Typing an unknown status (for example `LOST`) shows a confusing technical error message instead of "Status must be PENDING, SHIPPED or RECEIVED". | Open |

## How to run the tests

You need Java 17 or newer and Maven.

```
mvn test
```
 **Run 'All Tests'**.

## Project layout

```
src/main/java/securedeal/   the app (Transaction, TransactionStatus, Main)
src/test/java/securedeal/   automated tests (TransactionTest, PerformanceTest)
manual-test-sheet.md        manual test cases and bugs
```

## Test results

**Automated test results:** _17 passed, 0 failed._

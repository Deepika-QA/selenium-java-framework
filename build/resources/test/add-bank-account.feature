Feature: For an existing xero user add a bank account inside any Xero Organisation

  Scenario: Add an ANZ(NZ) bank account
    Given User signed in xero account
    When User tries to add an ANZ bank account
    Then Bank Account is added









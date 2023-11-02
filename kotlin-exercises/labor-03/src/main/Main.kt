package main

fun main() {
    val johnDoe = Client("John Doe", "123 Main St")
    val aliceSmith = Client("Alice Smith", "456 Elm St")

    println("Before adding accounts:")
    println(johnDoe)
    println(aliceSmith)

    val account1 = Account().apply {
        generateAccountNumber()
        deposit(100.0) // Setting balance via deposit
    }

    val account2 = Account().apply {
        generateAccountNumber()
        deposit(200.0) // Setting balance via deposit
    }

    johnDoe.addAccount(account1)
    aliceSmith.addAccount(account2)

    println("\nAfter adding accounts:")
    println(johnDoe)
    println(aliceSmith)

    account1.deposit(50.0)
    account2.deposit(100.0)
    println("\nAfter deposits:")
    println("Balance of account 1: ${account1.currentBalance()}")
    println("Balance of account 2: ${account2.currentBalance()}")

    println("\nAfter withdraws:")
    account1.withdraw(50.0)
    account2.withdraw(100.0)

    val savingsAccount1 = SavingsAccount(account1.accountNumber, 0.02) // Assuming a 2% interest rate
    val savingsAccount2 = SavingsAccount(account2.accountNumber, 0.03) // Assuming a 3% interest rate
    johnDoe.addAccount(savingsAccount1)
    aliceSmith.addAccount(savingsAccount2)

    savingsAccount1.deposit(100.0) // Setting balance via deposit
    savingsAccount2.deposit(200.0) // Setting balance via deposit

    savingsAccount1.applyInterest()
    savingsAccount2.applyInterest()

    println("\nDisplay accounts for John Doe:")
    johnDoe.displayAccounts()

    println("\nDisplay accounts for Alice Smith:")
    aliceSmith.displayAccounts()

    println("\nPrint John Doe's savings accounts:")
    johnDoe.printAllSavingsAccounts()

    println("\nPrint Alice Smith's savings accounts:")
    aliceSmith.printAllSavingsAccounts()

    println("\nCalculate the total amount of money for John Doe:")
    println(johnDoe.calculateTotalAmountOfMoney())

    johnDoe.removeAccount(account1)
    println("\nAfter removing an account from John Doe's list:")
    johnDoe.displayAccounts()

    println("Before sorting accounts for Alice Smith:")
    aliceSmith.displayAccounts()

    println("\nSort accounts by balance for Alice Smith:")
    aliceSmith.sortAccounts(Order.BALANCE)
    aliceSmith.displayAccounts()

    println("\nSort accounts by account name for Alice Smith:")
    aliceSmith.sortAccounts(Order.ACCOUNT_NAME)
    aliceSmith.displayAccounts()
}

package main

class CheckingAccount(accountNumber: String, private val overdraftLimit: Double = 0.0) : Account(accountNumber) {

    override fun withdraw(amount: Double) {
        if (amount <= balance + overdraftLimit) {
            balance -= amount
            println("Withdrawn $amount")
        } else {
            println("Insufficient funds")
        }
    }

    override fun toString(): String {
        return "CheckingAccount(balance=$balance, overdraftLimit=$overdraftLimit, accountNumber='$accountNumber')"
    }
}

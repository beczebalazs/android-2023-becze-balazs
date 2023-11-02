package main

open class Account(var accountNumber: String = "") {
    var balance: Double = 0.0
        protected set

    fun deposit(amount: Double) {
        if (amount > 0) {
            balance += amount
            println("Deposited $amount")
        } else {
            println("Invalid amount")
        }
    }

    fun currentBalance(): Double {
        return balance
    }

    open fun withdraw(amount: Double) {
        if (amount <= balance) {
            balance -= amount
            println("Withdrawn $amount")
        } else {
            println("Insufficient funds")
        }
    }

    override fun toString(): String {
        return "Account(balance=$balance, accountNumber='$accountNumber')"
    }

    // Generates a random account number prefixed with "OTP"
    fun generateAccountNumber() {
        val randomNumber = (1000..9999).random().toString()
        accountNumber = "OTP$randomNumber"
    }
}

package main

class SavingsAccount(accountNumber: String, private val interestRate: Double) : Account(accountNumber) {

    fun applyInterest() {
        val interest = balance * interestRate
        balance += interest
        println("Interest applied: $interest")
    }

    override fun toString(): String {
        return "SavingsAccount(balance=$balance, interestRate=$interestRate, accountNumber='$accountNumber')"
    }
}

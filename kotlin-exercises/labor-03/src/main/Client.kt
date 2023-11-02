package main

open class Client(val name: String, val address: String) {
    private val accounts: MutableList<Account> = mutableListOf()

    fun addAccount(account: Account) {
        accounts.add(account)
    }

    fun removeAccount(account: Account) {
        accounts.remove(account)
    }

    fun displayAccounts() {
        accounts.forEach(::println)
    }

    fun printAllSavingsAccounts() {
        accounts.filterIsInstance<SavingsAccount>().forEach(::println)
    }

    fun calculateTotalAmountOfMoney(): Double {
        return accounts.sumOf(Account::currentBalance)
    }

    fun sortAccounts(criteria: Order) {
        when (criteria) {
            Order.BALANCE -> accounts.sortBy(Account::currentBalance)
            Order.ACCOUNT_NAME -> accounts.sortBy(Account::accountNumber)
        }
    }

    override fun toString(): String {
        return "Client(name='$name', address='$address', accounts=${accounts.joinToString()})"
    }
}

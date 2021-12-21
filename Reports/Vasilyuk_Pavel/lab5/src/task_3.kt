fun main(args: Array<String>) {
    val client1 = Payments.Client()
    val client2 = Payments.Client()
    val good1 = Sum()
    good1.setSum = 2000
    val admin: Administrator = Administrator()
    println("Count client1: " + client1.GetCount())
    client1.Pay(good1)
    println("Count client1: " + client1.GetCount())
    println("Count client2: " + client2.GetCount())
    client1.PayTo(client2.GetAccount(), 10000)
    println("Count client1: " + client1.GetCount())
    println("Count client2: " + client2.GetCount())
    println("Close Account client2")
    client2.CloseAccount()
    println("Close Card client2")
    client2.CloseCard()
    println("Admin close Card client1")
    admin.BlockClientCard(client1)
    admin.ShowInfo()
    client2.ShowInfo()
}


class Sum {
    var sum = 0

    var setSum: Int
        get() = sum
        set(value) {
            sum = value
        }
}

object Payments {
    var Clients = ArrayList<Client>()

    abstract class User {
        open fun ShowInfo() {}
    }

    class Client : User() {
        private val account: Account
        private val card: CCard
        private val _code: Int = (100..999).random()
        override fun ShowInfo() {
            println("$_code root")
        }

        fun Pay(sum: Sum?) // using Card
        {
            if (sum != null) {
                card.Pay(sum)
            }
        }

        fun PayTo(other: Account?, sum: Int) // using Card
        {
            if (other != null) {
                card.PayTo(other, sum)
            }
        }

        fun CloseCard() // using Card
        {
            card.Close()
        }

        fun CloseAccount() // using Account
        {
            account.CloseAccount()
        }

        fun GetCount(): Int {
            return card.Count()
        }

        fun GetAccount(): Account {
            return account
        }

        init {
            account = Account(5000)
            card = CCard(account)
            Clients.add(this)
        }
    }
}

class Administrator : Payments.User() {
    override fun ShowInfo() {
        println("Admin root")
    }

    fun BlockClientCard(obj: Payments.Client) {
        if (obj.GetCount() < 0) {
            obj.CloseCard()
        } else {
            println("Card is not blocked. The count is correct.")
        }
    }
}

class CCard(_account: Account) {
    private var Account: Account
    private var Closed = false
    fun Close() {
        Closed = true
        println("The card was closed.")
    }

    fun Count(): Int // return Count from Account
    {
        return if (Closed) {
            println("Card is locked")
            0
        } else {
            Account.count
        }
    }

    fun Pay(obj: Sum) // taking Good and change our Count
    {
        if (Closed) {
            println("Card is locked")
            return
        } else {
            Account.TakeSum(obj.sum)
            println("The good was paid.")
        }
    }

    fun PayTo(other: Account, sum: Int) {
        if (Closed) {
            println("Card is locked")
            return
        } else {
            Account.TakeSum(sum)
            other.AddSum(sum)
            println("The sum was sent to the other client.")
        }
    }

    init  // any Card has Account
    {
        Account = _account
    }
}

class Account(_count: Int) {
    var number = 0
        private set
    var count = 0
    private var validation = false
        private set

    fun CloseAccount() {
        validation = false
        println("The account was closed.")
    }

    fun AddSum(sum: Int) // add some sum to Count
    {
        if (!validation) {
            println("Account is not valid")
            return
        } else {
            count = count + sum
        }
    }

    fun TakeSum(sum: Int) // take some sum from Count
    {
        if (!validation) {
            println("Account is not valid")
            return
        } else {
            count = count - sum
        }
    }

    init {
        number = (1000..9999).random() // the number is random value
        count = _count // open on our private Sum
        validation = true // default - Account is valid
    }
}
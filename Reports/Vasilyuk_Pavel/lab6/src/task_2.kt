fun main(args: Array<String>) {
    val myCard = ElectronicCard(Passport(), InsurancePolicy(), BankCard())
    myCard.ShowInfo()
    myCard.ShowInsurance()
    myCard.PayFor()
}

class Passport {
    fun ShowInfo() {
        println("You show the information")
    }
}

class InsurancePolicy {
    fun ShowInsurance() {
        println("You show the insurance")
    }
}

class BankCard {
    fun PayFor() {
        println("You have paid for")
    }
}

class ElectronicCard(
    private val passport: Passport,
    private val insurancePolic: InsurancePolicy,
    private val bankCard: BankCard
) {
    fun ShowInfo() {
        passport.ShowInfo()
    }

    fun ShowInsurance() {
        insurancePolic.ShowInsurance()
    }

    fun PayFor() {
        bankCard.PayFor()
    }
}
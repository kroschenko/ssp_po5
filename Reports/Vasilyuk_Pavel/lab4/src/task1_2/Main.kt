fun main(args: Array<String>) {
    var payment:Payment = Payment()

    var frstItm:Payment.Items = Payment.Items("Milk",10)
    var scndItm:Payment.Items = Payment.Items("Salt",5)
    var thrdItm:Payment.Items = Payment.Items("Egg",2)

    payment.addItem(frstItm)
    payment.addItem(scndItm)
    payment.addItem(thrdItm)

    println("BILL { ${frstItm.toString()}, ${scndItm.toString()}, ${thrdItm.toString()} }")
    println("Summ: " + payment.sum())

// --------------------------------------------------------------------- //

    val str = Strings("Hello world!")
    val pgph = Paragraph(2, str)
    pgph.printPgph()
}
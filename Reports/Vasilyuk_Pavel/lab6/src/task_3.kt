 fun main(args: Array<String>) {
     val matrixPrinter = Context(MatrixPrinter())
     matrixPrinter.ExecuteAlgorithm()
     val laserPrinter = Context(LaserPrinter())
     laserPrinter.ExecuteAlgorithm()
     val colorPrinter = Context(ColorPrinter())
     colorPrinter.ExecuteAlgorithm()
    }

interface IPrinter {
    fun Print()
}

class ColorPrinter : IPrinter {
    override fun Print() {
        println("Color print")
    }
}

class MatrixPrinter : IPrinter {
    override fun Print() {
        println("Matrix print")
    }
}

class LaserPrinter : IPrinter {
    override fun Print() {
        println("Laser print")
    }
}

class Context(type: IPrinter?) {
    var contextPrinter: IPrinter? = null

    fun ExecuteAlgorithm() {
        contextPrinter!!.Print()
    }

    init {
        contextPrinter = type
    }
}
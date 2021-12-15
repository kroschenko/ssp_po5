fun main(args: Array<String>) {
	val pclient = Client(PetroleFactory())
	pclient.TestingRun()
	val dclient = Client(DieselFactory())
	dclient.TestingRun()
	}

abstract class AbstractFactory {
	abstract fun CreatePassengerCar(): PassengerCar
	abstract fun CreateTruckCar(): TruckCar
}

class DieselFactory : AbstractFactory() {
	override fun CreatePassengerCar(): PassengerCar {
		return DieselPassengerCar()
	}

	override fun CreateTruckCar(): TruckCar {
		return DieselTruckCar()
	}
}

class PetroleFactory : AbstractFactory() {
	override fun CreatePassengerCar(): PassengerCar {
		return PetrolePassengerCar()
	}

	override fun CreateTruckCar(): TruckCar {
		return PetroleTruckCar()
	}
}

abstract class PassengerCar {
	abstract fun GetInfo()
}

abstract class TruckCar {
	abstract fun GetInfo()
}

class DieselPassengerCar : PassengerCar() {
	override fun GetInfo() {
		println("Diesel passenger car is working")
	}
}

class PetrolePassengerCar : PassengerCar() {
	override fun GetInfo() {
		println("Petrole passenger car is working")
	}
}

class DieselTruckCar : TruckCar() {
	override fun GetInfo() {
		println("Diesel truck car is working")
	}
}

class PetroleTruckCar : TruckCar() {
	override fun GetInfo() {
		println("Petrole truck car is working")
	}
}

class Client(private val _factory: AbstractFactory) {
	fun GetPassengerCar(): PassengerCar {
		return _factory.CreatePassengerCar()
	}

	fun GetTruckCar(): TruckCar {
		return _factory.CreateTruckCar()
	}

	fun TestingRun() {
		GetPassengerCar().GetInfo()
		GetTruckCar().GetInfo()
	}
}
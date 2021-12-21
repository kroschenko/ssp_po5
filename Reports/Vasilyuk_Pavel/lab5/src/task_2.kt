private fun Task(obj1: Students, obj2: Students) {
	if (obj1.GetKnoweledge() > obj2.GetKnoweledge()) {
		println("Student1 has taken the automatic offset " + "on the subject from a friend Student2")
	} else if (obj1.GetKnoweledge() < obj2.GetKnoweledge()) {
		println("Student2 has taken the automatic offset " + "on the subject from a friend Student1")
	} else {
		println("They both have gone to the army")
	}
}

private fun money(obj1: Schoolboy, obj2: Schoolboy) {
	if (obj1.GetPower() > obj2.GetPower()) {
		println("Schoolboy1 has taken the money of Schoolboy2")
	} else if (obj1.GetPower() < obj2.GetPower()) {
		println("Schoolboy2 has taken the money of Schoolboy1")
	} else {
		println("They both have gone to the prison")
	}
}

fun main(args: Array<String>) {
	val learners = ArrayList<Learner>()
	val student1 = Students(50, "Kirill", "D")
	val student2 = Students(70, "Daniil", "K")
	val schoolboy1 = Schoolboy(400, "Stas", "School31")
	val schoolboy2 = Schoolboy(300, "Vasua", "School54")
	money(schoolboy1, schoolboy2)
	Task(student1, student2)
	println(schoolboy1.GetDocument())
	println(student2.GetDocument())
	learners.add(student1)
	learners.add(student2)
	learners.add(schoolboy1)
	learners.add(schoolboy2)
	for (item in learners) {
		if (item.javaClass == Student::class.java) {
			println(item.name + " - Student")
		}
		if (item.javaClass == Schoolboy::class.java) {
			println(item.name + " - Schoolboy")
		}
	}
}

abstract class Learner {
	var name: String? = null
	var years = 0
	private var passport: String? = null

	open fun GetDocument(): String? {
		return passport
	}
}

class Students(var knoweledge: Int, name: String, recordbook: String) : Learner() {
	var university: String? = null
	private val recordbook: String
	override fun GetDocument(): String? {
		return recordbook
	}

	fun GetUniversity(): String? {
		return university
	}

	fun GetKnoweledge(): Int {
		return knoweledge
	}

	init {
		this.name = name
		this.recordbook = recordbook
	}
}

class Schoolboy(var power: Int, name: String, journal: String) : Learner() {
	var school: String? = null
	private val _journal: String
	override fun GetDocument(): String? {
		return _journal
	}

	fun GetSchool(): String? {
		return school
	}

	fun GetPower(): Int {
		return power
	}

	init {
		this.name = name
		_journal = journal
	}
}





fun main(args: Array<String>) {
    val student = StudentOfFaculty(3, 10)
    println("Years: " + student.GetYears())
    println("Experience: " + student.GetExperience())
}


interface IAbiturient {
    fun GetYears(): Int
}

abstract class Student(private val years: Int) : IAbiturient {
    override fun GetYears(): Int {
        return years
    }
}

class StudentOfFaculty(years: Int, private val experience: Int) : Student(years) {
    fun GetExperience(): Int {
        return experience
    }
}
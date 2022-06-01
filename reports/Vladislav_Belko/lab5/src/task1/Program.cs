using System;
namespace task1
{
    class Program
    {
        static void Main(string[] args)
        {
            StudentOfFaculty student = new StudentOfFaculty(3, 19);
            Console.WriteLine("Years: " + student.GetYears());
            Console.WriteLine("Experience: " + student.GetExperience());
        }
    }
    public interface IAbiturient
    {
        public int GetYears();
    }
    public abstract class Student : IAbiturient
    {
        public Student(int years)
        {
            _years = years;
        }
        int _years;
        public int GetYears()
        {
            return _years;
        }
    }
    public class StudentOfFaculty : Student
    {
        int _experience;
        public StudentOfFaculty(int years, int experience) : base(years)
        {
            _experience = experience;
        }
        public int GetExperience()
        {
            return _experience;
        }
    }
}

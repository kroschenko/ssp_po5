using System;
using System.Collections.Generic;
using System.Security.Cryptography;
namespace task2
{
    class Program
    {
        static void Task(Student obj1, Student obj2)
        {
            if (obj1.GetKnoweledge() > obj2.GetKnoweledge()) Console.WriteLine("Student1 has taken the automatic offset " +

            "on the subject from a friend Student2");
            else if (obj1.GetKnoweledge() < obj2.GetKnoweledge()) Console.WriteLine("Student2 has taken the automatic offset " +

            "on the subject from a friend Student1");
            else Console.WriteLine("They both have gone to the army :(");
        }
        static void Money(Schoolboy obj1, Schoolboy obj2)
        {
            if (obj1.GetPower() > obj2.GetPower()) Console.WriteLine("Schoolboy1 has taken money of Schoolboy2");
            else if (obj1.GetPower() < obj2.GetPower()) Console.WriteLine("Schoolboy2 has taken the money of Schoolboy1");
            else Console.WriteLine("They both have gone to the prison");
        }
        static void Main(string[] args)
        {
            List<Learner> learners = new List<Learner>();
            Student student1 = new Student(100, "Stas", "U151");
            Student student2 = new Student(500, "Pasha", "H522");
            Schoolboy schoolboy1 = new Schoolboy(1000, "Dima", "GrodnoSchool123");
            Schoolboy schoolboy2 = new Schoolboy(500, "Vasia", "MinskSchool543");
            Money(schoolboy1, schoolboy2);
            Task(student1, student2);
            Console.WriteLine(schoolboy1.GetDocument());
            Console.WriteLine(student2.GetDocument());
            learners.Add(student1);
            learners.Add(student2);
            learners.Add(schoolboy1);
            learners.Add(schoolboy2);

            foreach (var item in learners)
            {
                if (item.GetType() == typeof(Student))
                {
                    Console.WriteLine(item.Name + " - Student");
                }
                if (item.GetType() == typeof(Schoolboy))
                {
                    Console.WriteLine(item.Name + " - Schoolboy");
                }
            }
        }
    }
    public abstract class Learner
    {
        public string Name { get; set; }
        public int Years { get; set; }
        public string Passport { get; set; }
        public virtual string GetDocument()
        {
            return Passport;
        }
    }
    public class Student : Learner
    {
        public Student(int _knoweledge, string _name, string recordbook)
        {
            knoweledge = _knoweledge;
            Name = _name;
            _recordbook = recordbook;
        }
        public int knoweledge;
        public string university;
        string _recordbook;
        public override string GetDocument()
        {
            return _recordbook;
        }
        public string GetUniversity()
        {
            return university;
        }
        public int GetKnoweledge()
        {
            return knoweledge;
        }
    }
    public class Schoolboy : Learner
    {
        public Schoolboy(int _power, string _name, string journal)
        {
            power = _power;
            Name = _name;
            _journal = journal;
        }
        public int power;
        public string school;
        string _journal;
        public override string GetDocument()
        {
            return _journal;
        }
        public string GetSchool()
        {
            return school;
        }
        public int GetPower()
        {
            return power;
        }
    }
}

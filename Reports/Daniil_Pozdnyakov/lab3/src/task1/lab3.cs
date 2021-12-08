using System;

namespace lab3._1._5
{
    class lab3
    {
        static void Main(string[] args)
        {
            int[] arr1 = new int[] { 0, 1, 2, 3, 4, 5, 6, 7, 8, 9 };
            int[] arr2 = new int[] { 10, 11, 12, 13, 14, 15, 16, 17, 18, 19 };

            SetOfIntegers Set1 = new SetOfIntegers(arr1);
            SetOfIntegers Set2 = new SetOfIntegers(arr2);
            SetOfIntegers Set3 = new SetOfIntegers();

            Set3.UnionOfSets(Set1, Set2);
            Set3.Print();

            Set3.BelongsToTheSet(10);
            Set3.BelongsToTheSet(21);
            Set3.BelongsToTheSet(111111111);
            Set3.BelongsToTheSet(7);

            Set2.DeleteElementOfSet(52);
            Set2.Print();

            Set1.AddElementOfSet(17);
            Set1.Print();

            Console.WriteLine(Set1.Equals(Set2));
            Console.WriteLine(Set3.ToString());
        }
    }
}

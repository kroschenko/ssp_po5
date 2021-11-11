using System;

namespace Lab3_1
{
	class Program
	{
		static void Main(string[] args)
		{
			Set set1 = new Set(new double?[] {3, 13});
			Set set2 = new Set(set1.set);
			set1.Print();
			set2.Print();

			set2.DeleteElement(3);
			set2.Print();
			set2.AddElement(32);
			set2.Print();
			set2.AddElement(3);

			Console.WriteLine(set1.Equals(set2));

			Set set3 = set1.CombineSet(set2);
			set3.Print();

			Console.Write(set1.ToString());
		}
	}
}

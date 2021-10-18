using System;

namespace Lab3_1
{
	class Program
	{
		static void Main(string[] args)
		{
			Set set1 = new Set(new double[] { -2, 3.5, 4, 7 });
			Set set2 = new Set(set1.set);
			set1.Print();
			set2.Print();

			set1.AddElement(10);
			set1.Print();
			set2.DeleteElement(3.5);
			set2.Print();

			Console.WriteLine(set1.Equals(set2));

			Set set3 = set1.CombineSet(set2);
			set3.Print();

			Console.Write(set1.ToString());
		}
	}
}

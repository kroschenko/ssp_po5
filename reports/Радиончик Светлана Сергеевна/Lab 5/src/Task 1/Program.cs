using System;

namespace Lab5_1
{
	class Program
	{
		static void Main(string[] args)
		{
			Model model = new Model("x77", 360, "new version.");
			model.Print();

			Console.Read();
		}
	}
}

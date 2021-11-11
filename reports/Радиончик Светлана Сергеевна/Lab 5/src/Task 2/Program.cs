using System;
using System.Collections.Generic;

namespace Lab5_2
{
	class Program
	{
		static void Main(string[] args)
		{
			List<Pet> pets = new List<Pet>();
			pets.Add(new Dog("Bobik", "Black", true));
			pets.Add(new Cat("Simon", "White", true));
			pets.Add(new Parrot("Kesha", "Yellow", false));

			foreach(var item in pets)
			{
				item.DetData();
				Console.WriteLine();
			}
		}
	}
}

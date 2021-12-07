using System;
using System.Threading;

namespace Lab6_1_1
{
	abstract class Selector
	{
		public abstract void FactoryMethod(string name);

		public void Buy(string name)
		{
			Thread.Sleep(10000);
			Console.WriteLine(name);
			Console.WriteLine($"Купить?\n 1 - Да\n 2 - Нет");
			bool choice = true;

			while (choice)
			{
				var n = Console.ReadLine();

				switch (n)
				{
					case "1":
						choice = false;
						Console.WriteLine("Спасибо за покупку!");
						break;
					case "2":
						choice = false;
						Console.WriteLine("Ждём в следующий раз");
						break;
					default:
						Console.WriteLine("Вы ввели неправильное значение. Попробуйте ещё");
						break;
				}
			}
		}
	}
}

using System;
using System.Threading;

namespace Lab6_1_1
{
	class ScaredProduct : IProduct
	{
		public void ChooseInstrument(string name)
		{
			Thread.Sleep(8000);
			Console.WriteLine(name);

			Console.WriteLine("Выберите музыкальный инструмент:\n1 - флейта\n2 - кларнет\n3 - труба\n4 - тромбон");
			bool choice = true;

			while (choice)
			{
				var n = Console.ReadLine();

				switch (n)
				{
					case "1":
						Console.WriteLine("Флейта. ");
						choice = false;
						break;
					case "2":
						Console.WriteLine("Кларнет. ");
						choice = false;
						break;
					case "3":
						Console.WriteLine("Труба. ");
						choice = false;
						break;
					case "4":
						Console.WriteLine("Тромбон. ");
						choice = false;
						break;
					default:
						Console.WriteLine("Вы ввели неправильное значение. Попробуйте ещё");
						break;
				}
			}
		}
	}
}

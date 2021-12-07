using System;
using System.Threading;

namespace Lab6_1_1
{
	class FolkProduct : IProduct
	{
		public void ChooseInstrument(string name)
		{
			Thread.Sleep(8000);
			Console.WriteLine(name);

			Console.WriteLine("Выберите музыкальный инструмент:\n1 - гусли\n2 - бубен\n3 - волынка\n4 - свирель");
			bool choice = true;

			while (choice)
			{
				var n = Console.ReadLine();

				switch (n)
				{
					case "1":
						Console.WriteLine("Гусли. ");
						choice = false;
						break;
					case "2":
						Console.WriteLine("Бубен. ");
						choice = false;
						break;
					case "3":
						Console.WriteLine("Волынка. ");
						choice = false;
						break;
					case "4":
						Console.WriteLine("Свирель. ");
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

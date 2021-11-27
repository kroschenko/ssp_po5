using System;

namespace Lab6_1
{
	class FolkMusic : IStrategy
	{
		public string ChooseInstrument()
		{
			Console.WriteLine("Выберите музыкальный инструмент:\n1 - гусли\n2 - бубен\n3 - волынка\n4 - свирель");
			
			while (true)
			{
				var n = Console.ReadLine();

				switch (n)
				{
					case "1":
						return "Гусли. ";
					case "2":
						return "Бубен. ";
					case "3":
						return "Волынка. ";
					case "4":
						return "Свирель. ";
					default:
						Console.WriteLine("Вы ввели неправильное значение. Попробуйте ещё");
						break;
				}
			}
		}
	}
}
